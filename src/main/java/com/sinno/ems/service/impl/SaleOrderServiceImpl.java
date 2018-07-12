package com.sinno.ems.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.entities.CmdSaleOrder;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.*;
import com.sinno.ems.mapperWms.MapperSaleOrder;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.SaleOrderService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerSaleOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.Exception;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {

    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired
    private MsgSendRepository msgSendRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;
    @Autowired
    private PurshaseOrderRepository purshaseOrderRepository;
    @Autowired
    private SaleOrderArcRepository saleOrderArcRepository;
    @Autowired
    private ContainerArcRepository containerArcRepository;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private AccountRepository accountRepository;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS") ;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SaleOrderService.class);


    @Transactional
    @Override
    public SaleOrder save(SaleOrder saleOrder) {
        LOGGER.info("save SaleOrder");
        saleOrder.setUpdateDate(EmsDate.getDateNow());
        //saleOrder = SaleOrderMapper.toDto(cmdSaleOrder, false);

        if (0 >= saleOrder.getId()) {
            saleOrder.setCreationDate(EmsDate.getDateNow());
        }


        //SaleOrderExport.export(servletContext.getRealPath("/WEB-INF/classes"), cmdSaleOrder, "F",servletContext);

        if (0 >= saleOrder.getId() && 10013L == saleOrder.getOrderType().getId()) {
            saleOrder.setTransfertCode("trnsfr" + saleOrderRepository.getTransferCode());
            saleOrder = SaleOrderMapper.toDto(saleOrderRepository.saveAndFlush(SaleOrderMapper.toEntity(saleOrder, false)), false);
            purshaseOrderRepository.save(PurshaseOrderMapper.toEntity(addPurshaseOrderFromSaleOrder(saleOrder), false));
        } else {
            if (0 != saleOrder.getId() && (1 == saleOrder.getOrderStatus().getId() || 3 == saleOrder.getOrderStatus().getId())) {

                saleOrder = SaleOrderMapper.toDto(saleOrderRepository.saveAndFlush(SaleOrderMapper.toEntity(saleOrder, false)), false);
                if (0 > 1) {
                    archiveSaleOrder(saleOrder);
                }
            } else {
                saleOrder = SaleOrderMapper.toDto(saleOrderRepository.saveAndFlush(SaleOrderMapper.toEntity(saleOrder, false)), false);
            }
        }


        return saleOrder;
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




    public void readFileProductType(com.sinno.wms.crud.modelbasic.saleorders.SaleOrder saleOr) {

        try {
            saleOr = ConvertManagerSaleOrder.readFileSaleOrder("ISA01"+dateFormat.format(new Date())+".xls").get(0);
            SaleOrder saleOrder = new SaleOrder();
            saleOrder = MapperSaleOrder.convertToEmsDto(saleOrder, saleOr);
            saleOrderRepository.saveAndFlush(SaleOrderMapper.toEntity(saleOrder, false));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private PurshaseOrder addPurshaseOrderFromSaleOrder(SaleOrder saleOrder) {
        PurshaseOrder purshaseOrder = new PurshaseOrder();
        if (null == saleOrder) {
            return null;
        }
        purshaseOrder.setWarehouse(saleOrder.getWarehouse());
        purshaseOrder.setWarehouseSource(saleOrder.getWarehouseDestination());
        purshaseOrder.setOwner(saleOrder.getOwner());
        purshaseOrder.setSupplier(saleOrder.getSupplier());
        purshaseOrder.setContainers(saleOrder.getContainers());
        purshaseOrder.setImmatriculation(saleOrder.getImmatriculation());
        purshaseOrder.setAddress(saleOrder.getAddressBySaleOrderDeliveryAddress());
        purshaseOrder.setOrderStatus(saleOrder.getOrderStatus());
        purshaseOrder.setTransport(saleOrder.getTransport());
        purshaseOrder.setCode(saleOrder.getCode());
        purshaseOrder.setTransfertCode(saleOrder.getTransfertCode());
        purshaseOrder.setTelContact(saleOrder.getTransportTel());
        purshaseOrder.setRemarks(saleOrder.getRemarks());
        purshaseOrder.setDescription(saleOrder.getDescription());
        if (10013L == saleOrder.getOrderType().getId()) {
            purshaseOrder.setOrderType(OrderTypeMapper.toDto(orderTypeRepository.findOne(10000L), true));
        } else if (10014L == saleOrder.getOrderType().getId()) {
            purshaseOrder.setOrderType(OrderTypeMapper.toDto(orderTypeRepository.findOne(10011L), true));
        }
        purshaseOrder.setTransportContact(saleOrder.getTransportContact());
        purshaseOrder.setCreationDate(saleOrder.getCreationDate());
        purshaseOrder.setUpdateDate(saleOrder.getUpdateDate());
        purshaseOrder = setPurshaseOrderLinesFromSaleOrderLines(purshaseOrder, saleOrder);
        return purshaseOrder;
    }

    private PurshaseOrder setPurshaseOrderLinesFromSaleOrderLines(PurshaseOrder purshaseOrder, SaleOrder saleOrder) {
        Set<PurshaseOrderLine> purshaseOrderLines = new HashSet<>();
        for (SaleOrderLine saleOrderLine : saleOrder.getLines()) {
            PurshaseOrderLine purshaseOrderLine = new PurshaseOrderLine();
            purshaseOrderLine.setWarehouse(saleOrderLine.getWarehouse());
            purshaseOrderLine.setOwner(saleOrderLine.getOwner());
            purshaseOrderLine.setOrderStatus(saleOrderLine.getOrderStatus());
            purshaseOrderLine.setLocation(saleOrderLine.getLocation());
            purshaseOrderLine.setProduct(saleOrderLine.getProduct());
            purshaseOrderLine.setBlockType(saleOrderLine.getBlockType());
            purshaseOrderLine.setComment(saleOrderLine.getComment());
            purshaseOrderLine.setDescription(saleOrderLine.getDescription());
            purshaseOrderLine.setLot(saleOrderLine.getLot());
            purshaseOrderLine.setColor(saleOrderLine.getColor());
            purshaseOrderLine.setQuality(saleOrderLine.getQuality());
            purshaseOrderLine.setQuantity(saleOrderLine.getQuantity());
            purshaseOrderLine.setQuantityReceived(saleOrderLine.getQuantityServed());
            purshaseOrderLine.setSerialNo(saleOrderLine.getSerialNo());
            purshaseOrderLine.setDlc(saleOrderLine.getDlc());
            purshaseOrderLine.setDluo(saleOrderLine.getDluo());
            purshaseOrderLine.setWeight(saleOrderLine.getWeight());
            purshaseOrderLine.setNumber(saleOrderLine.getLineNumber());
            purshaseOrderLine.setUom(saleOrderLine.getUom());
            purshaseOrderLines.add(purshaseOrderLine);
        }
        purshaseOrder.setPurshaseOrderLines(purshaseOrderLines);
        return purshaseOrder;
    }


    @Override
    public Long size() {
        return saleOrderRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return saleOrderRepository.exists(id);
    }

    @Override
    public SaleOrder findById(Long id) throws IdNotFound {
        SaleOrder saleOrder = SaleOrderMapper.toDto(saleOrderRepository.findOne(id), false);
        if (null != saleOrder) {
            return saleOrder;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SaleOrder> find(String search) throws AttributesNotFound, ErrorType {
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(Search.expression(search, CmdSaleOrder.class)), false);
    }

    @Override
    public List<SaleOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "cmdSaleOrderUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(Search.expression(search, CmdSaleOrder.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return saleOrderRepository.count(Search.expression(search, CmdSaleOrder.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SaleOrder");
        saleOrderRepository.delete(id);
    }

    @Override
    public void delete(SaleOrder saleOrder) {
        LOGGER.info("delete SaleOrder");
        saleOrderRepository.delete(SaleOrderMapper.toEntity(saleOrder, false));
    }

    @Override
    public List<SaleOrder> findAll() {
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(), false);
    }

    @Override
    public List<SaleOrder> findAll(Pageable pageable) {
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(pageable), false);
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

    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = saleOrderRepository.getNextVal();
        return objects.get(0);
    }

    @Override
    public String getTransfertCode() {
        return "trsf" + saleOrderRepository.getTransferCode().get(0);
    }

    @Override
    @Transactional
    public SaleOrder loadWmsSaleOrder(com.sinno.wms.crud.modelbasic.saleorders.SaleOrder saleOrder) {
        SaleOrder emsSaleOrder = SaleOrderMapper.toDto(saleOrderRepository.findByCmdSaleOrderCode(saleOrder.getSorder_code()), false);
        Owner owner = OwnerMapper.toDto(ownerRepository.findByOwnOwnerCode(saleOrder.getOwner_code()), false);
        Warehouse warehouse = WarehouseMapper.toDto(warehouseRepository.findByWrhWarehouseCode(saleOrder.getWarehouse_source()), false);
        Account account = AccountMapper.toDto(accountRepository.findByCmdAccountCode(saleOrder.getAccount_code()), false);
        Transport transport = TransportMapper.toDto(transportRepository.findByTrpTransportCode(saleOrder.getCarrier_code()), false);
        Supplier supplier = SupplierMapper.toDto(supplierRepository.findByRcpSupplierCode(saleOrder.getSupplier_code()), false);
        if (null == emsSaleOrder) {
            emsSaleOrder = new SaleOrder();
            emsSaleOrder.setCreationDate(EmsDate.getDateNow());
        }
        if (null != emsSaleOrder) {
            emsSaleOrder.setUpdateDate(EmsDate.getDateNow());
            emsSaleOrder = MapperSaleOrder.convertToEmsDto(emsSaleOrder, saleOrder);
            emsSaleOrder.setTransport(transport);
            emsSaleOrder.setAccount(account);
            emsSaleOrder.setAddressBySaleOrderDeliveryAddress(account.getAddressByAccountDeliveryAddress());
            emsSaleOrder.setAddressBySaleOrderInvoiceAddress(account.getCompany().getAddress());
            if ("CUSTOMER".equals(saleOrder.getSorder_type_code().trim()))
                emsSaleOrder.setOrderType(OrderTypeMapper.toDto(orderTypeRepository.findOne(10012L), false));
            else if ("RETURN".equals(saleOrder.getSorder_type_code().trim()))
                emsSaleOrder.setOrderType(OrderTypeMapper.toDto(orderTypeRepository.findOne(10015L), false));

            emsSaleOrder.setSupplier(supplier);
            emsSaleOrder.setWarehouse(warehouse);
            emsSaleOrder.setOwner(owner);
            emsSaleOrder = SaleOrderMapper.toDto(saleOrderRepository.saveAndFlush(SaleOrderMapper.toEntity(emsSaleOrder, false)), false);
            return emsSaleOrder;
        }
        return null;
    }


}