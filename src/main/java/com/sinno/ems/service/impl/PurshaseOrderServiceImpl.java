package com.sinno.ems.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.entities.PdtKit;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.*;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.PurshaseOrderService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PurshaseOrderServiceImpl implements PurshaseOrderService {
    @Autowired
    private PurshaseOrderRepository purshaseOrderRepository;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;
    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired
    private KitRepository kitRepository;
    @Autowired
    private PurshaseOrderArcRepository purshaseOrderArcRepository;
    @Autowired
    private ReceptionRepository receptionRepository;
    @Autowired
    private SettingRepository settingRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PurshaseOrderService.class);

    @Transactional
    @Override
    public PurshaseOrder save(PurshaseOrder purshaseOrder) {
        LOGGER.info("save PurchaseOrder");
        purshaseOrder.setUpdateDate(EmsDate.getDateNow());
        if (0 >= purshaseOrder.getId()) {
            purshaseOrder.setCreationDate(EmsDate.getDateNow());
        }
        boolean containerManagement = settingRepository.findOne(1L).getPrmSettingValue().equals("1") ? true : false;
        if (!containerManagement) {
            purshaseOrder.getPurshaseOrderLines().stream().forEach(purshaseOrderLine -> {
                if (0 >= purshaseOrderLine.getId() && (null == purshaseOrderLine.getContainerCode() || purshaseOrderLine.getContainerCode().trim().equals(""))) {
                    purshaseOrderLine.setContainerCode(getContainerCode());
                }
            });
        }
        if (0 >= purshaseOrder.getId() && (10000L == purshaseOrder.getOrderType().getId() || 10011 == purshaseOrder.getOrderType().getId())) {
            purshaseOrder.setTransfertCode("trnsfr" + saleOrderRepository.getTransferCode().toString());
            purshaseOrder = PurshaseOrderMapper.toDto(purshaseOrderRepository.saveAndFlush(PurshaseOrderMapper.toEntity(purshaseOrder, false)), false);
            LOGGER.info("save SaleOrder");
            saleOrderRepository.saveAndFlush(SaleOrderMapper.toEntity(addSaleOrderFromPurshaseOrder(purshaseOrder), false));
        } else {
            purshaseOrder = PurshaseOrderMapper.toDto(purshaseOrderRepository.saveAndFlush(PurshaseOrderMapper.toEntity(purshaseOrder, false)), false);
        }
        purshaseOrderRepository.saveAndFlush(PurshaseOrderMapper.toEntity(purshaseOrder, false));
        if(0>1){
        if (1 == purshaseOrder.getOrderStatus().getId() || 3 == purshaseOrder.getOrderStatus().getId() || 7==purshaseOrder.getOrderStatus().getId()) {
            archivePurshaseOrder(purshaseOrder);
        }}
        return purshaseOrder;
    }

    private SaleOrder addSaleOrderFromPurshaseOrder(PurshaseOrder purshaseOrder) {
        SaleOrder saleOrder = new SaleOrder();
        if (null == purshaseOrder)
            return null;
        saleOrder.setWarehouse(purshaseOrder.getWarehouse());
        saleOrder.setWarehouseDestination(purshaseOrder.getWarehouseSource());
        saleOrder.setOwner(purshaseOrder.getOwner());
        saleOrder.setSupplier(purshaseOrder.getSupplier());
        saleOrder.setContainers(purshaseOrder.getContainers());
        saleOrder.setImmatriculation(purshaseOrder.getImmatriculation());
        saleOrder.setAddressBySaleOrderDeliveryAddress(purshaseOrder.getAddress());
        saleOrder.setOrderStatus(purshaseOrder.getOrderStatus());
        saleOrder.setTransport(purshaseOrder.getTransport());
        saleOrder.setCode(purshaseOrder.getCode());
        saleOrder.setTransportTel(purshaseOrder.getTelContact());
        saleOrder.setRemarks(purshaseOrder.getRemarks());
        saleOrder.setDescription(purshaseOrder.getDescription());
        saleOrder.setTransfertCode(purshaseOrder.getTransfertCode());
        if (10000 == purshaseOrder.getOrderType().getId())
            saleOrder.setOrderType(OrderTypeMapper.toDto(orderTypeRepository.findOne(10013L), true));
        else if (10011 == purshaseOrder.getOrderType().getId())
            saleOrder.setOrderType(OrderTypeMapper.toDto(orderTypeRepository.findOne(10014L), true));
        saleOrder.setTransportContact(purshaseOrder.getTransportContact());
        saleOrder.setCreationDate(purshaseOrder.getCreationDate());
        saleOrder.setUpdateDate(purshaseOrder.getUpdateDate());
        if (10011L == purshaseOrder.getOrderType().getId())
            saleOrder = setSaleOrderLinesFromPurshaseOrderLineKit(saleOrder, purshaseOrder);
        else if (10000L == purshaseOrder.getOrderType().getId())
            saleOrder = setSaleOrderLinesFromPurshaseOrderLines(saleOrder, purshaseOrder);
        return saleOrder;
    }

    private SaleOrder setSaleOrderLinesFromPurshaseOrderLines(SaleOrder saleOrder, PurshaseOrder purshaseOrder) {
        Set<SaleOrderLine> saleOrderLines = new HashSet<>();
        if (null != purshaseOrder.getPurshaseOrderLines()) {
            for (PurshaseOrderLine purshaseOrderLine : purshaseOrder.getPurshaseOrderLines()) {
                SaleOrderLine saleOrderLine = new SaleOrderLine();
                saleOrderLine.setWarehouse(purshaseOrderLine.getWarehouse());
                saleOrderLine.setOwner(purshaseOrderLine.getOwner());
                saleOrderLine.setOrderStatus(purshaseOrderLine.getOrderStatus());
                saleOrderLine.setLocation(purshaseOrderLine.getLocation());
                saleOrderLine.setProduct(purshaseOrderLine.getProduct());
                saleOrderLine.setBlockType(purshaseOrderLine.getBlockType());
                saleOrderLine.setComment(purshaseOrderLine.getComment());
                saleOrderLine.setDescription(purshaseOrderLine.getDescription());
                saleOrderLine.setLot(purshaseOrderLine.getLot());
                saleOrderLine.setColor(purshaseOrderLine.getColor());
                saleOrderLine.setQuality(purshaseOrderLine.getQuality());
                saleOrderLine.setQuantity(purshaseOrderLine.getQuantity());
                saleOrderLine.setQuantityServed(purshaseOrderLine.getQuantityReceived());
                saleOrderLine.setSerialNo(purshaseOrderLine.getSerialNo());
                saleOrderLine.setDlc(purshaseOrderLine.getDlc());
                saleOrderLine.setDluo(purshaseOrderLine.getDluo());
                saleOrderLine.setWeight(purshaseOrderLine.getWeight());
                saleOrderLine.setLineNumber(purshaseOrderLine.getNumber());
                saleOrderLine.setUom(purshaseOrderLine.getUom());
                saleOrderLines.add(saleOrderLine);

            }
        }
        saleOrder.setLines(saleOrderLines);
        return saleOrder;
    }

    private SaleOrder setSaleOrderLinesFromPurshaseOrderLineKit(SaleOrder saleOrder, PurshaseOrder purshaseOrder) {
        Set<SaleOrderLine> saleOrderLines = new HashSet<>();
        if (null != purshaseOrder.getPurshaseOrderLines()) {
            for (PurshaseOrderLine purshaseOrderLine : purshaseOrder.getPurshaseOrderLines()) {
                List<Kit> kits = null;

                try {
                    kits = KitMapper.toDtos(kitRepository.findAll(Search.expression("product.id:" + purshaseOrderLine.getProduct().getId(), PdtKit.class)), false);
                } catch (AttributesNotFound attributesNotFound) {
                    //attributesNotFound.printStackTrace();
                } catch (ErrorType errorType) {
                    //e.printStackTrace();
                }
                if (null != kits) {
                    long lineNumber = 1;
                    for (Kit kit : kits) {
                        SaleOrderLine saleOrderLine = new SaleOrderLine();

                        saleOrderLine.setLineNumber(lineNumber * 1000);
                        saleOrderLine.setProduct(kit.getComponent());
                        saleOrderLine.setUom(kit.getUom());
                        saleOrderLine.setOrderStatus(purshaseOrderLine.getOrderStatus());
                        saleOrderLine.setQuantity(kit.getQuantity().multiply(purshaseOrderLine.getQuantity()));
                        saleOrderLine.setOwner(purshaseOrderLine.getOwner());
                        saleOrderLine.setWarehouse(purshaseOrderLine.getWarehouse());
                        saleOrderLine.setLocation(purshaseOrderLine.getLocation());
                        saleOrderLines.add(saleOrderLine);
                        lineNumber++;
                    }

                }
            }
            saleOrder.setLines(saleOrderLines);
        }
        return saleOrder;
    }


    @Override
    public Long size() {
        return purshaseOrderRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return purshaseOrderRepository.exists(id);
    }

    @Override
    public PurshaseOrder findById(Long id) throws IdNotFound {
        PurshaseOrder purshaseOrder = PurshaseOrderMapper.toDto(purshaseOrderRepository.findOne(id), false);
        if (null != purshaseOrder) {
            return purshaseOrder;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PurshaseOrder> find(String search) throws AttributesNotFound, ErrorType {
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(Search.expression(search, RcpPurshaseOrder.class)), false);
    }

    @Override
    public List<PurshaseOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "rcpPurshaseOrderUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        //search=search.replace("warehouse.code","warehouseDestination.code");
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(Search.expression(search, RcpPurshaseOrder.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return purshaseOrderRepository.count(Search.expression(search, RcpPurshaseOrder.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PurchaseOrder");
        purshaseOrderRepository.delete(id);
    }

    @Override
    public void delete(PurshaseOrder purshaseOrder) {
        LOGGER.info("delete PurchaseOrder");
        purshaseOrderRepository.delete(PurshaseOrderMapper.toEntity(purshaseOrder, false));
    }

    @Override
    public List<PurshaseOrder> findAll() {
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(), false);
    }

    @Override
    public List<PurshaseOrder> findAll(Pageable pageable) {
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(pageable), false);
    }

    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = purshaseOrderRepository.getNextVal();
        BigInteger tab = objects.get(0);
        return tab;
    }

    private void archivePurshaseOrder(PurshaseOrder purshaseOrder) {
        PurshaseOrderArc purshaseOrderArc = new PurshaseOrderArc();
        purshaseOrderArc.setTransportContact(purshaseOrder.getTransportContact());
        purshaseOrderArc.setTransport(purshaseOrder.getTransport());
        purshaseOrderArc.setImmatriculation(purshaseOrder.getImmatriculation());
        purshaseOrderArc.setOrderStatus(purshaseOrder.getOrderStatus());
        purshaseOrderArc.setWarehouse(purshaseOrder.getWarehouse());
        purshaseOrderArc.setCode(purshaseOrder.getCode());
        purshaseOrderArc.setAccountOrderCode(purshaseOrder.getAccountOrderCode());
        purshaseOrderArc.setDescription(purshaseOrder.getDescription());
        purshaseOrderArc.setAddress(purshaseOrder.getAddress());
        purshaseOrderArc.setContainers(purshaseOrder.getContainers());
        purshaseOrderArc.setCreationDate(EmsDate.getDateNow());
        purshaseOrderArc.setUpdateDate(EmsDate.getDateNow());
        purshaseOrderArc.setExpectedDate(purshaseOrder.getExpectedDate());
        purshaseOrderArc.setOwner(purshaseOrder.getOwner());
        purshaseOrderArc.setReceptionDate(purshaseOrder.getReceptionDate());
        purshaseOrderArc.setWarehouseSource(purshaseOrder.getWarehouseSource());
        purshaseOrderArc.setRemarks(purshaseOrder.getRemarks());
        purshaseOrderArc.setOrderType(purshaseOrder.getOrderType());
        purshaseOrderArc.setSupplier(purshaseOrder.getSupplier());
        purshaseOrderArc.setSupplierOrderCode(purshaseOrder.getSupplierOrderCode());
        purshaseOrderArc.setVariable1(purshaseOrder.getVariable1());
        purshaseOrderArc.setVariable2(purshaseOrder.getVariable2());
        purshaseOrderArc.setVariable3(purshaseOrder.getVariable3());
        purshaseOrderArc.setVariable4(purshaseOrder.getVariable4());
        purshaseOrderArc.setVariable5(purshaseOrder.getVariable5());
        purshaseOrderArc.setVariable6(purshaseOrder.getVariable6());
        purshaseOrderArc.setVariable7(purshaseOrder.getVariable7());
        purshaseOrderArc.setVariable8(purshaseOrder.getVariable8());
        purshaseOrderArc.setVariable9(purshaseOrder.getVariable9());
        purshaseOrderArc.setVariable10(purshaseOrder.getVariable10());
        archiveLines(purshaseOrder, purshaseOrderArc);
        purshaseOrderArcRepository.saveAndFlush(PurshaseOrderArcMapper.toEntity(purshaseOrderArc, false));
    }

    private void archiveLines(PurshaseOrder purshaseOrder, PurshaseOrderArc purshaseOrderArc) {
        Set<PurshaseOrderLineArc> purshaseOrderLineArcs = new HashSet<>();
        purshaseOrder.getPurshaseOrderLines().stream().forEach(receptionLine -> {
            PurshaseOrderLineArc purshaseOrderLineArc = new PurshaseOrderLineArc();
            purshaseOrderLineArc.setProduct(receptionLine.getProduct());
            purshaseOrderLineArc.setUomReceived(receptionLine.getUomReceived());
            purshaseOrderLineArc.setUom(receptionLine.getUom());
            purshaseOrderLineArc.setNumber(receptionLine.getNumber());
            purshaseOrderLineArc.setWarehouse(receptionLine.getWarehouse());
            purshaseOrderLineArc.setOrderStatus(receptionLine.getOrderStatus());
            purshaseOrderLineArc.setOwner(receptionLine.getOwner());
            purshaseOrderLineArc.setReceptionDate(receptionLine.getReceptionDate());
            purshaseOrderLineArc.setDescription(receptionLine.getDescription());
            purshaseOrderLineArc.setBlockType(receptionLine.getBlockType());
            purshaseOrderLineArc.setBlockedQuantity(receptionLine.getBlockedQuantity());
            purshaseOrderLineArc.setQuantityReceived(receptionLine.getQuantityReceived());
            purshaseOrderLineArc.setQuantity(receptionLine.getQuantity());
            purshaseOrderLineArc.setComment(receptionLine.getComment());
            purshaseOrderLineArc.setLocation(receptionLine.getLocation());
            purshaseOrderLineArc.setColor(receptionLine.getColor());
            purshaseOrderLineArc.setDlc(receptionLine.getDlc());
            purshaseOrderLineArc.setDluo(receptionLine.getDluo());
            purshaseOrderLineArc.setWeight(receptionLine.getWeight());
            purshaseOrderLineArc.setQuality(receptionLine.getQuality());
            purshaseOrderLineArc.setVariable1(receptionLine.getVariable1());
            purshaseOrderLineArc.setVariable2(receptionLine.getVariable2());
            purshaseOrderLineArc.setVariable3(receptionLine.getVariable3());
            purshaseOrderLineArc.setVariable4(receptionLine.getVariable4());
            purshaseOrderLineArc.setVariable5(receptionLine.getVariable5());
            purshaseOrderLineArc.setVariable6(receptionLine.getVariable6());
            purshaseOrderLineArc.setVariable7(receptionLine.getVariable7());
            purshaseOrderLineArc.setVariable8(receptionLine.getVariable8());
            purshaseOrderLineArc.setVariable9(receptionLine.getVariable9());
            purshaseOrderLineArc.setVariable10(receptionLine.getVariable10());
            purshaseOrderLineArc.setContainerCode(receptionLine.getContainerCode());
            purshaseOrderLineArc.setQuantityClosed(receptionLine.getQuantityClosed());
            purshaseOrderLineArc.setSerialNo(receptionLine.getSerialNo());
            purshaseOrderLineArc.setLot(receptionLine.getLot());
            purshaseOrderLineArc.setSuppOfLife(receptionLine.getSuppOfLife());
            purshaseOrderLineArcs.add(purshaseOrderLineArc);

        });
        purshaseOrderArc.setPurshaseOrderLines(purshaseOrderLineArcs);
    }

    @Override
    public String getTransfertCode() {
        return "trsf" + purshaseOrderRepository.getTransferCode().get(0);
    }


    private String getContainerCode() {
        return String.format("%1$018d", containerRepository.getNextVal().get(0));
    }
}