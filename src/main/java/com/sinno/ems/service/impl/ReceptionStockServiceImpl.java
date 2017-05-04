package com.sinno.ems.service.impl;

import com.google.common.collect.Lists;
import com.sinno.ems.dto.*;
import com.sinno.ems.entities.*;
import com.sinno.ems.exception.*;
import com.sinno.ems.mapper.*;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.ReceptionStockService;
import com.sinno.ems.util.EmsComprator;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.Exception;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReceptionStockServiceImpl implements ReceptionStockService {

    @Autowired
    private ReceptionStockRepository receptionStockRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private ReceptionLineRepository receptionLineRepository;
    @Autowired
    private PurshaseOrderLineRepository purshaseOrderLineRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private ReceptionRepository receptionRepository;
    @Autowired
    private SettingRepository settingRepository;
    @Autowired
    private PurshaseOrderRepository purshaseOrderRepository;
    @Autowired
    private ProductService productService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ReceptionStockServiceImpl.class);



    @Override
    @Transactional(rollbackFor = ContainerException.class)
    public ReceptionStock save(ReceptionStock receptionStock) throws AttributesNotFound, ErrorType, ContainerException, ProductControls {

//        receptionStock = checkControls(receptionStock);
        if (0 == receptionStock.getId()) {
            receptionStock.setCreationDate(EmsDate.getDateNow());
            receptionStock.setUpdateDate(EmsDate.getDateNow());
            ReceptionLine receptionLine = receptionStock.getReceptionLine();
            Stock stock = null;
            if (null != receptionLine) { //check if receptionLine is not null
                receptionLine = ReceptionLineMapper.toDto(receptionLineRepository.findOne(receptionLine.getId()), false);
                if (!checkStatus(receptionLine)) { // check status
                    return null;
                }
                receptionLine = compareRlineRStock(receptionLine, receptionStock);//compare receptionLine and receptionStock
            } else { //si reception line = null
                receptionLine = ReceptionLineMapper.toDto(createReceptionLine(ReceptionStockMapper.toEntity(receptionStock, false), receptionStock.getQuantityReceived()), false);//creation reception line
            }
            if (receptionLine.getId() == 0) {//if new receptionLine
                Container container;
                container = checkContainer(receptionStock);
                if (null == container)
                    try {
                        container = createContainer(receptionStock);
                    } catch (Exception e) {
                        throw new ContainerException("Code conteneur existe déja");
                    }

                receptionLine = ReceptionLineMapper.toDto(receptionLineRepository.saveAndFlush(ReceptionLineMapper.toEntity(receptionLine, false)), false); //sauvgarder reception line

                receptionStock.setReceptionLine(receptionLine);
                receptionStock.setContainer(container);
                stock = createStock(receptionStock);
            } else { //if receptionline exist
                stock = checkStock(receptionStock); //search stock
                Container container = null;
                if (null != stock) {
                    container = stock.getContainer();
                    stock.setQuantity(stock.getQuantity().add(receptionStock.getQuantityReceived()));
                    receptionStock.setContainer(container);
                } else {

                    container = checkContainer(receptionStock);
                    if (null == container)
                        try {
                            container = createContainer(receptionStock);
                        } catch (Exception e) {

                            throw new ContainerException("Code conteneur existe déja");
                        }
                    receptionStock.setContainer(container);
                    stock = createStock(receptionStock);
                }
                //receptionLine = checkQuantity(receptionLine, receptionStock, stock);

            }
//change status

            if (null != receptionLine.getQuantityReceived()
                    && null != receptionLine.getQuantity()
                    && -1 < receptionLine.getQuantityReceived().compareTo(receptionLine.getQuantity())) {
                receptionLine.setOrderStatus(OrderStatusMapper.toDto(orderStatusRepository.findOne(1L), false));
                LOGGER.info("Close reception line with id:"+receptionLine.getId()+" in receptionStock");
            } else if (null != receptionLine.getQuantityReceived()
                    && null != receptionLine.getQuantity()
                    && -1 == receptionLine.getQuantityReceived().compareTo(receptionLine.getQuantity())) {
                receptionLine.setOrderStatus(OrderStatusMapper.toDto(orderStatusRepository.findOne(7L), false));
                LOGGER.info("reception line not complete  with id:"+receptionLine.getId()+" in receptionStock");
            }

            PurshaseOrderLine purshaseOrderLine = null;
            if (null != receptionLine.getPurshaseOrderLine()) {
                purshaseOrderLine = PurshaseOrderLineMapper.toDto(purshaseOrderLineRepository.findOne(receptionStock.getReceptionLine().getPurshaseOrderLine().getId()), false);
            }
            //check if there's any block type
            if (null != receptionStock.getBlockType()) {
                receptionLine.setBlockType(receptionStock.getBlockType());
                if (null != purshaseOrderLine) {
                    purshaseOrderLine.setBlockType(receptionStock.getBlockType());
                }
         /*   if (receptionLine.getBlockedQuantity() != null) {
               // receptionLine.setBlockedQuantity(receptionLine.getBlockedQuantity().add(receptionStock.getQuantityReceived()));
            } else {

            
                receptionLine.setBlockedQuantity(receptionStock.getQuantityReceived());
            }*/
                if (null != purshaseOrderLine) {
                    purshaseOrderLine.setBlockedQuantity(receptionLine.getBlockedQuantity());
                    purshaseOrderLine.setBlockType(receptionLine.getBlockType());
                }
            }
            if (null == receptionLine.getReceptionDate())
                receptionLine.setReceptionDate(receptionStock.getReceptionDate());
            receptionLineRepository.saveAndFlush(ReceptionLineMapper.toEntity(receptionLine, false));
            //change the status to Complet
            RcpReception rcpReception = receptionRepository.findOne(receptionStock.getReception().getId());
            if (null == rcpReception.getRcpReceptionReceptionDate()) {
                rcpReception.setRcpReceptionReceptionDate(receptionStock.getReceptionDate());
            }
            if (checkIfOneLineComplete(rcpReception)) {
                rcpReception.setPrmOrderStatus(orderStatusRepository.findOne(5L));
            }
            if (checkIfLinesStatusClosed(rcpReception)) {
                LOGGER.info("reception completed and closed code:"+rcpReception.getRcpReceptionCode()+" in receptionStock");
                rcpReception.setPrmOrderStatus(orderStatusRepository.findOne(1L));
                rcpReception.setRcpReceptionSendedToWms(false);
            }
            rcpReception = receptionRepository.saveAndFlush(rcpReception);

            stock.setReceptionDate(EmsDate.getDateNow());
            stock = StockMapper.toDto(stockRepository.saveAndFlush(StockMapper.toEntity(stock, false)), false);
            if (null != purshaseOrderLine) {
                if (null == purshaseOrderLine.getReceptionDate())
                    purshaseOrderLine.setReceptionDate(receptionStock.getReceptionDate());
                purshaseOrderLine = checkUomPurshaseOrderLine(receptionStock, purshaseOrderLine);
                // purshaseOrderLine.setQuantityReceived(receptionLine.getQuantityReceived());

                //check quanity to change status
                if (null != purshaseOrderLine) {
                    if (null != purshaseOrderLine.getQuantityReceived()
                            && null != purshaseOrderLine.getQuantity()
                            && -1 < purshaseOrderLine.getQuantityReceived().compareTo(purshaseOrderLine.getQuantity())) {
                        purshaseOrderLine.setOrderStatus(OrderStatusMapper.toDto(orderStatusRepository.findOne(1L), false));

                    } else if (null != purshaseOrderLine.getQuantityReceived()
                            && null != purshaseOrderLine.getQuantity()
                            && -1 == purshaseOrderLine.getQuantityReceived().compareTo(purshaseOrderLine.getQuantity()))
                        purshaseOrderLine.setOrderStatus(OrderStatusMapper.toDto(orderStatusRepository.findOne(7L), false));
                }
                purshaseOrderLineRepository.saveAndFlush(PurshaseOrderLineMapper.toEntity(purshaseOrderLine, false));

                RcpPurshaseOrder purshaseOrder = purshaseOrderRepository.findOne(purshaseOrderLine.getPurshaseOrder().getId());
                if (checkIfPurshaseLinesStatusClosed(purshaseOrder)) {
                    purshaseOrder.setPrmOrderStatus(orderStatusRepository.findOne(1L));

                } else {
                    if (1 == rcpReception.getPrmOrderStatus().getPrmOrderStatusId()) {
                        purshaseOrder.setPrmOrderStatus(orderStatusRepository.findOne(7L));
                    }
                }
                if(null!=purshaseOrder.getRcpPurshaseOrderReceptionDate())
                    purshaseOrder.setRcpPurshaseOrderReceptionDate(receptionStock.getReceptionDate());
                purshaseOrderRepository.save(purshaseOrder);

            }

            receptionStock = ReceptionStockMapper.toDto(receptionStockRepository.saveAndFlush(ReceptionStockMapper.toEntity(receptionStock, false)), false);
            stock.setReceptionStock(receptionStock);
            stockRepository.save(StockMapper.toEntity(stock, false));
            return receptionStock;
        } else {
            return ReceptionStockMapper.toDto(receptionStockRepository.saveAndFlush(ReceptionStockMapper.toEntity(receptionStock, false)), false);
        }
    }

    private ReceptionStock checkControls(ReceptionStock receptionStock) throws ProductControls {
        Product product = receptionStock.getProduct();
        if (null != product.getDlcControl()) {
            if (product.getDlcControl() && null == receptionStock.getDlc()) {
                throw new ProductControls("Dlc");
            }
        }
        if (null != product.getDluoControl()) {
            if (product.getDluoControl() && null == receptionStock.getDluo()) {
                throw new ProductControls("Dluo");
            }
        }
        if (null != product.getLotControl()) {
            if (product.getLotControl() && null == receptionStock.getLot()) {
                throw new ProductControls("Lot");
            }
        }
        if (null != product.getColorControl()) {
            if (product.getColorControl() && null == receptionStock.getColor()) {
                throw new ProductControls("Coleur");
            }
        }
        if (null != product.getSerialNoControl()) {
            if (product.getSerialNoControl() && null == receptionStock.getSerialNo()) {
                throw new ProductControls("SerialNo");
            }
        }
        if (null != product.getWeightControl()) {
            if (product.getWeightControl() && null == receptionStock.getWeight()) {
                throw new ProductControls("Poid");
            }
        }
        if (null != product.getQualityOfControl()) {
            if (product.getQualityOfControl() && null == receptionStock.getQuality()) {
                throw new ProductControls("Qualité");
            }
        }

        return receptionStock;

    }


    private String getContainerCode() {
        return String.format("%1$018d", containerRepository.getNextVal().get(0));
    }

    @Override
    public Long size() {
        return receptionStockRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionStockRepository.exists(id);
    }

    @Override
    public ReceptionStock findById(Long id) throws IdNotFound {
        ReceptionStock receptionStock = ReceptionStockMapper.toDto(receptionStockRepository.findOne(id), false);
        if (null != receptionStock) {
            return receptionStock;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ReceptionStock> find(String search) throws AttributesNotFound, ErrorType {
        return ReceptionStockMapper.toDtos(receptionStockRepository.findAll(Search.expression(search, RcpReceptionStock.class)), false);
    }

    @Override
    public List<ReceptionStock> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ReceptionStockMapper.toDtos(receptionStockRepository.findAll(Search.expression(search, RcpReceptionStock.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return receptionStockRepository.count(Search.expression(search, RcpReceptionStock.class));
    }

    @Override
    public void delete(Long id) {
        receptionStockRepository.delete(id);
    }

    @Override
    public void delete(ReceptionStock receptionStock) {
        receptionStockRepository.delete(ReceptionStockMapper.toEntity(receptionStock, false));
    }

    @Override
    public List<ReceptionStock> findAll() {
        return ReceptionStockMapper.toDtos(receptionStockRepository.findAll(), false);
    }

    @Override
    public List<ReceptionStock> findAll(Pageable pageable) {
        return ReceptionStockMapper.toDtos(receptionStockRepository.findAll(pageable), false);
    }

    private Boolean checkStatus(ReceptionLine receptionLine) {
        if (1 == receptionLine.getOrderStatus().getId()) {
            return false;
        }
        return true;
    }
    //check if container already exist and used in stock

    @Override
    public Container checkContainer(ReceptionStock receptionStock) {
        Container container = null;
        try {
            Iterable<StkContainer> containers = containerRepository.findAll(Search.expression("code:" + receptionStock.getContainer().getCode(), StkContainer.class));
            if (null != containers && null != containers.iterator()) {
                if (containers.iterator().hasNext()) {
                    container = ContainerMapper.toDto(containers.iterator().next(), false);
                }
            }

            if (null == container) {
                return null;
            } else {
                if (null != checkStock(receptionStock)) {
                    return container;
                } else {
                    List<Stock> stocks = StockMapper.toDtos(stockRepository.findAll(Search.expression("receptionStock.reception.code:" + receptionStock.getReception().getCode() + ",container.code:" + receptionStock.getContainer().getCode(), StkStock.class)), false);
                    List<Stock> stocks2 = StockMapper.toDtos(stockRepository.findAll(Search.expression("container.code:" + receptionStock.getContainer().getCode(), StkStock.class)), false);
                    if (stocks2.size() == stocks.size()) {
                        return container;
                    } else {
                        return null;
                    }
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
        }
        return null;
    }


    private Container createContainer(ReceptionStock receptionStock) {
        Container container;
        boolean containerManagement = settingRepository.findOne(1L).getPrmSettingValue().equals("1") ? true : false;
        if (containerManagement) {
            container = receptionStock.getContainer();
        } else {
            container = new Container();
            container.setCode(getContainerCode());
        }
        container.setLocation(receptionStock.getLocation());
        container.setOwner(receptionStock.getOwner());
        container.setWarehouse(receptionStock.getWarehouse());
        container.setCreationDate(receptionStock.getReceptionDate());
        container.setUpdateDate(EmsDate.getDateNow());
        container.setReceptionDate(receptionStock.getReceptionDate());
        return ContainerMapper.toDto(containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false)), false);
    }

    private Stock createStock(ReceptionStock receptionStock) {
        Stock stock = new Stock();
        stock.setContainer(receptionStock.getContainer());
        stock.setBlockType(receptionStock.getBlockType());
        stock.setQuantity(receptionStock.getQuantityReceived());
        stock.setOwner(receptionStock.getOwner());
        stock.setProduct(receptionStock.getProduct());
        stock.setUom(receptionStock.getUom());
        stock.setDluo(receptionStock.getDluo());
        stock.setUom(receptionStock.getUom());
        stock.setSupplier(receptionStock.getSupplier());
        stock.setReceptionDate(receptionStock.getReceptionDate());
        stock.setUpdateDate(EmsDate.getDateNow());
        stock.setDlc(receptionStock.getDlc());
        stock.setSerialNo(receptionStock.getSerialNo());
        stock.setLot(receptionStock.getLot());
        stock.setColor(receptionStock.getColor());
        stock.setReceptionLine(receptionStock.getReceptionLine());
        stock.setLocation(receptionStock.getLocation());
        return stock;
    }

    private RcpReceptionLine createReceptionLine(RcpReceptionStock rcpReceptionStock, BigDecimal quantity) {

        RcpReceptionLine rcpReceptionLine = new RcpReceptionLine();
        try {
            rcpReceptionLine.setRcpReceptionLineContainerCode(rcpReceptionStock.getStkContainer().getStkContainerCode());
            rcpReceptionLine.setPdtProduct(rcpReceptionStock.getPdtProduct());
            rcpReceptionLine.setPrmColor(rcpReceptionStock.getPrmColor());
            rcpReceptionLine.setPdtUomReceived(rcpReceptionStock.getPdtUom());
            rcpReceptionLine.setPdtUom(rcpReceptionStock.getPdtUom());
            rcpReceptionLine.setLocLocation(rcpReceptionStock.getLocLocation());
            rcpReceptionLine.setOwnOwner(rcpReceptionStock.getOwnOwner());
            rcpReceptionLine.setRcpReceptionLineDlc(rcpReceptionStock.getRcpReceptionStockDlc());
            rcpReceptionLine.setRcpReceptionLineDluo(rcpReceptionStock.getRcpReceptionStockDluo());
            //if (null == rcpReceptionStock.getPrmBlockType())
            rcpReceptionLine.setRcpReceptionLineQuantityReceived(quantity);

            rcpReceptionLine.setRcpReceptionLineBlockedQuantity(quantity);
            rcpReceptionLine.setRcpReceptionLineLot(rcpReceptionStock.getRcpReceptionStockLot());
            rcpReceptionLine.setRcpReception(rcpReceptionStock.getRcpReception());
            rcpReceptionLine.setWrhWarehouse(rcpReceptionStock.getWrhWarehouse());
            rcpReceptionLine.setRcpReceptionLineCreationDate(EmsDate.getDateNow());
            rcpReceptionLine.setRcpReceptionLineUpdateDate(EmsDate.getDateNow());
            rcpReceptionLine.setRcpReceptionLineSerialNo(rcpReceptionStock.getRcpReceptionStockSerialNo());
            rcpReceptionLine.setRcpReceptionLineReceptionDate(rcpReceptionStock.getRcpReceptionStockReceptionDate());
            rcpReceptionLine.setRcpReceptionLineQuantity(BigDecimal.ZERO);
            rcpReceptionLine.setPrmOrderStatus(orderStatusRepository.findOne(1L));
            rcpReceptionLine.setRcpReception(rcpReceptionStock.getRcpReception());
            ArrayList<RcpReceptionLine> rcpReceptionLines = Lists.newArrayList(receptionRepository.findOne(rcpReceptionStock.getRcpReception().getRcpReceptionId()).getRcpReceptionLines());
            long lineNumber = (rcpReceptionLines == null || rcpReceptionLines.size() == 0) ? 1000 : (rcpReceptionLines.get(rcpReceptionLines.size() - 1).getRcpReceptionLineLineNumber() / 1000 + 1) * 1000;
            rcpReceptionLine.setRcpReceptionLineLineNumber(lineNumber);
            rcpReceptionLine.setRcpReceptionLineReceptionDate(EmsDate.getDateNow());
            rcpReceptionLine.setRcpReceptionLineCreationDate(EmsDate.getDateNow());
            rcpReceptionLine.setRcpReceptionLineUpdateDate(EmsDate.getDateNow());
            rcpReceptionLine.setPrmOrderStatus(orderStatusRepository.findOne(1L));
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return rcpReceptionLine;

    }


    //search for stock if it exists with the same values as receptionStock
    private Stock checkStock(ReceptionStock receptionStock) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        if (null != receptionStock.getDlc())
            c.setTime(receptionStock.getDlc());
        Calendar c2 = Calendar.getInstance();
        if (null != receptionStock.getDluo())
            c2.setTime(receptionStock.getDluo());
        StringBuffer search = new StringBuffer();
        List<Stock> stocks = null;
        if (null != receptionStock.getReceptionLine()) {
            search.append("receptionLine.id:");
            search.append(receptionStock.getReceptionLine().getId());
        }
        if (null != receptionStock.getProduct()) {
            search.append(",product.id:");
            search.append(receptionStock.getProduct().getId());
        }
        if (null != receptionStock.getLot()) {
            search.append(",lot:");
            search.append(receptionStock.getLot());
        }
        if (null != receptionStock.getColor()) {
            search.append(",color.id:");
            search.append(receptionStock.getColor().getId());
        }
        if (null != receptionStock.getDlc()) {
            search.append(",dlc:");
            search.append(format.format(c.getTime()));
        }
        if (null != receptionStock.getDluo()) {
            search.append(",dluo:");
            search.append(format.format(c2.getTime()));
        }
        if (null != receptionStock.getSerialNo()) {
            search.append(",serialNo:");
            search.append(receptionStock.getSerialNo());
        }
        if (null != receptionStock.getWeight()) {
            search.append(",weight:");
            search.append(receptionStock.getWeight());
        }
        if (null != receptionStock.getWeight()) {
            search.append(",quality:");
            search.append(receptionStock.getQuality());
        }
        if (null != receptionStock.getBlockType()) {
            search.append(",blockType.id:");
            search.append(receptionStock.getBlockType().getId());
        }
        if (null != receptionStock.getSupplier()) {
            search.append(",supplier.id:");
            search.append(receptionStock.getSupplier().getId());
        }
        if (null != receptionStock.getOwner()) {
            search.append(",owner.id:");
            search.append(receptionStock.getOwner().getId());
        }
        if (null != receptionStock.getContainer()) {
            if (null != receptionStock.getContainer().getCode() || !"".equals(receptionStock.getContainer().getCode().trim())) {
                search.append(",container.code:");
                search.append(receptionStock.getContainer().getCode());
            }
        }

        try {
            stocks = StockMapper.toDtos(stockRepository.findAll(Search.expression(search.toString(), StkStock.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        if (stocks != null)
            for (Stock stock : stocks) {
                if (EmsComprator.compare(receptionStock.getLocation(), stock.getLocation())
                        && EmsComprator.compare(receptionStock.getUom(), stock.getUom())
                        && EmsComprator.compare(receptionStock.getContainer().getCode(), stock.getContainer().getCode())
                        && EmsComprator.compare(receptionStock.getDlc(), stock.getDlc())
                        && EmsComprator.compare(receptionStock.getDluo(), stock.getDluo())
                        && EmsComprator.compare(receptionStock.getLot(), stock.getLot())
                        && EmsComprator.compare(receptionStock.getWeight(), stock.getWeight())
                        && EmsComprator.compare(receptionStock.getQuality(), stock.getQuality())
                        && EmsComprator.compare(receptionStock.getProduct(), stock.getProduct())
                        && EmsComprator.compare(receptionStock.getBlockType(), stock.getBlockType())
                        && EmsComprator.compare(receptionStock.getOwner(), stock.getOwner())
                        && EmsComprator.compare(receptionStock.getColor(), stock.getColor())
                        && EmsComprator.compare(receptionStock.getSerialNo(), stock.getSerialNo())
                        && EmsComprator.compare(receptionStock.getSupplier(), stock.getSupplier())

                        ) {
                    return stock;
                }
            }
        return null;
    }

    private ReceptionLine compareRlineRStock(ReceptionLine receptionLine, ReceptionStock receptionStock) {
        boolean check = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        if (null != receptionLine.getContainerCode() && !"".equals(receptionLine.getContainerCode()))
            if (null != receptionStock.getContainer())
                if (!EmsComprator.compare(receptionLine.getContainerCode(), receptionStock.getContainer().getCode()))
                    check = false;
        if (null != receptionLine.getSerialNo())
            if (!EmsComprator.compare(receptionLine.getSerialNo(), receptionStock.getSerialNo()))
                check = false;
        if (null != receptionLine.getLot())
            if (!EmsComprator.compare(receptionLine.getLot(), receptionStock.getLot()))
                check = false;
        if (null != receptionLine.getQuality())
            if (!EmsComprator.compare(receptionLine.getQuality(), receptionStock.getQuality()))
                check = false;
        if (null != receptionLine.getWeight())
            if (!EmsComprator.compare(receptionLine.getWeight(), receptionStock.getWeight()))
                check = false;
        if (null != receptionLine.getColor())
            if (!EmsComprator.compare(receptionLine.getColor(), receptionStock.getColor()))
                check = false;
        if (null != receptionLine.getDlc()) {
            if (null != receptionStock.getDlc()) {
                c1.setTime(receptionLine.getDlc());
                c2.setTime(receptionStock.getDlc());
                if (!EmsComprator.compare(simpleDateFormat.format(c1.getTime()), simpleDateFormat.format(c2.getTime())))
                    check = false;
            }
        }
        if (null != receptionLine.getDluo()) {
            if (null != receptionStock.getDluo()) {
                c1.setTime(receptionLine.getDluo());
                c2.setTime(receptionStock.getDluo());
                if (!EmsComprator.compare(simpleDateFormat.format(c1.getTime()), simpleDateFormat.format(c2.getTime())))
                    check = false;
            }
        }
        if (!EmsComprator.compare(receptionLine.getProduct(), receptionStock.getProduct()))
            check = false;
        if (!EmsComprator.compare(receptionLine.getOwner(), receptionLine.getOwner()))
            check = false;
        if (!EmsComprator.compare(receptionLine.getWarehouse(), receptionStock.getWarehouse()))
            check = false;

        if (check) {
            return checkUom(receptionStock, receptionLine);
        } else {
            return ReceptionLineMapper.toDto(createReceptionLine(ReceptionStockMapper.toEntity(receptionStock, false), receptionStock.getQuantityReceived()), false);
        }

    }

    //check if all Reception Lines are closed to close delivery
    private boolean checkIfLinesStatusClosed(RcpReception reception) {
        boolean areClosed = true;
        for (RcpReceptionLine receptionLine : reception.getRcpReceptionLines()) {
            if (1 != receptionLine.getPrmOrderStatus().getPrmOrderStatusId()) {
                areClosed = false;
                break;
            }
        }
        return areClosed;
    }

    private boolean checkIfOneLineComplete(RcpReception reception) {

        for (RcpReceptionLine receptionLine : reception.getRcpReceptionLines()) {
            if (1 == receptionLine.getPrmOrderStatus().getPrmOrderStatusId()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfPurshaseLinesStatusClosed(RcpPurshaseOrder purshaseOrder) {
        boolean areClosed = true;
        for (RcpPurshaseOrderLine rcpPurshaseOrderLine : purshaseOrder.getRcpPurshaseOrderLines()) {
            if (1 != rcpPurshaseOrderLine.getPrmOrderStatus().getPrmOrderStatusId()) {
                areClosed = false;
                break;
            }
        }
        return areClosed;
    }


    //compare  Uom recieved and Uom expected
    //and update the received Quantity and received Uoms
    private ReceptionLine checkUom(ReceptionStock receptionStock, ReceptionLine receptionLine) {
        BigDecimal quantityReceivedOld = receptionLine.getQuantityReceived();
        BigDecimal quantityReceived = receptionStock.getQuantityReceived();
        BigDecimal blockedQuantity = receptionLine.getBlockedQuantity();
        if (null == quantityReceivedOld)
            quantityReceivedOld = BigDecimal.ZERO;
        if (null == quantityReceived)
            quantityReceived = BigDecimal.ZERO;
        if (null == blockedQuantity)
            blockedQuantity = BigDecimal.ZERO;

        if (!EmsComprator.compare(receptionLine.getUom(), receptionStock.getUom())) {
            if (null == receptionLine.getUomReceived()) {
                receptionLine.setUomReceived(receptionStock.getUom());
                BigDecimal qteRecieved = convertUom(quantityReceived, receptionLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(quantityReceivedOld);
                Pattern pattern = Pattern.compile("\\.0+");
                Matcher matcher = pattern.matcher(qteRecieved.toString());
                if (matcher.find() || !qteRecieved.toString().contains(".")) {
                    if (null != receptionStock.getBlockType()) {
                        BigDecimal qteBlocked = convertUom(quantityReceived, receptionLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(blockedQuantity);
                        receptionLine.setBlockedQuantity(qteBlocked);
                    }
                    receptionLine.setQuantityReceived(qteRecieved);
                    return receptionLine;
                } else {
                    return ReceptionLineMapper.toDto(createReceptionLine(ReceptionStockMapper.toEntity(receptionStock, true), quantityReceived), false);
                }
            } else {
                if (EmsComprator.compare(receptionLine.getUomReceived(), receptionStock.getUom())) {
                    BigDecimal qteRecieved = convertUom(quantityReceived, receptionLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(quantityReceivedOld);
                    Pattern pattern = Pattern.compile("\\.0+");
                    Matcher matcher = pattern.matcher(qteRecieved.toString());
                    if (matcher.find() || !qteRecieved.toString().contains(".")) {
                        if (null != receptionStock.getBlockType()) {
                            BigDecimal qteBlocked = convertUom(quantityReceived, receptionLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(blockedQuantity);
                            receptionLine.setBlockedQuantity(qteBlocked);
                        }
                        receptionLine.setQuantityReceived(qteRecieved);
                        receptionLine.setUomReceived(receptionStock.getUom());
                        return receptionLine;
                    } else {
                        return ReceptionLineMapper.toDto(createReceptionLine(ReceptionStockMapper.toEntity(receptionStock, true), quantityReceived), false);
                    }
                } else {
                    return ReceptionLineMapper.toDto(createReceptionLine(ReceptionStockMapper.toEntity(receptionStock, true), quantityReceived), false);
                }
            }
        } else {
            if (null == receptionLine.getUomReceived()) {
                if (null != receptionStock.getBlockType()) {
                    receptionLine.setBlockedQuantity(blockedQuantity.add(quantityReceived));
                    receptionLine.setBlockType(receptionStock.getBlockType());
                }
                receptionLine.setQuantityReceived(quantityReceivedOld.add(quantityReceived));
                receptionLine.setUomReceived(receptionStock.getUomReceived());
                return receptionLine;
            } else {
                if (EmsComprator.compare(receptionLine.getUomReceived(), receptionStock.getUom())) {
                    if (null != receptionStock.getBlockType()) {
                        receptionLine.setBlockedQuantity(blockedQuantity.add(quantityReceived));
                        receptionLine.setBlockType(receptionStock.getBlockType());
                    }
                    receptionLine.setQuantityReceived(quantityReceivedOld.add(quantityReceived));
                    receptionLine.setUomReceived(receptionStock.getUom());
                    return receptionLine;
                } else {
                    return ReceptionLineMapper.toDto(createReceptionLine(ReceptionStockMapper.toEntity(receptionStock, true), quantityReceived), false);
                }
            }
        }
    }

    //convert quantity recevied
    private BigDecimal convertUom(BigDecimal qte, Uom uom, Uom uomReceived, Product product) {
        try {
            product=productService.findById(product.getId());
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }

        List<ProductPack> productPacks = Lists.newArrayList(product.getProductPacks());
        ProductPack received = new ProductPack();
        ProductPack expected = new ProductPack();


        for (ProductPack productPack : productPacks) {
            if (productPack.getUom().equals(uomReceived)) {
                received = productPack;
            }
            if (productPack.getUom().equals(uom)) {
                expected = productPack;
            }
        }
        BigDecimal newQte = qte.multiply(received.getQuantity().divide(expected.getQuantity(),2, RoundingMode.HALF_DOWN));

        return newQte;

    }
    //check if quantity recieved is greater than quantity expected and create new receptionLine ,stock and reception stock

   /* private ReceptionLine checkQuantity(ReceptionLine receptionLine, ReceptionStock receptionStock, Stock stock) {
        try {
            BigDecimal qteLA = receptionLine.getQuantity();

            BigDecimal qteLR = receptionLine.getQuantityReceived();
            BigDecimal qteRS = receptionStock.getQuantityReceived();
            if (qteLR.compareTo(qteLA) == 1) {
                BigDecimal qteR = qteLR.subtract(qteLA);
                BigDecimal qteRSA = qteRS.subtract(qteR);
                BigDecimal qteC = BigDecimal.ZERO;
                BigDecimal qteCA = BigDecimal.ZERO;
                if (!EmsComprator.compare(receptionStock.getUom(), receptionLine.getUom())) {
                    qteC = convertUom(qteR, receptionStock.getUom(), receptionLine.getUom(), receptionStock.getProduct());
                } else {
                    qteC = qteR;
                }
                if (!EmsComprator.compare(receptionStock.getUom(), receptionLine.getUom())) {
                    qteCA = convertUom(qteRSA, receptionStock.getUom(), receptionLine.getUom(), receptionStock.getProduct());
                } else {
                    qteCA = qteRSA;
                }

                receptionStock.setQuantityReceived(receptionLine.getQuantityReceived());
                if (null == stock.getQuantity()) {
                    stock.setQuantity(BigDecimal.ZERO);
                }

                stock.setQuantity(stock.getQuantity().add(qteRS));

                ReceptionLine line = ReceptionLineMapper.toDto(receptionLineRepository.saveAndFlush(createReceptionLine(ReceptionStockMapper.toEntity(receptionStock, false), qteC)), false);
                ReceptionStock rs = null;
                try {
                    rs = EmsClone.clone(receptionStock, ReceptionStock.class);
                } catch (IOException e) {
                    return null;
                }
                rs.setId(0);
                rs.setQuantityReceived(qteC);
                rs.setBlockType(receptionStock.getBlockType());
                rs.setReceptionLine(line);
                rs.setUsrUserBoxCreationDate(EmsDate.getDateNow());
                rs.setUpdateDate(EmsDate.getDateNow());
                rs.setReceptionDate(EmsDate.getDateNow());
                receptionStockRepository.saveAndFlush(ReceptionStockMapper.toEntity(rs, false));
               *//* Stock stk = createStock(rs);
                stockRepository.saveAndFlush(StockMapper.toEntity(stk, false))*//*


            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return receptionLine;
    }*/


    private PurshaseOrderLine checkUomPurshaseOrderLine(ReceptionStock receptionStock, PurshaseOrderLine purshaseOrderLine) {
        BigDecimal quantityReceivedOld = purshaseOrderLine.getQuantityReceived();
        BigDecimal quantityReceived = receptionStock.getQuantityReceived();
        BigDecimal blockedQuantity = purshaseOrderLine.getBlockedQuantity();
        if (null == quantityReceivedOld)
            quantityReceivedOld = BigDecimal.ZERO;
        if (null == quantityReceived)
            quantityReceived = BigDecimal.ZERO;
        if (null == blockedQuantity)
            blockedQuantity = BigDecimal.ZERO;

        if (!EmsComprator.compare(purshaseOrderLine.getUom(), receptionStock.getUom())) {
            if (null == purshaseOrderLine.getUomReceived()) {
                purshaseOrderLine.setUomReceived(receptionStock.getUom());
                BigDecimal qteRecieved = convertUom(quantityReceived, purshaseOrderLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(quantityReceivedOld);
                if (null != receptionStock.getBlockType()) {
                    BigDecimal qteBlocked = convertUom(quantityReceived, purshaseOrderLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(blockedQuantity);
                    purshaseOrderLine.setBlockedQuantity(qteBlocked);
                }
                purshaseOrderLine.setQuantityReceived(qteRecieved);

            } else {
                if (EmsComprator.compare(purshaseOrderLine.getUomReceived(), receptionStock.getUom())) {
                    BigDecimal qteRecieved = convertUom(quantityReceived, purshaseOrderLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(quantityReceivedOld);

                    if (null != receptionStock.getBlockType()) {
                        BigDecimal qteBlocked = convertUom(quantityReceived, purshaseOrderLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(blockedQuantity);
                        purshaseOrderLine.setBlockedQuantity(qteBlocked);
                    }
                    purshaseOrderLine.setQuantityReceived(qteRecieved);
                    purshaseOrderLine.setUomReceived(receptionStock.getUom());

                }
            }
        } else {
            if (null == purshaseOrderLine.getUomReceived()) {
                if (null != receptionStock.getBlockType()) {
                    purshaseOrderLine.setBlockedQuantity(blockedQuantity.add(quantityReceived));
                    purshaseOrderLine.setBlockType(receptionStock.getBlockType());
                }
                purshaseOrderLine.setQuantityReceived(quantityReceivedOld.add(quantityReceived));
                purshaseOrderLine.setUomReceived(receptionStock.getUomReceived());
            } else {
                if (null != receptionStock.getBlockType()) {
                    purshaseOrderLine.setBlockedQuantity(blockedQuantity.add(quantityReceived));
                    purshaseOrderLine.setBlockType(receptionStock.getBlockType());
                }
                purshaseOrderLine.setQuantityReceived(quantityReceivedOld.add(quantityReceived));
                purshaseOrderLine.setUomReceived(receptionStock.getUom());
            }
        }
        return purshaseOrderLine;
    }


}