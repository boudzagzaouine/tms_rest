package com.bagile.tms.services.impl;

import com.google.common.collect.Lists;
import com.sinno.ems.dto.*;
import com.sinno.ems.dto.SaleOrder;
import com.sinno.ems.entities.*;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.WarehouseException;
import com.sinno.ems.mapper.*;
import com.sinno.ems.mapperWms.MapperSaleOrder;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.DeliveryService;
import com.sinno.ems.service.SaleOrderService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerSaleOdrerLine;
import com.sinno.wms.crud.convertbasic.ConvertManagerSaleOrder;
import com.sinno.wms.crud.modelbasic.saleorders.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.lang.Exception;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Enissay on 21/04/2016.
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private DeliveryArcRepository deliveryArcRepository;
    @Autowired
    private MsgSendRepository msgSendRepository;
    @Autowired
    private PurshaseOrderRepository purshaseOrderRepository;
    @Autowired
    private ReceptionRepository receptionRepository;
    @Autowired
    private PurshaseOrderLineRepository purshaseOrderLineRepository;
    @Autowired
    private ReceptionArcRepository receptionArcRepository;
    @Autowired
    private ContainerArcRepository containerArcRepository;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private SaleOrderLineRepository saleOrderLineRepository;
    @Autowired
    private DeliveryLineRepository deliveryLineRepository;
    @Autowired
    private DeliveryLineArcRepository deliveryLineArcRepository;
    @Autowired
    private SaleOrderLineArcRepository saleOrderLineArcRepository;
    @Autowired
    private SaleOrderArcRepository saleOrderArcRepository;
    @Autowired
    private SaleOrderStockArcRepository saleOrderStockArcRepository;
    @Autowired
    private SaleOrderStockRepository saleOrderStockRepository;
    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DeliveryService.class);
    @Autowired
    private SettingRepository settingRepository;


    @Transactional
    @Override
    public Delivery save(Delivery delivery) throws WarehouseException {
        LOGGER.info("save Delivery");
        delivery.setUpdateDate(EmsDate.getDateNow());

        if (0 >= delivery.getId()) {
            delivery.setCreationDate(EmsDate.getDateNow());
        }

        if (0 != delivery.getId() && (3 == delivery.getOrderStatus().getId() || 1 == delivery.getOrderStatus().getId())) {
            delivery = DeliveryMapper.toDto(deliveryRepository.saveAndFlush(DeliveryMapper.toEntity(delivery, false)), false);

            if (0 > 1) {
                if (2 == delivery.getSaleOrder().getOrderStatus().getId()) {
                    LOGGER.error("save Delivery");
                    throw new WarehouseException("la commande de vente li�e a cette livraison n'est pas encore ferm� ");
                } else {
                    archiveDelivery(delivery);
                    try {
                        archiveSaleOrderStock(delivery);
                    } catch (AttributesNotFound attributesNotFound) {
                        attributesNotFound.printStackTrace();
                    } catch (ErrorType errorType) {
                        errorType.printStackTrace();
                    }
                    deliveryRepository.delete(delivery.getId());
                    deleteArchivedContainer(SaleOrderMapper.toDto(saleOrderRepository.findOne(delivery.getSaleOrder().getId()), false));
                    saleOrderRepository.delete(delivery.getSaleOrder().getId());

                }
            }
        } else {
            delivery = DeliveryMapper.toDto(deliveryRepository.saveAndFlush(DeliveryMapper.toEntity(delivery, false)), false);
        }//}
        boolean syncWms = settingRepository.findOne(2L).getPrmSettingValue().equals("1") ? true : false;
        if (syncWms) {

            PrmMsgSend msgSend = getPrmMsgSend();
            if (1 != delivery.getOrderStatus().getId() && 3 != delivery.getOrderStatus().getId() && null != msgSend && msgSend.isPrmMsgSendActive() && "xls".equals(msgSend.getPrmMsgSendFormat().trim())) {
                String code = delivery.getCode();
                int indexOf = code.lastIndexOf("-");
                if (0 < delivery.getId()) {
                    if (-1 == indexOf)
                        code = code + "-1";
                    else {
                        int number = Integer.parseInt(code.substring(indexOf + 1, code.length())) + 1;
                        code = code.substring(0, indexOf) + "-" + number;
                    }
                    for (DeliveryLine deliveryLine : delivery.getLines()) {
                        deliveryLine.setDelivery(delivery);
                    }
                }
                delivery.setSendedToWms(true);
                delivery.setCode(code);
                writeFileSaleOrder(msgSend.getPrmMsgSendPath(), delivery);
                writeFileSaleOrder(msgSend.getPrmMsgSendArcPath(), delivery);
                delivery = DeliveryMapper.toDto(deliveryRepository.saveAndFlush(DeliveryMapper.toEntity(delivery, false)), false);

            }
        }

        return delivery;
    }

    private PrmMsgSend getPrmMsgSend() {
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search
                    .expression("fileType:SOR", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator()) {
                if (msgSends.iterator().hasNext()) {
                    return msgSends.iterator().next();
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
        } catch (ErrorType errorType) {
        }
        return null;
    }

    private void writeFileSaleOrder(String path, Delivery delivery) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            com.sinno.wms.crud.modelbasic.saleorders.SaleOrder saleOrder = com.sinno.ems.mapperWms.MapperSaleOrder.convertToWmsDto(delivery);
            if (null != delivery.getSaleOrder()) {
                SaleOrder order = saleOrderService.findById(delivery.getSaleOrder().getId());
                if (null != order.getSupplier())
                    saleOrder.setSupplier_code(order.getSupplier().getCode());
            }
            String filename = path + File.separator + "ISA01" + dateFormat.format(new Date()) + ".xls";
            ConvertManagerSaleOrder.writeFileSaleOrder(filename, langue, saleOrder);

            List<com.sinno.wms.crud.modelbasic.saleorders.SaleOrderLine> WMSSaleOrderLines = new ArrayList<>();

            for (DeliveryLine line : delivery.getLines()) {
                WMSSaleOrderLines.add(com.sinno.ems.mapperWms.MapperSaleOrderLine.convertToWmsDto(line));
            }
            ConvertManagerSaleOdrerLine.writeFileSaleOrderLine(filename, langue, WMSSaleOrderLines);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Reception createReceptionFromDelivery(Delivery delivery) {
        Reception reception = new Reception();
        reception.setCode(delivery.getCode());
        reception.setWarehouse(delivery.getWarehouse());
        reception.setOwner(delivery.getOwner());
        reception.setLocation(delivery.getLocation());
        reception.setOrderStatus(delivery.getOrderStatus());
        reception.setOrderType(delivery.getOrderType());
        reception.setTransport(delivery.getTransport());
        reception.setTransportContact(delivery.getTransportContact());
        reception.setTransportTel(delivery.getTransportTel());
        reception.setImmatriculation(delivery.getImmatriculation());
        reception.setNumberOfContainers(delivery.getContainerCount());
        reception.setRemarks(delivery.getRemarks());
        reception.setAddress(delivery.getDeliveryAddress());
        reception.setAddress(delivery.getInvoiceAddress());
        reception.setDescription(delivery.getDescription());
        reception.setAccount(delivery.getAccount());
        reception.setDelivery(delivery);

        try {

            ArrayList<RcpPurshaseOrder> rcpPurshaseOrders = Lists.newArrayList(purshaseOrderRepository.findAll(Search.expression("transfertCode:" + delivery.getSaleOrder().getTransfertCode(), RcpPurshaseOrder.class)));
            reception.setPurshaseOrder(PurshaseOrderMapper.toDto(rcpPurshaseOrders.get(0), false));
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        reception.setCreationDate(EmsDate.getDateNow());
        reception.setUpdateDate(EmsDate.getDateNow());
        reception.setReceptionDate(delivery.getExpectedDate());

        if (10014L == delivery.getOrderType().getId()) {
            reception = setReceptionLinesFromDeliveryLinesKit(delivery, reception);
        } else if (10013L == delivery.getOrderType().getId())
            reception = setReceptionLinesFromDeliveryLines(reception, delivery);
        return reception;
    }

    private Reception setReceptionLinesFromDeliveryLines(Reception reception, Delivery delivery) {
        Set<ReceptionLine> receptionLines = new HashSet<>();
        if (null != delivery.getLines()) {
            for (DeliveryLine line : delivery.getLines()) {
                ReceptionLine receptionLine = new ReceptionLine();
                receptionLine.setProduct(line.getProduct());
                receptionLine.setLineNumber(line.getLineNumber());
                receptionLine.setUom(line.getUom());
                receptionLine.setBlockType(line.getBlockType());
                receptionLine.setComment(line.getComment());
                if (null != line.getContainer())
                    receptionLine.setContainerCode(line.getContainer().getCode());
                receptionLine.setCreationDate(line.getCreationDate());
                receptionLine.setUpdateDate(line.getUpdateDate());
                receptionLine.setLocation(line.getLocation());
                receptionLine.setWarehouse(line.getWarehouse());
                receptionLine.setOwner(line.getOwner());
                receptionLine.setOrderStatus(line.getOrderStatus());
                receptionLine.setReception(reception);
                receptionLine.setSerialNo(line.getSerialNo());
                receptionLine.setLot(line.getLot());
                receptionLine.setColor(line.getColor());
                receptionLine.setDlc(line.getDlc());
                receptionLine.setDluo(line.getDluo());
                receptionLine.setWeight(line.getWeight());
                receptionLine.setQuality(line.getQuality());
                receptionLine.setQuantityReceived(line.getQuantityServed());
                try {
                    receptionLine.setPurshaseOrderLine(searchPurshaseOrderLine(line));
                } catch (AttributesNotFound attributesNotFound) {
                    //attributesNotFound.printStackTrace();
                } catch (ErrorType errorType) {
                    //e.printStackTrace();
                }
                receptionLines.add(receptionLine);
            }
            reception.setReceptionLines(receptionLines);
        }
        return reception;
    }

    private Reception setReceptionLinesFromDeliveryLinesKit(Delivery delivery, Reception reception) {
        PurshaseOrder order = null;
        Set<ReceptionLine> lines = new HashSet<>();
        try {
            order = PurshaseOrderMapper.toDto(purshaseOrderRepository.findOne(Search.expression("transfertCode:" + delivery.getTransfertCode(), RcpPurshaseOrder.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        if (null != order) {
            order.getPurshaseOrderLines().stream().forEach(purshaseOrderLine -> {
                ReceptionLine line = new ReceptionLine();

                line.setLineNumber(purshaseOrderLine.getNumber());
                line.setQuantity(purshaseOrderLine.getQuantity());
                line.setQuantityReceived(purshaseOrderLine.getQuantityReceived());
                line.setProduct(purshaseOrderLine.getProduct());
                line.setOwner(purshaseOrderLine.getOwner());
                line.setWarehouse(purshaseOrderLine.getWarehouse());
                line.setLocation(purshaseOrderLine.getLocation());
                line.setBlockType(purshaseOrderLine.getBlockType());
                line.setBlockedQuantity(purshaseOrderLine.getBlockedQuantity());
                line.setColor(purshaseOrderLine.getColor());
                line.setContainerCode(purshaseOrderLine.getContainerCode());
                line.setDlc(purshaseOrderLine.getDlc());
                line.setDluo(purshaseOrderLine.getDluo());
                line.setLot(purshaseOrderLine.getLot());
                line.setOrderStatus(purshaseOrderLine.getOrderStatus());
                line.setDescription(purshaseOrderLine.getDescription());
                line.setPurshaseOrderLine(purshaseOrderLine);
                line.setUom(purshaseOrderLine.getUom());
                lines.add(line);

            });
            reception.setReceptionLines(lines);
        }
        return reception;
    }


    private PurshaseOrderLine searchPurshaseOrderLine(DeliveryLine line) throws AttributesNotFound, ErrorType {
        StringBuffer search = new StringBuffer();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        if (null != line.getDlc())
            c.setTime(line.getDlc());
        Calendar c2 = Calendar.getInstance();
        if (null != line.getDluo())
            c2.setTime(line.getDluo());
        search.append("purshaseOrder.transfertCode:" + line.getDelivery().getTransfertCode());
        if (null != line.getLocation()) {
            search.append(",location.code:" + line.getLocation().getCode());
        }
        if (null != line.getWarehouse()) {
            search.append(",warehouse.code:" + line.getWarehouse().getCode());
        }
        if (null != line.getOwner()) {
            search.append(",owner.code:" + line.getOwner().getCode());
        }
        if (null != line.getOrderStatus()) {
            search.append(",orderStatus.code:" + line.getOrderStatus().getCode());
        }
        if (null != line.getSerialNo()) {
            search.append(",serialNo:" + line.getSerialNo());
        }
        if (null != line.getLot()) {
            search.append(",lot:" + line.getLot());
        }
        if (null != line.getColor()) {
            search.append(",color.code:" + line.getColor().getCode());
        }
        if (null != line.getDlc()) {
            search.append(",dlc:" + format.format(c.getTime()));
        }
        if (null != line.getDluo()) {
            search.append(",dluo:" + format.format(c2.getTime()));
        }
        if (null != line.getWeight()) {
            search.append(",weight:" + line.getWeight());
        }
        if (null != line.getQuality()) {
            search.append(",quality:" + line.getQuality());
        }
        if (null != line.getOrderedQuantity()) {
            search.append(",quantity:" + line.getOrderedQuantity());
        }
        if (null != line.getBlockType()) {
            search.append(",blockType.code:" + line.getBlockType().getCode());
        }
        if (null != line.getUom()) {
            search.append(",uom.code:" + line.getUom().getCode());
        }
        if (null != line.getContainer()) {
            search.append(",containerCode:" + line.getContainer().getCode());
        }
        if (null != line.getProduct().getCode()) {
            search.append(",product.code:" + line.getProduct().getCode());
        }
        PurshaseOrderLine purshaseOrderLine = PurshaseOrderLineMapper.toDto(purshaseOrderLineRepository.findOne(Search.expression(search.toString(), RcpPurshaseOrderLine.class)), false);
        return purshaseOrderLine;
    }


    @Override
    public Long size() {
        return deliveryRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return deliveryRepository.exists(id);
    }

    @Override
    public Delivery findById(Long id) throws IdNotFound {
        Delivery delivery = DeliveryMapper.toDto(deliveryRepository.findOne(id), false);
        if (null != delivery) {
            return delivery;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Delivery> find(String search) throws AttributesNotFound, ErrorType {
        return DeliveryMapper.toDtos(deliveryRepository.findAll(Search.expression(search, CmdDelivery.class)), false);
    }

    @Override
    public List<Delivery> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "cmdDeliveryUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return DeliveryMapper.toDtos(deliveryRepository.findAll(Search.expression(search, CmdDelivery.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return deliveryRepository.count(Search.expression(search, CmdDelivery.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Delivery");
        deliveryRepository.delete(id);
    }

    @Override
    public void delete(Delivery delivery) {
        LOGGER.info("delete Delivery");
        deliveryRepository.delete(DeliveryMapper.toEntity(delivery, false));
    }

    @Override
    public List<Delivery> findAll() {
        return DeliveryMapper.toDtos(deliveryRepository.findAll(), false);
    }

    @Override
    public List<Delivery> findAll(Pageable pageable) {
        return DeliveryMapper.toDtos(deliveryRepository.findAll(pageable), false);
    }

    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = deliveryRepository.getNextVal();
        BigInteger tab = objects.get(0);
        return tab;
    }

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
            deliveryLineArc.setContainer(saleOrderLineArc.getContainer());
            deliveryLineArc.setSerialNo(deliveryLine.getSerialNo());
            deliveryLineArc.setLot(deliveryLine.getLot());
            deliveryLineArcs.add(deliveryLineArc);
        });
        deliveryArc.setLines(deliveryLineArcs);
    }

    private boolean checkContainerInStockanDelivery(Container container) {
        List<CmdSaleOrderLine> cmdSaleOrderLines = null;
        List<StkStock> stkStocks = null;
        List<CmdDeliveryLine> cmdDeliveryLines = null;
        try {
            cmdSaleOrderLines = Lists.newArrayList(saleOrderLineRepository.findAll(Search.expression("container.code:" + container.getCode(), CmdSaleOrderLine.class)));
            stkStocks = Lists.newArrayList(stockRepository.findAll(Search.expression("container.code:" + container.getCode(), StkStock.class)));
            cmdDeliveryLines = Lists.newArrayList(deliveryLineRepository.findAll(Search.expression("container.code:" + container.getCode(), CmdDeliveryLine.class)));
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }
        if ((null == cmdSaleOrderLines || 0 == cmdSaleOrderLines.size())
                && (null == stkStocks || 0 == stkStocks.size())
                && (null == cmdDeliveryLines || 0 == cmdDeliveryLines.size())
                ) {
            return true;

        } else {
            return false;
        }
    }

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

    private void writeFileSaleOrder(String path, List<Delivery> deliveries) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            List<com.sinno.wms.crud.modelbasic.saleorders.SaleOrder> saleOrderList = new ArrayList<>();
            for (Delivery d : deliveries) {
                String code = d.getCode();
                int indexOf = code.lastIndexOf("-");
                if (0 < d.getId()) {
                    if (-1 == indexOf)
                        code = code + "-1";
                    else {
                        int number = Integer.parseInt(code.substring(indexOf + 1, code.length())) + 1;
                        code = code.substring(0, indexOf) + "-" + number;
                    }

                }
                d.setCode(code);
                d.setSendedToWms(true);
                d = DeliveryMapper.toDto(deliveryRepository.saveAndFlush(DeliveryMapper.toEntity(d, false)), false);
                com.sinno.wms.crud.modelbasic.saleorders.SaleOrder saleOrder = MapperSaleOrder.convertToWmsDto(d);
                if (null != d.getSaleOrder()) {
                    SaleOrder order = saleOrderService.findById(d.getSaleOrder().getId());
                    if (null != order.getSupplier())
                        saleOrder.setSupplier_code(order.getSupplier().getCode());
                }
                saleOrderList.add(saleOrder);

            }
            String filename = path + File.separator + "ISA01" + dateFormat.format(new Date()) + ".xls";
            ConvertManagerSaleOrder.writeFileSaleOrder(filename, langue, saleOrderList);

            List<com.sinno.wms.crud.modelbasic.saleorders.SaleOrderLine> WMSSaleOrderLines = new ArrayList<>();
            for (Delivery so : deliveries) {
                so = findById(so.getId());
                for (DeliveryLine line : so.getLines()) {
                    WMSSaleOrderLines.add(com.sinno.ems.mapperWms.MapperSaleOrderLine.convertToWmsDto(line));
                }
            }
            ConvertManagerSaleOdrerLine.writeFileSaleOrderLine(filename, langue, WMSSaleOrderLines);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Delivery> exportWmsSaleOrder(List<Delivery> deliveries) {

        writeFileSaleOrder(null != getPrmMsgSend() ? getPrmMsgSend().getPrmMsgSendPath() : System.getenv("APPDATA"), deliveries);
        return deliveries;
    }

}
