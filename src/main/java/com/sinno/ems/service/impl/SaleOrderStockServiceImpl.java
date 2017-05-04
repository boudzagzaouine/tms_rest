package com.sinno.ems.service.impl;

import com.google.common.collect.Lists;
import com.sinno.ems.dto.*;
import com.sinno.ems.entities.*;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.mapper.*;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.SaleOrderStockService;
import com.sinno.ems.service.StockReservedService;
import com.sinno.ems.util.EmsClone;
import com.sinno.ems.util.EmsComprator;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.lang.Exception;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SaleOrderStockServiceImpl implements SaleOrderStockService {

    @Autowired
    private SaleOrderStockRepository saleOrderStockRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockArcRepository stockArcRepository;
    @Autowired
    private DeliveryRepository cmdDeliveryRepository;
    @Autowired
    private DeliveryLineRepository deliveryLineRepository;

    @Autowired
    private SaleOrderLineRepository saleOrderLineRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private ContainerArcRepository containerArcRepository;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private SaleOrderArcRepository saleOrderArcRepository;
    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired
    private DeliveryArcRepository deliveryArcRepository;
    @Autowired
    private DeliveryLineArcRepository deliveryLineArcRepository;
    @Autowired
    private SaleOrderStockArcRepository saleOrderStockArcRepository;
    @Autowired
    private SaleOrderLineArcRepository saleOrderLineArcRepository;
    @Autowired
    private ReceptionStockRepository receptionStockRepository;
    @Autowired
    private SettingRepository settingRepository;
    @Autowired
    private StockViewRepository stockViewRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SaleOrderStockServiceImpl.class);


    @Override
    @Transactional
    public SaleOrderStock save(SaleOrderStock saleOrderStock) throws ProductControls {
        // saleOrderStock = checkControls(saleOrderStock);
        LOGGER.info("Deliver one deliveryLine");
        DeliveryLine deliveryLine = DeliveryLineMapper.toDto(deliveryLineRepository.findOne(saleOrderStock.getDeliveryLine().getId()), false);
        BigDecimal deliveryLineQuantityServed = deliveryLine.getQuantityServed();
        BigDecimal orderedQuantity = deliveryLine.getOrderedQuantity();
        if (null == deliveryLine.getQuantityServed()) {
            deliveryLineQuantityServed = BigDecimal.ZERO;
        }
        if (null == orderedQuantity) {
            orderedQuantity = BigDecimal.ZERO;
        }

        if (saleOrderStock.getQuantityServed().add(deliveryLineQuantityServed).compareTo(orderedQuantity) == 1) {
            return null;
        }
        saleOrderStock.setUpdateDate(EmsDate.getDateNow());
        if (0 >= saleOrderStock.getId()) {
            saleOrderStock.setCreationDate(EmsDate.getDateNow());
        }
        CmdSaleOrderStock cmdSaleOrderStock = SaleOrderStockMapper.toEntity(saleOrderStock, false);
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


            StringBuffer search = new StringBuffer();
            if (null != saleOrderStock.getProduct()) {
                search.append("product.id:");
                search.append(saleOrderStock.getProduct().getId());
            }
            if (null != saleOrderStock.getOwner()) {
                search.append(",owner.id:");
                search.append(saleOrderStock.getOwner().getId());
            }
            if (saleOrderStock.getBlockType() != null) {
                search.append(",blockType.id:");
                search.append(saleOrderStock.getBlockType().getId());
            }
            if (saleOrderStock.getContainerSource() != null) {
                search.append(",container.code:");
                search.append(saleOrderStock.getContainerSource());
            }
            if (saleOrderStock.getDlc() != null) {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(saleOrderStock.getDlc());
                search.append(",dlc:");
                search.append(dateFormat.format(calendar1.getTime()));
            }
            if (saleOrderStock.getColor() != null) {
                search.append(",color.id:");
                search.append(saleOrderStock.getColor().getId());
            }
            if (saleOrderStock.getDluo() != null) {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(saleOrderStock.getDluo());
                search.append(",dluo:");
                search.append(dateFormat.format(calendar2.getTime()));
            }
            if (saleOrderStock.getLot() != null && !saleOrderStock.getLot().trim().equals("")) {
                search.append(",lot:");
                search.append(saleOrderStock.getLot());
            }
            if (saleOrderStock.getWeight() != null) {
                search.append(",weight:");
                search.append(saleOrderStock.getWeight());
            }
            if (saleOrderStock.getQuality() != null) {
                search.append(",quality:");
                search.append(saleOrderStock.getQuality());

            }
            if(saleOrderStock.getProductDimension()!=null)
            {
                search.append(",productDimension.id:");
                search.append(saleOrderStock.getProductDimension().getId());
            }

            Iterable<StkStockView> stkStocks = stockViewRepository.findAll(Search.expression(search.toString(), StkStockView.class));
            List<Stock> stocks = StockMapper.toViewDtos(stkStocks, false);

            if (stocks == null || stocks.size() == 0) {
                LOGGER.info("stock to deliver not found  in saleOrderStock");
                return SaleOrderStockMapper.toDto(cmdSaleOrderStock, false);
            }
            boolean trouve = false;
            BigDecimal quantityServed = saleOrderStock.getQuantityServed();
            for (int i = 0; i < stocks.size(); i++) {
                Stock stock = stocks.get(i);
                if (EmsComprator.compare(saleOrderStock.getBlockType(), stock.getBlockType())
                        && EmsComprator.compare(saleOrderStock.getDlc(), stock.getDlc())
                        && EmsComprator.compare(saleOrderStock.getDluo(), stock.getDluo())
                        && EmsComprator.compare(saleOrderStock.getLot(), stock.getLot())
                        && EmsComprator.compare(saleOrderStock.getWeight(), stock.getWeight())
                        && EmsComprator.compare(saleOrderStock.getQuality(), stock.getQuality())
                        && EmsComprator.compare(saleOrderStock.getProduct(), stock.getProduct())
                        && EmsComprator.compare(saleOrderStock.getSerialNo(), stock.getSerialNo())
                        && EmsComprator.compare(saleOrderStock.getColor(), stock.getColor())
                        && EmsComprator.compare(saleOrderStock.getProductDimension(), stock.getProductDimension())
                        && checkContainerSource(saleOrderStock, stock)
                        ) {
                    BigDecimal convertedStockQuantity = convertUom(stock.getQuantity(), saleOrderStock.getUom(), stock.getUom(), saleOrderStock.getProduct());
                    Container container = ContainerMapper.toDto(containerRepository.findOne(Search.expression("code:" + saleOrderStock.getContainer().getCode(), StkContainer.class)), false);
                    if (null == container) {
                        saleOrderStock.setContainer(createContainer(saleOrderStock));
                    } else {
                        saleOrderStock.setContainer(container);
                    }
                    trouve = true;
                    if (convertedStockQuantity.compareTo(quantityServed) == -1) {
                        quantityServed = quantityServed.subtract(convertedStockQuantity);
                        stock.setUpdateDate(EmsDate.getDateNow());
                        stock = StockMapper.toDto(stockRepository.saveAndFlush(StockMapper.toEntity(stock, false)), false);
                        if (stock.getQuantity().compareTo(BigDecimal.ZERO) < 1) {
                            saleOrderStock = copySaleOrderStock(saleOrderStock, convertedStockQuantity, stock);
                            saleOrderStock = SaleOrderStockMapper.toDto(saleOrderStockRepository.saveAndFlush(SaleOrderStockMapper.toEntity(saleOrderStock, false)), false);
                            if (i != stocks.size() - 1)
                                saleOrderStock.setQuantityServed(quantityServed);
                        }
                    } else if (convertedStockQuantity.compareTo(quantityServed) == 1) {
                        Stock stockForSaleOrder = createStock(stock, saleOrderStock.getUom(), quantityServed, saleOrderStock.getLocation(), container);
                        saleOrderStock.setStock(stockForSaleOrder);
                        BigDecimal convertedQuantityServed = convertUom(quantityServed, stock.getUom(), saleOrderStock.getUom(), saleOrderStock.getProduct());
                        stock.setQuantity(stock.getQuantity().subtract(convertedQuantityServed));
                        quantityServed = BigDecimal.ZERO;
                        saleOrderStock = SaleOrderStockMapper.toDto(saleOrderStockRepository.saveAndFlush(SaleOrderStockMapper.toEntity(saleOrderStock, false)), false);

                    } else {
                        saleOrderStock.setStock(stock);
                        quantityServed = BigDecimal.ZERO;
                        stock.setUpdateDate(EmsDate.getDateNow());
                        saleOrderStock = SaleOrderStockMapper.toDto(saleOrderStockRepository.saveAndFlush(SaleOrderStockMapper.toEntity(saleOrderStock, false)), false);
                    }
                    if (null != stock.getContainer()) {
                        stock.getContainer().setOutBoundDate(EmsDate.getDateNow());
                    }
                    stock = StockMapper.toDto(stockRepository.saveAndFlush(StockMapper.toEntity(stock, false)), false);
                    if (0 == quantityServed.compareTo(BigDecimal.ZERO)) {
                        break;
                    }

                }

            }
            if (trouve) {
                CmdDeliveryLine cmddeliveryLine = deliveryLineRepository.findOne(cmdSaleOrderStock.getCmdDeliveryLine().getCmdDeliveryLineId());
                BigDecimal subtract = cmdSaleOrderStock.getCmdSaleOrderStockQuantityServed().subtract(quantityServed);
                cmdSaleOrderStock.setCmdSaleOrderStockQuantityServed(subtract);
                CmdSaleOrderLine cmdSaleOrderLine = cmddeliveryLine.getCmdSaleOrderLine();

                if (null == cmdSaleOrderLine.getCmdSaleOrderLineQuantityServed())
                    cmdSaleOrderLine.setCmdSaleOrderLineQuantityServed(BigDecimal.ZERO);
                cmddeliveryLine.setCmdDeliveryLineQuantityServed(deliveryLineQuantityServed.add(subtract));
                cmdSaleOrderLine.setCmdSaleOrderLineQuantityServed(cmdSaleOrderLine.getCmdSaleOrderLineQuantityServed().add(subtract));
                saleOrderLineRepository.saveAndFlush(cmdSaleOrderLine);

                if (cmddeliveryLine.getCmdDeliveryLineOrderQuantity().compareTo(cmddeliveryLine.getCmdDeliveryLineQuantityServed()) == 0) {
                    cmddeliveryLine.setPrmOrderStatus(orderStatusRepository.findOne(1L));
                    //Delete stock reserved
                    deleteStockReserveds(cmddeliveryLine.getCmdSaleOrderLine().getCmdSaleOrderLineId());

                    if (null == cmdSaleOrderLine.getCmdSaleOrderLineQuantity()) {
                        cmdSaleOrderLine.setCmdSaleOrderLineQuantity(BigDecimal.ZERO);
                    }
                    if (null == cmdSaleOrderLine.getCmdSaleOrderLineQuantityServed()) {
                        cmdSaleOrderLine.setCmdSaleOrderLineQuantityServed(BigDecimal.ZERO);
                    }
                    if (cmdSaleOrderLine.getCmdSaleOrderLineQuantity().compareTo(cmdSaleOrderLine.getCmdSaleOrderLineQuantityServed()) == 0) {
                        cmdSaleOrderLine.setPrmOrderStatus(orderStatusRepository.findOne(1L));
                    }

                    //close delivery status and archive it if all lines are closed(orderStatus=1)
                }
                if (cmddeliveryLine.getCmdDeliveryLineOrderQuantity().compareTo(cmddeliveryLine.getCmdDeliveryLineQuantityServed()) == 1) {
                    cmddeliveryLine.setPrmOrderStatus(orderStatusRepository.findOne(7L));
                    LOGGER.info("close deliveryLine in saleOrderStock");

                    if (cmdSaleOrderLine.getCmdSaleOrderLineQuantity().compareTo(cmdSaleOrderLine.getCmdSaleOrderLineQuantityServed()) == 1) {
                        LOGGER.info("close saleOrderLine in saleOrderStock");
                        cmdSaleOrderLine.setPrmOrderStatus(orderStatusRepository.findOne(7L));
                    }
                }
                deliveryLineRepository.saveAndFlush(cmddeliveryLine);


                CmdDelivery cmdDelivery = cmdDeliveryRepository.findOne(cmddeliveryLine.getCmdDelivery().getCmdDeliveryId());
                if (checkIfLinesStatusClosed(cmdDelivery)) {
                    LOGGER.info("close delivery in saleOrderStock");
                    cmdDelivery.setPrmOrderStatus(orderStatusRepository.findOne(1L));
                } else {
                    if (checkIfOneLineComplete(cmdDelivery)) {
                        LOGGER.info("delivery not completed in saleOrderStockServiceImp");
                        cmdDelivery.setPrmOrderStatus(orderStatusRepository.findOne(7L));
                    }
                    if (null == cmdDelivery.getCmdDeliveryDate())
                        cmdDelivery.setCmdDeliveryDate(saleOrderStock.getOrderDate());
                    cmdDelivery = deliveryRepository.saveAndFlush(cmdDelivery);
                }
                CmdSaleOrder cmdSaleOrder = saleOrderRepository.findOne(cmddeliveryLine.getCmdDelivery().getCmdSaleOrder().getCmdSaleOrderId());


                if (checkIfSaleLinesStatusClosed(cmdSaleOrder)) {
                    LOGGER.info("SaleOrder  completed in saleOrderStockServiceImp");
                    cmddeliveryLine.getCmdDelivery().setPrmOrderStatus(orderStatusRepository.findOne(1L));
                    cmdSaleOrder.setPrmOrderStatus(orderStatusRepository.findOne(1L));
                    if (0 > 1) {
                        SaleOrder saleOrder = SaleOrderMapper.toDto(saleOrderRepository.saveAndFlush(cmdSaleOrder), false);archiveSaleOrder(saleOrder);Delivery delivery = DeliveryMapper.toDto(cmdDeliveryRepository.saveAndFlush(cmddeliveryLine.getCmdDelivery()), false);archiveDelivery(delivery);archiveSaleOrderStock(delivery);deliveryRepository.delete(delivery.getId());saleOrderRepository.delete(saleOrder.getId());deleteArchivedContainer(saleOrder);
                    }

                } else {
                        LOGGER.info("SaleOrder not completed in saleOrderStockServiceImp");
                        cmdSaleOrder.setPrmOrderStatus(orderStatusRepository.findOne(7L));
                        saleOrderRepository.saveAndFlush(cmdSaleOrder);
                }

            }
        } catch (AttributesNotFound attributesNotFound) {
            LOGGER.info(attributesNotFound.getMessage());
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            LOGGER.info(errorType.getMessage());
            errorType.printStackTrace();
        }
        return saleOrderStock;
    }

    private SaleOrderStock checkControls(SaleOrderStock saleOrderStock) throws ProductControls {
        Product product = saleOrderStock.getProduct();
        if (null != product.getDlcControl()) {
            if (product.getDlcControl() && null == saleOrderStock.getDlc()) {
                throw new ProductControls("Dlc");
            }
        }
        if (null != product.getDluoControl()) {
            if (product.getDluoControl() && null == saleOrderStock.getDluo()) {
                throw new ProductControls("Dluo");
            }
        }
        if (null != product.getLotControl()) {
            if (product.getLotControl() && null == saleOrderStock.getLot()) {
                throw new ProductControls("Lot");
            }
        }
        if (null != product.getColorControl()) {
            if (product.getColorControl() && null == saleOrderStock.getColor()) {
                throw new ProductControls("Coleur");
            }
        }
        if (null != product.getSerialNoControl()) {
            if (product.getSerialNoControl() && null == saleOrderStock.getSerialNo()) {
                throw new ProductControls("SerialNo");
            }
        }
        if (null != product.getWeightControl()) {
            if (product.getWeightControl() && null == saleOrderStock.getWeight()) {
                throw new ProductControls("Poid");
            }
        }
        if (null != product.getQualityOfControl()) {
            if (product.getQualityOfControl() && null == saleOrderStock.getQuality()) {
                throw new ProductControls("Qualit?");
            }
        }
        return saleOrderStock;
    }

    private boolean checkContainerSource(SaleOrderStock saleOrderStock, Stock stock) {

        if (null != saleOrderStock.getContainerSource() && !"".equals(saleOrderStock.getContainerSource())) {
            if (EmsComprator.compare(saleOrderStock.getContainerSource(), stock.getContainer().getCode())) {
                return true;
            } else return false;
        } else
            return true;

    }

    @Override
    public Long size() {
        return saleOrderStockRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return saleOrderStockRepository.exists(id);
    }

    @Override
    public SaleOrderStock findById(Long id) throws IdNotFound {
        SaleOrderStock saleOrderStock = SaleOrderStockMapper.toDto(saleOrderStockRepository.findOne(id), false);
        if (null != saleOrderStock) {
            return saleOrderStock;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SaleOrderStock> find(String search) throws AttributesNotFound, ErrorType {
        return SaleOrderStockMapper.toDtos(saleOrderStockRepository.findAll(Search.expression(search, CmdSaleOrderStock.class)), false);
    }

    @Override
    public List<SaleOrderStock> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return SaleOrderStockMapper.toDtos(saleOrderStockRepository.findAll(Search.expression(search, CmdSaleOrderStock.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return saleOrderStockRepository.count(Search.expression(search, CmdSaleOrderStock.class));
    }

    @Override
    public void delete(Long id) {
        saleOrderStockRepository.delete(id);
    }

    @Override
    public void delete(SaleOrderStock saleOrderStock) {
        saleOrderStockRepository.delete(SaleOrderStockMapper.toEntity(saleOrderStock, false));
    }

    @Override
    public List<SaleOrderStock> findAll() {
        return SaleOrderStockMapper.toDtos(saleOrderStockRepository.findAll(), false);
    }

    @Override
    public List<SaleOrderStock> findAll(Pageable pageable) {
        return SaleOrderStockMapper.toDtos(saleOrderStockRepository.findAll(pageable), false);
    }

    //Function to archive the stock
    private void archiveStock(Stock stock) {
        stock = StockMapper.toDto(stockRepository.findOne(stock.getId()), false);
        StockArc stockArc = new StockArc();
        stockArc.setProduct(stock.getProduct());
        stockArc.setOwner(stock.getOwner());
        stockArc.setLocation(stock.getLocation());
        stockArc.setBlockType(stock.getBlockType());
        stockArc.setLot(stock.getLot());
        stockArc.setSerialNo(stock.getSerialNo());
        stockArc.setWeight(stock.getWeight());
        stockArc.setDlc(stock.getDlc());
        stockArc.setDluo(stock.getDluo());
        stockArc.setColor(stock.getColor());
        stockArc.setQuality(stock.getQuality());
        stockArc.setCreationDate(EmsDate.getDateNow());
        stockArc.setUpdateDate(EmsDate.getDateNow());
        stockArc.setComment(stock.getComment());
        stockArc.setSupplier(stock.getSupplier());
        stockArc.setUom(stock.getUom());
        stockArc.setQuantity(stock.getQuantity());
        stockArc.setVariable1(stock.getVariable1());
        stockArc.setVariable2(stock.getVariable2());
        stockArc.setVariable3(stock.getVariable3());
        stockArc.setVariable4(stock.getVariable4());
        stockArc.setVariable5(stock.getVariable5());
        stockArc.setVariable6(stock.getVariable6());
        stockArc.setVariable7(stock.getVariable7());
        stockArc.setVariable8(stock.getVariable8());
        stockArc.setVariable9(stock.getVariable9());
        stockArc.setVariable10(stock.getVariable10());
        stockArcRepository.saveAndFlush(StockArcMapper.toEntity(stockArc, false));
    }

    private Container createContainer(SaleOrderStock saleOrderStock) {
        Container container;
        boolean containerManagement = settingRepository.findOne(1L).getPrmSettingValue().equals("1") ? true : false;
        if (containerManagement) {
            container = saleOrderStock.getContainer();
        } else {
            container = new Container();
            container.setCode(getContainerCode());
        }
        container.setLocation(saleOrderStock.getLocation());
        container.setOwner(saleOrderStock.getOwner());
        container.setWarehouse(saleOrderStock.getWarehouse());
        container.setCreationDate(EmsDate.getDateNow());
        container.setUpdateDate(EmsDate.getDateNow());
        container.setReceptionDate(saleOrderStock.getOrderDate());
        container.setReceptionDate(saleOrderStock.getOrderDate());
        return ContainerMapper.toDto(containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false)), false);
    }

    //check if all Delivery Lines are closed to close delivery
    private boolean checkIfLinesStatusClosed(CmdDelivery cmdDelivery) {
        boolean areClosed = true;
        for (CmdDeliveryLine cmdDeliveryLine : cmdDelivery.getCmdDeliveryLines()) {
            if (1 != cmdDeliveryLine.getPrmOrderStatus().getPrmOrderStatusId()) {
                areClosed = false;
                break;
            }
        }
        return areClosed;
    }

    //check if all Delivery Lines are closed to close delivery
    private boolean checkIfSaleLinesStatusClosed(CmdSaleOrder cmdSaleOrder) {
        boolean areClosed = true;
        for (CmdSaleOrderLine cmdSaleOrderLine : cmdSaleOrder.getCmdSaleOrderLines()) {
            if (1 != cmdSaleOrderLine.getPrmOrderStatus().getPrmOrderStatusId()) {
                areClosed = false;
                break;
            }
        }
        return areClosed;
    }

    private boolean checkIfOneLineComplete(CmdDelivery cmdDelivery) {

        for (CmdDeliveryLine cmdDeliveryLine : cmdDelivery.getCmdDeliveryLines()) {
            if (1 == cmdDeliveryLine.getPrmOrderStatus().getPrmOrderStatusId()) {
                return true;
            }
        }
        return false;
    }


    //function to archive delivery
    private void archiveDelivery(Delivery delivery) {
        DeliveryArc deliveryArc = new DeliveryArc();
        deliveryArc.setTransportContact(delivery.getTransportContact());
        deliveryArc.setTransport(delivery.getTransport());
        deliveryArc.setImmatriculation(delivery.getImmatriculation());
        deliveryArc.setOrderStatus(delivery.getOrderStatus());
        deliveryArc.setWarehouse(delivery.getWarehouse());
        deliveryArc.setCode(delivery.getCode());
        SaleOrderArc saleOrderArc;
        try {
            saleOrderArc = SaleOrderArcMapper.toDto(saleOrderArcRepository.findOne(Search.expression("code:" + delivery.getSaleOrder().getCode(), CmdSaleOrderArc.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            saleOrderArc = null;
        } catch (ErrorType errorType) {
            saleOrderArc = null;
        }
        deliveryArc.setSaleOrder(saleOrderArc);
        deliveryArc.setDescription(delivery.getDescription());
        deliveryArc.setDeliveryAddress(delivery.getDeliveryAddress());
        deliveryArc.setContainerCount(delivery.getContainerCount());
        deliveryArc.setCreationDate(EmsDate.getDateNow());
        deliveryArc.setUpdateDate(EmsDate.getDateNow());
        deliveryArc.setExpectedDate(delivery.getExpectedDate());
        deliveryArc.setOwner(delivery.getOwner());
        deliveryArc.setLoadDate(delivery.getLoadDate());
        deliveryArc.setRemarks(delivery.getRemarks());
        deliveryArc.setOrderType(delivery.getOrderType());
        deliveryArc.setAccount(delivery.getAccount());
        archiveDeliveryLines(delivery, deliveryArc);
        deliveryArcRepository.saveAndFlush(DeliveryArcMapper.toEntity(deliveryArc, false));
    }

    //Archive all the lines
    private void archiveDeliveryLines(Delivery delivery, DeliveryArc deliveryArc) {

        Set<DeliveryLineArc> deliveryLineArcs = new HashSet<>();
        delivery.getLines().stream().forEach(deliveryLine -> {
            SaleOrderLineArc saleOrderLineArc = null;
            try {
                saleOrderLineArc = SaleOrderLineArcMapper.toDto(saleOrderLineArcRepository.findOne(Search.expression("lineNumber:" + deliveryLine.getSaleOrderLine().getLineNumber() + ",saleOrder.code:" + delivery.getSaleOrder().getCode(), CmdSaleOrderLineArc.class)), false);
            } catch (AttributesNotFound attributesNotFound) {
                attributesNotFound.printStackTrace();
            } catch (ErrorType errorType) {
                errorType.printStackTrace();
            }

            DeliveryLineArc deliveryLineArc = new DeliveryLineArc();
            deliveryLineArc.setSaleOrderLine(saleOrderLineArc);
            deliveryLineArc.setProduct(deliveryLine.getProduct());
            deliveryLineArc.setUom(deliveryLine.getUom());
            deliveryLineArc.setLineNumber(deliveryLine.getLineNumber());
            deliveryLineArc.setWarehouse(deliveryLine.getWarehouse());
            deliveryLineArc.setOrderStatus(deliveryLine.getOrderStatus());
            deliveryLineArc.setOwner(deliveryLine.getOwner());
            deliveryLineArc.setBlockType(deliveryLine.getBlockType());
            deliveryLineArc.setQuantityServed(deliveryLine.getQuantityServed());
            deliveryLineArc.setOrderedQuantity(deliveryLine.getOrderedQuantity());
            deliveryLineArc.setComment(deliveryLine.getComment());
            deliveryLineArc.setLocation(deliveryLine.getLocation());
            deliveryLineArc.setColor(deliveryLine.getColor());
            deliveryLineArc.setDlc(deliveryLine.getDlc());
            deliveryLineArc.setDluo(deliveryLine.getDluo());
            deliveryLineArc.setWeight(deliveryLine.getWeight());
            deliveryLineArc.setQuality(deliveryLine.getQuality());
            if (null != saleOrderLineArc && null != saleOrderLineArc.getContainer())
                deliveryLineArc.setContainer(saleOrderLineArc.getContainer());
            deliveryLineArc.setSerialNo(deliveryLine.getSerialNo());
            deliveryLineArc.setLot(deliveryLine.getLot());
            deliveryLineArcs.add(deliveryLineArc);
        });
        deliveryArc.setLines(deliveryLineArcs);
    }

    //function that chekck if the container to archive is not used in other lines
    private boolean checkContainerInStockanDelivery(Container container) {
        List<CmdSaleOrderLine> cmdSaleOrderLines = null;
        List<StkStock> stkStocks = null;
        List<CmdDeliveryLine> cmdDeliveryLines = null;
        ArrayList<RcpReceptionStock> rcpReceptionStocks = null;
        try {
            cmdSaleOrderLines = Lists.newArrayList(saleOrderLineRepository.findAll(Search.expression("container.code:" + container.getCode(), CmdSaleOrderLine.class)));
            stkStocks = Lists.newArrayList(stockRepository.findAll(Search.expression("container.code:" + container.getCode(), StkStock.class)));
            cmdDeliveryLines = Lists.newArrayList(deliveryLineRepository.findAll(Search.expression("container.code:" + container.getCode(), CmdDeliveryLine.class)));
            rcpReceptionStocks = Lists.newArrayList(receptionStockRepository.findAll(Search.expression("container.code:" + container.getCode(), RcpReceptionStock.class)));
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }
        if ((null == cmdSaleOrderLines || 0 == cmdSaleOrderLines.size())
                && (null == stkStocks || 0 == stkStocks.size())
                && (null == cmdDeliveryLines || 0 == cmdDeliveryLines.size())
                && (null == rcpReceptionStocks || 0 == rcpReceptionStocks.size())
                ) {
            return true;

        } else {
            return false;
        }
    }

    //archive container
    private ContainerArc archiveContainer(Container container) {
        container = ContainerMapper.toDto(containerRepository.findOne(container.getId()), false);
        ContainerArc containerArc = new ContainerArc();
        containerArc.setOwner(container.getOwner());
        containerArc.setWarehouse(container.getWarehouse());
        containerArc.setCode(container.getCode());
        containerArc.setLocation(container.getLocation());
        containerArc.setCreationDate(EmsDate.getDateNow());
        containerArc.setVariable1(container.getVariable1());
        containerArc.setVariable2(container.getVariable2());
        containerArc.setVariable3(container.getVariable3());
        containerArc.setVariable4(container.getVariable4());
        containerArc.setVariable5(container.getVariable5());
        containerArc.setVariable6(container.getVariable6());
        containerArc.setVariable7(container.getVariable7());
        containerArc.setVariable8(container.getVariable8());
        containerArc.setVariable9(container.getVariable9());
        containerArc.setVariable10(container.getVariable10());
        containerArc = ContainerArcMapper.toDto(containerArcRepository.saveAndFlush(ContainerArcMapper.toEntity(containerArc, false)), false);
        return containerArc;
    }

    //delete archived Container
    private void deleteArchivedContainer(SaleOrder saleOrder) {
        saleOrder.getLines().stream().forEach(saleOrderLine -> {
            if (checkContainerInStockanDelivery(saleOrderLine.getContainer())) {
                try {
                    containerRepository.delete(saleOrderLine.getContainer().getId());
                } catch (Exception e) {
                    //
                }

            }
        });
    }

    private void archiveSaleOrder(SaleOrder saleOrder) {
        SaleOrderArc saleOrderArc = new SaleOrderArc();
        saleOrderArc.setCode(saleOrder.getCode());
        saleOrderArc.setDescription(saleOrder.getDescription());
        saleOrderArc.setOwner(saleOrder.getOwner());
        saleOrderArc.setOrderStatus(saleOrder.getOrderStatus());
        saleOrderArc.setAccount(saleOrder.getAccount());
        saleOrderArc.setOrderType(saleOrder.getOrderType());
        saleOrderArc.setCustomerCode(saleOrder.getCustomerCode());
        saleOrderArc.setSupplier(saleOrder.getSupplier());
        saleOrderArc.setTransport(saleOrder.getTransport());
        saleOrderArc.setTransfertCode(saleOrder.getTransfertCode());
        saleOrderArc.setTransportContact(saleOrder.getTransportContact());
        saleOrderArc.setTransportTel(saleOrder.getTransportTel());
        saleOrderArc.setWarehouse(saleOrder.getWarehouse());
        saleOrderArc.setWarehouseDestination(saleOrder.getWarehouseDestination());
        saleOrderArc.setAddressBySaleOrderDeliveryAddress(saleOrder.getAddressBySaleOrderDeliveryAddress());
        saleOrderArc.setAddressBySaleOrderInvoiceAddress(saleOrder.getAddressBySaleOrderInvoiceAddress());
        saleOrderArc.setCmdSaleOrderNumberLine(saleOrder.getCmdSaleOrderNumberLine());
        saleOrderArc.setCmdSaleOrderNumberLineCmd(saleOrder.getCmdSaleOrderNumberLineCmd());
        saleOrderArc.setLoadDate(saleOrder.getLoadDate());
        saleOrderArc.setContainers(saleOrder.getContainers());
        saleOrderArc.setCreationDate(saleOrder.getCreationDate());
        saleOrderArc.setExpectedDate(saleOrder.getExpectedDate());
        saleOrderArc.setImmatriculation(saleOrder.getImmatriculation());
        saleOrderArc.setRemarks(saleOrder.getRemarks());
        saleOrderArc.setUpdateDate(saleOrder.getUpdateDate());
        saleOrderArc.setVariable1(saleOrder.getVariable1());
        saleOrderArc.setVariable2(saleOrder.getVariable2());
        saleOrderArc.setVariable3(saleOrder.getVariable3());
        saleOrderArc.setVariable4(saleOrder.getVariable4());
        saleOrderArc.setVariable5(saleOrder.getVariable5());
        saleOrderArc.setVariable6(saleOrder.getVariable6());
        saleOrderArc.setVariable7(saleOrder.getVariable7());
        saleOrderArc.setVariable8(saleOrder.getVariable8());
        saleOrderArc.setVariable9(saleOrder.getVariable9());
        saleOrderArc.setVariable10(saleOrder.getVariable10());
        archiveSaleOrderLines(saleOrderArc, saleOrder);
        saleOrderArcRepository.saveAndFlush(SaleOrderArcMapper.toEntity(saleOrderArc, false));
    }

    private void archiveSaleOrderLines(SaleOrderArc saleOrderArc, SaleOrder saleOrder) {
        Set<SaleOrderLineArc> saleOrderLineArcs = new HashSet<>();
        saleOrder.getLines().forEach(saleOrderLine -> {
            SaleOrderLineArc saleOrderLineArc = new SaleOrderLineArc();
            saleOrderLineArc.setProduct(saleOrderLine.getProduct());
            saleOrderLineArc.setUom(saleOrderLine.getUom());
            saleOrderLineArc.setLineNumber(saleOrderLine.getLineNumber());
            saleOrderLineArc.setWarehouse(saleOrderLine.getWarehouse());
            saleOrderLineArc.setOrderStatus(saleOrderLine.getOrderStatus());
            saleOrderLineArc.setOwner(saleOrderLine.getOwner());
            saleOrderLineArc.setBlockType(saleOrderLine.getBlockType());
            saleOrderLineArc.setQuantityServed(saleOrderLine.getQuantityServed());
            saleOrderLineArc.setQuantity(saleOrderLine.getQuantity());
            saleOrderLineArc.setComment(saleOrderLine.getComment());
            saleOrderLineArc.setLocation(saleOrderLine.getLocation());
            saleOrderLineArc.setColor(saleOrderLine.getColor());
            saleOrderLineArc.setDlc(saleOrderLine.getDlc());
            saleOrderLineArc.setDluo(saleOrderLine.getDluo());
            saleOrderLineArc.setWeight(saleOrderLine.getWeight());
            saleOrderLineArc.setQuality(saleOrderLine.getQuality());
            ContainerArc containerArc;
            try {
                containerArc = ContainerArcMapper.toDto(containerArcRepository.findOne(Search.expression("code:" + saleOrderLine.getContainer().getCode(), StkContainerArc.class)), false);
            } catch (AttributesNotFound attributesNotFound) {
                containerArc = null;
            } catch (ErrorType errorType) {
                containerArc = null;
            }
            if (null == containerArc) {
                containerArc = archiveContainer(saleOrderLine.getContainer());
            }
            saleOrderLineArc.setContainer(containerArc);
            saleOrderLineArc.setSerialNo(saleOrderLine.getSerialNo());
            saleOrderLineArc.setLot(saleOrderLine.getLot());
            saleOrderLineArcs.add(saleOrderLineArc);
        });

        saleOrderArc.setLines(saleOrderLineArcs);
    }

    //archive saleOrderStocks related with deliveryLine
    private void archiveSaleOrderStock(Delivery delivery) throws AttributesNotFound, ErrorType {
        delivery.getLines().stream().forEach(deliveryLine -> {
            List<SaleOrderStock> saleOrderStocks = null;
            try {
                saleOrderStocks = SaleOrderStockMapper.toDtos(saleOrderStockRepository.findAll(Search.expression("deliveryLine.id:" + deliveryLine.getId(), CmdSaleOrderStock.class)), false);
            } catch (AttributesNotFound attributesNotFound) {
                attributesNotFound.printStackTrace();
            } catch (ErrorType errorType) {
                errorType.printStackTrace();
            }
            for (SaleOrderStock saleOrderStock : saleOrderStocks) {
                SaleOrderStockArc saleOrderStockArc = new SaleOrderStockArc();
                DeliveryArc deliveryArc = null;
                DeliveryLineArc deliveryLineArc = null;
                try {
                    deliveryArc = DeliveryArcMapper.toDto(deliveryArcRepository.findOne(Search.expression("code:" + saleOrderStock.getDelivery().getCode(), CmdDeliveryArc.class)), false);
                    deliveryLineArc = DeliveryLineArcMapper.toDto(deliveryLineArcRepository.findOne(Search.expression("delivery.code:" + saleOrderStock.getDelivery().getCode() + ",lineNumber:" + saleOrderStock.getDeliveryLine().getLineNumber(), CmdDeliveryLineArc.class)), false);
                } catch (AttributesNotFound attributesNotFound) {
                    //TODO replace with log
                    //    attributesNotFound.printStackTrace();
                } catch (ErrorType errorType) {
                    //TODO replace with log
                    //errorType.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                saleOrderStockArc.setDeliveryLine(deliveryLineArc);
                saleOrderStockArc.setDelivery(deliveryArc);
                saleOrderStockArc.setColor(saleOrderStock.getColor());
                saleOrderStockArc.setWarehouse(saleOrderStock.getWarehouse());
                saleOrderStockArc.setBlockType(saleOrderStock.getBlockType());
                saleOrderStockArc.setCreationDate(EmsDate.getDateNow());
                saleOrderStockArc.setUpdateDate(EmsDate.getDateNow());
                saleOrderStockArc.setDlc(saleOrderStock.getDlc());
                saleOrderStockArc.setDluo(saleOrderStock.getDluo());
                saleOrderStockArc.setLocation(saleOrderStock.getLocation());
                saleOrderStockArc.setQuality(saleOrderStock.getQuality());
                saleOrderStockArc.setQuantityServed(saleOrderStock.getQuantityServed());
                saleOrderStockArc.setLineNumber(saleOrderStock.getLineNumber());
                saleOrderStockArc.setLot(saleOrderStock.getLot());
                saleOrderStockArc.setOrderDate(saleOrderStock.getOrderDate());
                saleOrderStockArc.setSerialNo(saleOrderStock.getSerialNo());
                saleOrderStockArc.setProduct(saleOrderStock.getProduct());
                saleOrderStockArc.setWeight(saleOrderStock.getWeight());
                saleOrderStockArc.setUom(saleOrderStock.getUom());
                saleOrderStockArc.setOwner(saleOrderStock.getOwner());
                saleOrderStockArc.setQuantityServed(saleOrderStock.getQuantityServed());
                saleOrderStockArcRepository.save(SaleOrderStockArcMapper.toEntity(saleOrderStockArc, false));
                saleOrderStockRepository.delete(saleOrderStock.getId());
            }
        });
    }

    private String getContainerCode() {
        return String.format("%1$018d", containerRepository.getNextVal().get(0));
    }

    private Stock createStock(Stock stock, Uom uom, BigDecimal quantity, Location location, Container container) {

        Stock stk = null;
        try {
            stk = EmsClone.clone(stock, Stock.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stk.setId(0);
        stk.setUom(uom);
        stk.setLocation(location);
        stk.setQuantity(quantity);
        stk.setContainer(container);
        return StockMapper.toDto(stockRepository.saveAndFlush(StockMapper.toEntity(stk, false)), false);
    }

    private BigDecimal convertUom(BigDecimal qte, Uom uom, Uom uomServed, Product product) {
        try {
            product = productService.findById(product.getId());
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }

        List<ProductPack> productPacks = Lists.newArrayList(product.getProductPacks());
        ProductPack served = new ProductPack();
        ProductPack expected = new ProductPack();


        for (ProductPack productPack : productPacks) {
            if (productPack.getUom().equals(uomServed)) {
                served = productPack;
            }
            if (productPack.getUom().equals(uom)) {
                expected = productPack;
            }
        }
        BigDecimal newQte = qte.multiply(served.getQuantity().divide(expected.getQuantity(), 2, RoundingMode.HALF_DOWN));

        return newQte;

    }

    private SaleOrderStock copySaleOrderStock(SaleOrderStock saleOrderStock, BigDecimal quantity, Stock stock) {
        SaleOrderStock orderStock = null;
        try {
            orderStock = EmsClone.clone(saleOrderStock, SaleOrderStock.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        orderStock.setId(0);
        orderStock.setQuantityServed(quantity);
        orderStock.setStock(stock);
        CmdSaleOrderStock cmdSaleOrderStock = saleOrderStockRepository.saveAndFlush(SaleOrderStockMapper.toEntity(orderStock, false));
        return SaleOrderStockMapper.toDto(cmdSaleOrderStock, false);

    }
    @Autowired
    private StockReservedService stockReservedService;
    private void deleteStockReserveds(Long id)
    {
        List<StockReserved> stockReserveds = null;
        try {
            stockReserveds = stockReservedService.find("saleOrderLine.id:" + id);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }
        if(!stockReserveds.isEmpty())
        for(StockReserved stockReserved:stockReserveds)
            stockReservedService.delete(stockReserved);
    }
}