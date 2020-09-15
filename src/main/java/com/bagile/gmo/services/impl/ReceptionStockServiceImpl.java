package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.RcpReceptionStock;
import com.bagile.gmo.exceptions.*;
import com.bagile.gmo.mapper.ReceptionStockMapper;
import com.bagile.gmo.repositories.ReceptionStockRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.EmsComprator;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReceptionStockServiceImpl implements ReceptionStockService {

    @Autowired
    private ReceptionStockRepository receptionStockRepository;
    @Autowired
    private StockService stockService;
    @Autowired
    private SettingService settingService;
    @Autowired
    private ContainerService containerService;
    @Autowired
    private ReceptionLineService receptionLineService;
    @Autowired
    private PurshaseOrderLineService purshaseOrderLineService;
    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private ReceptionService receptionService;
    @Autowired
    private PurshaseOrderService purshaseOrderService;
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductPackService productPackService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ReceptionStockServiceImpl.class);

    /**
     * create reception stock
     *
     * @param receptionStock
     * @return
     * @throws AttributesNotFound
     * @throws ErrorType
     * @throws ContainerException
     * @throws ProductControls
     * @throws IdNotFound
     */
    @Override
    @Transactional(rollbackFor = {ContainerException.class, CustomException.class})
    public synchronized ReceptionStock save(ReceptionStock receptionStock) throws AttributesNotFound, ErrorType, ContainerException, ProductControls, IdNotFound, CustomException {
       /* if (taskService.checkProductIfIsInInventoring(receptionStock.getProduct())) {
            throw new CustomException("Le produit ne peut être receptionné une tàche d'inventaire est activé ");
        }*/

        if (0 == receptionStock.getId()) {
            LOGGER.info(">Create a new ReceptionStock ");

            receptionStock.setCreationDate(EmsDate.getDateNow());
            receptionStock.setUpdateDate(EmsDate.getDateNow());
            receptionStock.setReceptionDate(null == receptionStock.getReceptionDate() ? receptionStock.getReception().getReceptionDate() == null ? EmsDate.getDateNow() : receptionStock.getReception().getReceptionDate() : receptionStock.getReceptionDate());
            ReceptionLine receptionLine = receptionStock.getReceptionLine();
            PurshaseOrderLine purshaseOrderLine = null;
            PurshaseOrder purshaseOrder = null;
            Boolean accounted = null;
            if (null != receptionLine) {
                accounted = receptionLine.getReception().getAccounted();
            }
            if (null != receptionLine.getPurshaseOrderLine()) {
                purshaseOrderLine = purshaseOrderLineService.findById(receptionLine.getPurshaseOrderLine().getId());
                purshaseOrder = purshaseOrderService.findById(purshaseOrderLine.getPurshaseOrder().getId());
            }
            Stock stock = null;
            if (null != receptionLine) { //check if receptionLine is not null
                receptionLine = receptionLineService.findById(receptionLine.getId());
               if (!checkStatus(receptionLine)) { // check status
                    return null;
                }
                receptionLine = compareRlineRStock(receptionLine, receptionStock);//compare receptionLine and receptionStock
            } else { //si reception line = null
                receptionLine = createReceptionLine(receptionStock, receptionStock.getQuantityReceived());//creation reception line
            }
            if (receptionStock.getProduct().getStocked() && receptionStock.getProduct().getStocked()) {
                Container container;
                if (receptionLine.getId() == 0) {//if new receptionLine

                    container = checkContainer(receptionStock);
                    if (null == container)
                        try {
                            container = containerService.createContainer(receptionStock);
                            receptionStock.setContainer(container);
                        } catch (Exception e) {
                            throw new ContainerException("Code conteneur existe déja");
                        }

                    receptionLine = receptionLineService.save(receptionLine); //sauvgarder reception line
                    receptionStock.setReceptionLine(receptionLine);

                    stock = stockService.createStock(receptionStock, accounted);
                } else { //if receptionline exist
                    stock = checkStock(receptionStock); //search stock
                    if (null != stock) {
                        container = stock.getContainer();
                        stock.setQuantity(stock.getQuantity().add(receptionStock.getQuantityReceived()));
                        receptionStock.setContainer(container);
                    } else {
                        container = checkContainer(receptionStock);
                        if (null == container)
                            try {
                                container = containerService.createContainer(receptionStock);
                            } catch (Exception e) {
                                throw e;
                            }
                        receptionStock.setContainer(container);
                        stock = stockService.createStock(receptionStock, accounted);
                        stock = stockService.save(stock);
                    }
                    //receptionLine = checkQuantity(receptionLine, receptionStock, stock);
                }
            }
            if (null != receptionStock.getBlockType()) {
                receptionLine.setBlockType(receptionStock.getBlockType());
            }
            receptionLine.setReceptionDate(receptionLine.getReceptionDate() == null ? receptionStock.getReceptionDate() : receptionLine.getReceptionDate());
            receptionLineService.updateReceptionLine(receptionLine);

            receptionLineService.save(receptionLine);
            Reception reception = receptionService.findById(receptionStock.getReception().getId());
            if (null == reception.getReceptionDate()) {
                reception.setReceptionDate(receptionStock.getReceptionDate());
            }
            receptionService.updateReception(reception);


            if (null != purshaseOrderLine) {
                purshaseOrderLine.setBlockType(receptionStock.getBlockType());
                purshaseOrderLine.setBlockedQuantity(receptionLine.getBlockedQuantity());
                purshaseOrderLine.setBlockType(receptionLine.getBlockType());
                purshaseOrderLine.setReceptionDate(purshaseOrderLine.getReceptionDate() == null ? receptionStock.getReceptionDate() : purshaseOrderLine.getReceptionDate());
                purshaseOrderLine = checkUomPurshaseOrderLine(receptionStock, purshaseOrderLine);
                purshaseOrderLineService.updatePurshaseOrderLine(purshaseOrderLine);
                purshaseOrderService.updatePurshaseOrder(purshaseOrder);
            }

            receptionStock = ReceptionStockMapper.toDto(receptionStockRepository.saveAndFlush(ReceptionStockMapper.toEntity(receptionStock, false)), false);
            if (stock != null) {
                stock.setReceptionStock(receptionStock);
                stockService.save(stock);
            }
            return receptionStock;
        } else {
            LOGGER.info(">update an existing  ReceptionStock ");

            return ReceptionStockMapper.toDto(receptionStockRepository.saveAndFlush(ReceptionStockMapper.toEntity(receptionStock, false)), false);
        }
    }


    @Override
    public Long size() {
        return receptionStockRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionStockRepository.existsById(id);
    }

    @Override
    public ReceptionStock findById(Long id) throws IdNotFound {
        ReceptionStock receptionStock = ReceptionStockMapper.toDto(receptionStockRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
        if (null != receptionStock) {
            return receptionStock;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public ReceptionStock findOne(String search) throws AttributesNotFound, ErrorType {
        return ReceptionStockMapper.toDto(receptionStockRepository.findOne(Search.expression
                (search, RcpReceptionStock.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public List<ReceptionStock> find(String search) throws AttributesNotFound, ErrorType {
        return ReceptionStockMapper.toDtos(receptionStockRepository.findAll(Search.expression(search, RcpReceptionStock.class)), false);
    }

    @Override
    public List<ReceptionStock> find(String search, int page,int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ReceptionStockMapper.toDtos(receptionStockRepository.findAll(Search.expression(search, RcpReceptionStock.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return receptionStockRepository.count(Search.expression(search, RcpReceptionStock.class));
    }

    @Override
    public void delete(Long id) {
        receptionStockRepository.deleteById(id);
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
    public List<ReceptionStock> findAll(int page,int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ReceptionStockMapper.toDtos(receptionStockRepository.findAll(pageable), false);
    }
    @Override
    public Boolean checkStatus(ReceptionLine receptionLine) {
        return 1 != receptionLine.getOrderStatus().getId();
    }


    /**
     * check if container exist's and used in the same reception
     *
     * @param receptionStock
     * @return
     */
    @Override
    public Container checkContainer(ReceptionStock receptionStock) {
        LOGGER.info("> Checking receptionStock Container");
        Container container = null;
        try {
            if (receptionStock.getContainer() == null) return null;
            List<Container> containers = containerService.find("code:" + receptionStock.getContainer().getCode());
            if (null != containers && !containers.isEmpty()) {
                container = containers.get(0);
            }
            if (null == container) {
                return null;
            } else {
                if (null != checkStock(receptionStock)) {
                    return container;
                } else {
                    List<Stock> stocks = stockService.find("receptionStock.reception.code:" + receptionStock.getReception().getCode() + ",container.code:" + receptionStock.getContainer().getCode());
                    List<Stock> stocks2 = stockService.find("container.code:" + receptionStock.getContainer().getCode());
                    if (stocks2.size() == stocks.size()) {
                        return container;
                    } else {
                        return null;
                    }
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
            LOGGER.error("< error at checking receptionStock container : Attribute not fount exception");
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
        }
        LOGGER.info("< return null from checking receptionStock Container");
        return null;
    }

    /**
     * create new reception line
     *
     * @param receptionStock
     * @param quantity
     * @return
     */
    @Override
    public ReceptionLine createReceptionLine(ReceptionStock receptionStock, BigDecimal quantity) {
        LOGGER.info("> Creating ReceptionLine");
        ReceptionLine receptionLine = new ReceptionLine();
        try {
            receptionLine.setContainerCode(receptionStock.getContainer().getCode());
            receptionLine.setProduct(receptionStock.getProduct());
            receptionLine.setColor(receptionStock.getColor());
            receptionLine.setUomReceived(receptionStock.getUom());
            receptionLine.setUom(receptionStock.getUom());
            receptionLine.setProductPack(receptionStock.getProductPack());
            receptionLine.setProductPackReceived(receptionStock.getProductPack());
            receptionLine.setOwner(receptionStock.getOwner());
            receptionLine.setDlc(receptionStock.getDlc());
            receptionLine.setDluo(receptionStock.getDluo());
            receptionLine.setQuantityReceived(quantity);
            if (null != receptionStock.getBlockType())
                receptionLine.setBlockedQuantity(quantity);
            else
                receptionLine.setQuantity(quantity);
            receptionLine.setLot(receptionStock.getLot());
            receptionLine.setReception(receptionStock.getReception());
            receptionLine.setWarehouse(receptionStock.getWarehouse());
            receptionLine.setCreationDate(EmsDate.getDateNow());
            receptionLine.setUpdateDate(EmsDate.getDateNow());
            receptionLine.setSerialNo(receptionStock.getSerialNo());
            receptionLine.setReceptionDate(receptionStock.getReceptionDate());
            receptionLine.setQuantity(BigDecimal.ZERO);
            receptionLine.setOrderStatus(orderStatusService.closedStatus());
            receptionLine.setReception(receptionStock.getReception());
            Set<ReceptionLine> rcpReceptionLines = receptionService.findById(receptionStock.getReception().getId()).getReceptionLines();
            long lineNumber = (rcpReceptionLines == null || rcpReceptionLines.size() == 0) ? 1000 : (rcpReceptionLines.size() + 1) * 1000;
            receptionLine.setLineNumber(lineNumber);
            receptionLine.setReceptionDate(EmsDate.getDateNow());
            receptionLine.setCreationDate(EmsDate.getDateNow());
            receptionLine.setUpdateDate(EmsDate.getDateNow());
        } catch (Exception e) {
            LOGGER.info("> Error at creating ReceptionLine");
            //LOGGER.error(e.getMessage(),e);
        }
        LOGGER.info("> ReceptionLine created");
        return receptionLine;

    }


    /**
     * search for stock if it exists with the same values as receptionStock
     *
     * @param receptionStock
     * @return founded stock
     */
    @Override
    public Stock checkStock(ReceptionStock receptionStock) {
        LOGGER.info("> Checking Stock existance");
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
        if (null != receptionStock.getProductPack()) {
            search.append(",productPack.id:");
            search.append(receptionStock.getProductPack().getId());
        }
        if (null != receptionStock.getContainer()) {
            if (null != receptionStock.getContainer().getCode() && !"".equals(receptionStock.getContainer().getCode().trim())) {
                search.append(",container.code:");
                search.append(receptionStock.getContainer().getCode());
            }
        }
        if (null != receptionStock.getWarehouse()) {
            search.append(",warehouse.code:");
            search.append(receptionStock.getWarehouse().getCode());

        }

        try {
            stocks = stockService.find(search.toString());
        } catch (AttributesNotFound attributesNotFound) {
            LOGGER.error(attributesNotFound.getMessage());
        } catch (ErrorType errorType) {
            LOGGER.error(errorType.getMessage());
        }
        if (stocks != null)
            for (Stock stock : stocks) {
                if (EmsComprator.compare(receptionStock.getLocation(), stock.getLocation())
                        && EmsComprator.compare(receptionStock.getUom(), stock.getUom())
                        && (!settingService.containerManagement() || EmsComprator.compare(receptionStock.getContainer().getCode(), stock.getContainer().getCode()))
                        && (!settingService.dlcManagement() || EmsComprator.compare(receptionStock.getDlc(), stock.getDlc()))
                        && (!settingService.containerManagement() || EmsComprator.compare(receptionStock.getDluo(), stock.getDluo()))
                        && (!settingService.lotManagement() || EmsComprator.compare(receptionStock.getLot(), stock.getLot()))
                        && (!settingService.weightManagement() || EmsComprator.compare(receptionStock.getWeight(), stock.getWeight()))
                        && (!settingService.qualityManagement() || EmsComprator.compare(receptionStock.getQuality(), stock.getQuality()))
                        && EmsComprator.compare(receptionStock.getProduct(), stock.getProduct())
                        && EmsComprator.compare(receptionStock.getBlockType(), stock.getBlockType())
                        && EmsComprator.compare(receptionStock.getOwner(), stock.getOwner())
                        && (!settingService.colorManagement() || EmsComprator.compare(receptionStock.getColor(), stock.getColor()))
                        && (!settingService.serialNumberManagement() || EmsComprator.compare(receptionStock.getSerialNo(), stock.getSerialNo()))
                        && EmsComprator.compare(receptionStock.getSupplier(), stock.getSupplier())

                        ) {
                    return stock;
                }
            }
        return null;
    }

    /**
     * compare reception line and reception stock if they not equal create new reception line
     *
     * @param receptionLine
     * @param receptionStock
     * @return
     */

    @Override
    public ReceptionLine compareRlineRStock(ReceptionLine receptionLine, ReceptionStock receptionStock) {
        boolean check = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        if (null != receptionLine.getContainerCode() && !"".equals(receptionLine.getContainerCode()))
            if (null != receptionStock.getContainer() && settingService.containerManagement())
                if (!EmsComprator.compare(receptionLine.getContainerCode(), receptionStock.getContainer().getCode()))
                    check = false;
        if (null != receptionLine.getSerialNo() && settingService.serialNumberManagement())
            if (!EmsComprator.compare(receptionLine.getSerialNo(), receptionStock.getSerialNo()))
                check = false;
        if (null != receptionLine.getLot() && settingService.lotManagement())
            if (!EmsComprator.compare(receptionLine.getLot(), receptionStock.getLot()))
                check = false;
        if (null != receptionLine.getQuality() && settingService.qualityManagement())
            if (!EmsComprator.compare(receptionLine.getQuality(), receptionStock.getQuality()))
                check = false;
        if (null != receptionLine.getWeight() && settingService.weightManagement())
            if (!EmsComprator.compare(receptionLine.getWeight(), receptionStock.getWeight()))
                check = false;
        if (null != receptionLine.getColor() && settingService.colorManagement())
            if (!EmsComprator.compare(receptionLine.getColor(), receptionStock.getColor()))
                check = false;
        if (null != receptionLine.getDlc() && settingService.dlcManagement()) {
            if (null != receptionStock.getDlc()) {
                c1.setTime(receptionLine.getDlc());
                c2.setTime(receptionStock.getDlc());
                if (!EmsComprator.compare(simpleDateFormat.format(c1.getTime()), simpleDateFormat.format(c2.getTime())))
                    check = false;
            }
        }
        if (null != receptionLine.getDluo() && settingService.dluoManagement()) {
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
            return createReceptionLine(receptionStock, receptionStock.getQuantityReceived());
        }

    }

    //check if all Reception Lines are closed to close Reception

    /**
     * compare  Uom recieved on reception stock and Uom expected on reception line
     * and update the received Quantity and received Uoms on reception line
     *
     * @param receptionStock
     * @param receptionLine
     * @return updated receptionLine
     */
    @Override
    public ReceptionLine checkUom(ReceptionStock receptionStock, ReceptionLine receptionLine) {
        LOGGER.info("> Checking UOM of receptionStock & receptionLine");
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
            receptionLine.setUomReceived(receptionStock.getUom());
            if (null != receptionStock.getProductPack())
                receptionLine.setProductPackReceived(receptionStock.getProductPack());
            else {
                List<ProductPack> productPacks = null;
                try {
                    productPacks = productPackService.find("uom.id:" + receptionStock.getUom().getId() + "product.id:" + receptionStock.getProduct().getId());
                } catch (AttributesNotFound | ErrorType e) {
                    LOGGER.error(e.getMessage(), e);
                }
                receptionLine.setProductPackReceived(productPacks.size() > 0 ? productPacks.get(0) : null);
            }
            BigDecimal qteRecieved = productService.convertQuantityByUom(quantityReceived, receptionLine.getProductPack(), receptionStock.getProductPack()).add(quantityReceivedOld);
            Pattern pattern = Pattern.compile("\\.0+");
            Matcher matcher = pattern.matcher(qteRecieved.toString());
            if (matcher.find() || !qteRecieved.toString().contains(".")) {
                if (null != receptionStock.getBlockType()) {
                    BigDecimal qteBlocked = productService.convertQuantityByUom(quantityReceived, receptionLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(blockedQuantity);
                    receptionLine.setBlockedQuantity(qteBlocked);
                }
                receptionLine.setQuantityReceived(qteRecieved);
                return receptionLine;
            } else {
                return createReceptionLine(receptionStock, quantityReceived);
            }


        } else {
            if (null != receptionStock.getBlockType()) {
                receptionLine.setBlockedQuantity(blockedQuantity.add(quantityReceived));
                receptionLine.setBlockType(receptionStock.getBlockType());
            }
            receptionLine.setQuantityReceived(quantityReceivedOld.add(quantityReceived));
            receptionLine.setUomReceived(receptionStock.getUomReceived());
            return receptionLine;

        }
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
                    qteC =  productService.convertQuantityByUom(qteR, receptionStock.getUom(), receptionLine.getUom(), receptionStock.getProductPack());
                } else {
                    qteC = qteR;
                }
                if (!EmsComprator.compare(receptionStock.getUom(), receptionLine.getUom())) {
                    qteCA =  productService.convertQuantityByUom(qteRSA, receptionStock.getUom(), receptionLine.getUom(), receptionStock.getProductPack());
                } else {
                    qteCA = qteRSA;
                }

                receptionStock.setQuantityReceived(receptionLine.getQuantityReceived());
                if (null == stock.getQuantity()) {
                    stock.setQuantity(BigDecimal.ZERO);
                }

                stock.setQuantity(stock.getQuantity().add(qteRS));

                ReceptionLine line = ReceptionLineMapper.toDto(receptionLineService.saveAndFlush(createReceptionLine(ReceptionStockMapper.toEntity(receptionStock, false), qteC)), false);
                ReceptionStock rs = null;
                try {
                    rs = EmsClone.clone(receptionStock, ReceptionStock.class);
                } catch (IOException e) {
                    return null;
                }
                rs.setComCommissionId(0);
                rs.setQuantityReceived(qteC);
                rs.setBlockType(receptionStock.getBlockType());
                rs.setReceptionLine(line);
                rs.setCreationDate(EmsDate.getDateNow());
                rs.setUpdateDate(EmsDate.getDateNow());
                rs.setReceptionDate(EmsDate.getDateNow());
                receptionStockRepository.saveAndFlush(ReceptionStockMapper.toEntity(rs, false));
               *//* Stock stk = createStock(rs);
                stockService.saveAndFlush(StockMapper.toEntity(stk, false))*//*


            }
        } catch (Exception e) {
            //LOGGER.error(e.getMessage(),e);
        }
        return receptionLine;
    }

    /**
     * compare  Uom recieved on reception stock and Uom expected on purchase order line
     * and update the received Quantity and received Uoms on purchase order line
     *
     * @param receptionStock
     * @param purshaseOrderLine
     * @return
     */
    @Override
    public PurshaseOrderLine checkUomPurshaseOrderLine(ReceptionStock receptionStock, PurshaseOrderLine purshaseOrderLine) {
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
                BigDecimal qteRecieved = productService.convertQuantityByUom(quantityReceived, purshaseOrderLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(quantityReceivedOld);
                if (null != receptionStock.getBlockType()) {
                    BigDecimal qteBlocked = productService.convertQuantityByUom(quantityReceived, purshaseOrderLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(blockedQuantity);
                    purshaseOrderLine.setBlockedQuantity(qteBlocked);
                }
                purshaseOrderLine.setQuantityReceived(qteRecieved);

            } else {
                if (EmsComprator.compare(purshaseOrderLine.getUomReceived(), receptionStock.getUom())) {
                    BigDecimal qteRecieved = productService.convertQuantityByUom(quantityReceived, purshaseOrderLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(quantityReceivedOld);

                    if (null != receptionStock.getBlockType()) {
                        BigDecimal qteBlocked = productService.convertQuantityByUom(quantityReceived, purshaseOrderLine.getUom(), receptionStock.getUom(), receptionStock.getProduct()).add(blockedQuantity);
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


    @Override
    public List<ReceptionStock> saveAll(List<ReceptionStock> receptionStockList, boolean fromPos) {
        List<ReceptionStock> receptionStocks = new ArrayList<>();
        for (ReceptionStock rs : receptionStockList) {
            try {
                ReceptionStock savedReceptionStock = save(rs);
                if (savedReceptionStock != null) {
                    receptionStocks.add(savedReceptionStock);
                }
            } catch (ProductControls | IdNotFound | AttributesNotFound | ErrorType | CustomException | ContainerException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return receptionStocks;
    }

    @Override
    public ReceptionLine updateReceptionStock(ReceptionLine receptionLine) throws AttributesNotFound, ErrorType, IdNotFound, CustomException, ProductControls, ContainerException {
        List<ReceptionStock> receptionStocks = find("receptionLine.id:" + receptionLine.getId());
        Iterator<ReceptionStock> iterator = receptionStocks.iterator();
        BigDecimal quantityToSubtract = receptionLine.getQuantityReceived().subtract(receptionLine.getQuantity());
        while (iterator.hasNext() && quantityToSubtract.compareTo(BigDecimal.ZERO) > 0) {
            ReceptionStock receptionStock = iterator.next();
            if (receptionStock.getQuantityReceived().compareTo(quantityToSubtract) > 0) {
                receptionStock.setQuantityReceived(receptionStock.getQuantityReceived().subtract(quantityToSubtract));
                quantityToSubtract = BigDecimal.ZERO;
                Stock stock = stockService.findOne("receptionStock.id:" + receptionStock.getId());
                stock.setQuantity(receptionStock.getQuantityReceived());
                stock.setPurchasePrice(receptionLine.getPurshasePrice());
                stockService.save(stock);
            } else if (receptionStock.getQuantityReceived().compareTo(quantityToSubtract) <= 0) {
                stockService.delete(stockService.findOne("receptionStock.id:" + receptionStock.getId()));
                quantityToSubtract = quantityToSubtract.subtract(receptionStock.getQuantityReceived());
                receptionStock.setQuantityReceived(BigDecimal.ZERO);

            }
            save(receptionStock);
        }
        receptionLine.setQuantityReceived(receptionLine.getQuantity());
        return receptionLine;
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            receptionStockRepository.deleteById(id);        }
    }


}