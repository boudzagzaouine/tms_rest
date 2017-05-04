package com.sinno.ems.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.entities.*;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.WarehouseException;
import com.sinno.ems.mapper.*;
import com.sinno.ems.mapperWms.MapperReception;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.ReceptionService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerReception;
import com.sinno.wms.crud.convertbasic.ConvertManagerReceptionLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.File;
import java.lang.Exception;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReceptionServiceImpl implements ReceptionService {

    @Autowired
    private ReceptionRepository receptionRepository;
    @Autowired
    private PurshaseOrderRepository purshaseOrderRepository;
    @Autowired
    private PurshaseOrderLineRepository purshaseOrderLineRepository;
    @Autowired
    private MsgSendRepository msgSendRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private ReceptionArcRepository receptionArcRepository;
    @Autowired
    private PurshaseOrderArcRepository purshaseOrderArcRepository;
    @Autowired
    private PurshaseOrderLineArcRepository purshaseOrderLineArcRepository;
    @Autowired
    private ReceptionStockRepository receptionStockRepository;
    @Autowired
    private ReceptionLineArcRepository receptionLineArcRepository;
    @Autowired
    private ReceptionStockArcRepository receptionStockArcRepository;
    @Autowired
    private SettingRepository settingRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;
    @Autowired
    private LocationRepository locationRepository;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ReceptionService.class);


    @Override
    @Transactional
    public Reception save(Reception reception) throws WarehouseException {
        LOGGER.info("save Reception");
        reception.setUpdateDate(EmsDate.getDateNow());
        if (0 >= reception.getId()) {
            reception.setCreationDate(EmsDate.getDateNow());
            if (null != reception.getPurshaseOrder()) {
                RcpPurshaseOrder order = purshaseOrderRepository.findOne(reception.getPurshaseOrder().getId());
                order.setPrmOrderStatus(orderStatusRepository.findOne(5L));
                for (RcpPurshaseOrderLine orderLine : order.getRcpPurshaseOrderLines())
                    orderLine.setPrmOrderStatus(orderStatusRepository.findOne(5L));
                LOGGER.info("save PurchaseOrder");
                purshaseOrderRepository.saveAndFlush(order);
            }
        }
        boolean containerManagement = settingRepository.findOne(1L).getPrmSettingValue().equals("1") ? true : false;
        if (!containerManagement) {
            reception.getReceptionLines().stream().forEach(receptionLine -> {
                if (0 >= receptionLine.getId() && (null == receptionLine.getContainerCode() || receptionLine.getContainerCode().trim().equals(""))) {
                    PurshaseOrderLine purshaseOrderLine = receptionLine.getPurshaseOrderLine();
                    String code = purshaseOrderLine.getContainerCode();
                    if (null == code || code.trim().equals("")) {
                        code = getContainerCode();
                        purshaseOrderLine.setContainerCode(code);
                        LOGGER.info("save PurchaseOrderLine");
                        purshaseOrderLineRepository.saveAndFlush(PurshaseOrderLineMapper.toEntity(purshaseOrderLine, false));
                    }
                    receptionLine.setContainerCode(code);
                }
            });
        }

        if (1 == reception.getOrderStatus().getId() || 3 == reception.getOrderStatus().getId()) {
            reception = ReceptionMapper.toDto(receptionRepository.saveAndFlush(ReceptionMapper.toEntity(reception, false)), false);

            if (0 > 1) {
                if (2 == reception.getPurshaseOrder().getOrderStatus().getId()) {
                    throw new WarehouseException("La commande d'achat liée à cette réception n'est pas encore fermée");
                } else {
                    try {
                        //reception = ReceptionMapper.toDto(receptionRepository.saveAndFlush(ReceptionMapper.toEntity(reception, false)), false);
                        archiveReception(reception);

                    } catch (AttributesNotFound attributesNotFound) {
                        attributesNotFound.printStackTrace();
                    } catch (ErrorType errorType) {
                        errorType.printStackTrace();
                    }
                }
            }
        } else {
            reception = ReceptionMapper.toDto(receptionRepository.saveAndFlush(ReceptionMapper.toEntity(reception, false)), false);
        }
        boolean syncWms = settingRepository.findOne(2L).getPrmSettingValue().equals("1") ? true : false;
        if (syncWms) {
            PrmMsgSend msgSend = getPrmMsgSend();
            if (null != msgSend && msgSend.isPrmMsgSendActive()) {
//            ReceptionOrderExport.export(servletContext.getRealPath("/WEB-INF/classes"), ReceptionMapper.toEntity(reception, false), "F", servletContext);
            }

     /*       com.sinno.wms.crud.modelbasic.receptions.Reception recp = new com.sinno.wms.crud.modelbasic.receptions.Reception();
            if (null != ConvertManagerReception.readFileReception("receptions.xls") && ConvertManagerReception.readFileReception("receptions.xls").size() > 0) {
                recp = ConvertManagerReception.readFileReception("receptions.xls").get(0);
                reception = MapperReception.convertToEmsDto(recp);
                receptionRepository.saveAndFlush(ReceptionMapper.toEntity(reception, false));
            }   */

            if (1 != reception.getOrderStatus().getId() && 3 != reception.getOrderStatus().getId() && null != msgSend && msgSend.isPrmMsgSendActive() && "xls".equals(msgSend.getPrmMsgSendFormat().trim())) {

                String code = reception.getCode();
                if (0 < reception.getId()) {
                    int indexOf = code.lastIndexOf("-");
                    if (-1 == indexOf)
                        code = code + "-1";
                    else {
                        boolean checkCode = true;
                        while (checkCode) {
                            int number = Integer.parseInt(code.substring(indexOf + 1, code.length())) + 1;
                            code = code.substring(0, indexOf) + "-" + number;
                            try {
                                RcpReception receptions = receptionRepository.findOne(Search.expression("code:" + code, RcpReception.class));
                                if (null == receptions)
                                    checkCode = false;
                            } catch (AttributesNotFound attributesNotFound) {
                                attributesNotFound.printStackTrace();
                            } catch (ErrorType errorType) {
                                errorType.printStackTrace();
                            }
                        }
                    }
                }
                reception.setCode(code);
                for (ReceptionLine rcpLine : reception.getReceptionLines()) {
                    rcpLine.setReception(reception);
                }
                writeFileReception(msgSend.getPrmMsgSendPath(), reception);
                writeFileReception(msgSend.getPrmMsgSendArcPath(), reception);
                reception.setSendedToWms(true);
                reception = ReceptionMapper.toDto(receptionRepository.saveAndFlush(ReceptionMapper.toEntity(reception, false)), false);
            }
        }
        return reception;

        /*if (0 >= reception.getId()) {
            reception.setUsrUserBoxCreationDate(EmsDate.getDateNow());
        }
        if(null==reception.getAddress()||null==reception.getAddress().getCode()||reception.getAddress().getCode().equals(""))
            reception.setAddress(reception.getWarehouse().getAddress());
        return ReceptionMapper.toDto(receptionRepository.saveAndFlush(ReceptionMapper.toEntity(reception, false)), false);*/
    }

    private PrmMsgSend getPrmMsgSend() {
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:PRE", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator() && msgSends.iterator().hasNext()) {
                return msgSends.iterator().next();
            }
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return null;
    }

    private void writeFileReception(String path, Reception rec) {

        try {
            //   String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            com.sinno.wms.crud.modelbasic.receptions.Reception reception = com.sinno.ems.mapperWms.MapperReception.convertToWmsDto(rec);
            String filename = path + File.separator + "IRE01" + dateFormat.format(new Date()) + ".xls";
            ConvertManagerReception.writeFileReception(filename, langue, reception);
            List<com.sinno.wms.crud.modelbasic.receptions.ReceptionLine> WMSReceptionLines = new ArrayList<>();
            for (ReceptionLine line : rec.getReceptionLines()) {
                WMSReceptionLines.add(com.sinno.ems.mapperWms.MapperReceptionLine.convertToWmsDto(line));
            }
            ConvertManagerReceptionLine.writeFileReceptionLine(filename, langue, WMSReceptionLines);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeFileReception(String path, List<Reception> receptions) {

        try {
            //   String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";

            List<com.sinno.wms.crud.modelbasic.receptions.Reception> receptionList = new ArrayList<>();
            for (Reception rec : receptions) {
                receptionList.add(com.sinno.ems.mapperWms.MapperReception.convertToWmsDto(rec));
            }
            String filename = path + File.separator + "IRE01" + dateFormat.format(new Date()) + ".xls";

            ConvertManagerReception.writeFileReception(filename, langue, receptionList);
            List<com.sinno.wms.crud.modelbasic.receptions.ReceptionLine> WMSReceptionLines = new ArrayList<>();
            for (Reception rec : receptions) {
                for (ReceptionLine line : rec.getReceptionLines()) {
                    WMSReceptionLines.add(com.sinno.ems.mapperWms.MapperReceptionLine.convertToWmsDto(line));
                }
            }
            ConvertManagerReceptionLine.writeFileReceptionLine(filename, langue, WMSReceptionLines);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void readFileProductType(com.sinno.wms.crud.modelbasic.receptions.Reception rec) {

        try {
            rec = ConvertManagerReception.readFileReception("IRE01.xls").get(0);
            Reception reception = new Reception();
            reception = MapperReception.convertToEmsDto(reception, rec);
            receptionRepository.saveAndFlush(ReceptionMapper.toEntity(reception, false));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Long size() {
        return receptionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionRepository.exists(id);
    }

    @Override
    public Reception findById(Long id) throws IdNotFound {
        Reception reception = ReceptionMapper.toDto(receptionRepository.findOne(id), false);
        if (null != reception) {
            return reception;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Reception> find(String search) throws AttributesNotFound, ErrorType {
        return ReceptionMapper.toDtos(receptionRepository.findAll(Search.expression(search, RcpReception.class)), false);
    }

    @Override
    public List<Reception> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "rcpReceptionUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return ReceptionMapper.toDtos(receptionRepository.findAll(Search.expression(search, RcpReception.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return receptionRepository.count(Search.expression(search, RcpReception.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Reception");
        receptionRepository.delete(id);
    }

    @Override
    public void delete(Reception reception) {
        LOGGER.info("delete Reception");
        receptionRepository.delete(ReceptionMapper.toEntity(reception, false));
    }

    @Override
    public List<Reception> findAll() {
        return ReceptionMapper.toDtos(receptionRepository.findAll(), false);
    }

    @Override
    public List<Reception> findAll(Pageable pageable) {
        return ReceptionMapper.toDtos(receptionRepository.findAll(pageable), false);
    }

    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = receptionRepository.getNextVal();
        BigInteger tab = objects.get(0);
        return tab;
    }

    private String getContainerCode() {
        return String.format("%1$018d", containerRepository.getNextVal().get(0));
    }

    private void archiveReception(Reception reception) throws AttributesNotFound, ErrorType {
        ReceptionArc receptionArc = new ReceptionArc();
        receptionArc.setCode(reception.getCode());
        receptionArc.setAccount(reception.getAccount());
        receptionArc.setWarehouse(reception.getWarehouse());
        receptionArc.setOrderCode(reception.getOrderCode());
        receptionArc.setAddress(reception.getAddress());
        receptionArc.setDescription(reception.getDescription());
        receptionArc.setCreationDate(reception.getCreationDate());
        receptionArc.setExpectedDate(reception.getExpectedDate());
        receptionArc.setLocation(reception.getLocation());
        receptionArc.setImmatriculation(reception.getImmatriculation());
        receptionArc.setNumberOfContainers(reception.getNumberOfContainers());
        receptionArc.setOrderStatus(reception.getOrderStatus());
        receptionArc.setOrderType(reception.getOrderType());
        receptionArc.setOwner(reception.getOwner());
        receptionArc.setPurshaseOrder(PurshaseOrderArcMapper.toDto(purshaseOrderArcRepository.findOne(Search.expression("code:" + reception.getPurshaseOrder().getCode(), RcpPurshaseOrderArc.class)), false));
        receptionArc.setReceptionDate(reception.getReceptionDate());
        receptionArc.setLocation(reception.getLocation());
        receptionArc.setSupplier(reception.getSupplier());
        receptionArc.setRemarks(reception.getRemarks());
        receptionArc.setTransfertCode(reception.getTransfertCode());
        receptionArc.setTransport(reception.getTransport());
        receptionArc.setTransportContact(reception.getTransportContact());
        receptionArc.setTransportTel(reception.getTransportTel());
        receptionArc.setUpdateDate(reception.getUpdateDate());
        receptionArc.setVariable1(reception.getVariable1());
        receptionArc.setVariable2(reception.getVariable2());
        receptionArc.setVariable3(reception.getVariable3());
        receptionArc.setVariable4(reception.getVariable4());
        receptionArc.setVariable5(reception.getVariable5());
        receptionArc.setVariable6(reception.getVariable6());
        receptionArc.setVariable7(reception.getVariable7());
        receptionArc.setVariable8(reception.getVariable8());
        receptionArc.setVariable9(reception.getVariable9());
        receptionArc.setVariable10(reception.getVariable10());
        archiveReceptionLine(receptionArc, reception);
        receptionArcRepository.saveAndFlush(ReceptionArcMapper.toEntity(receptionArc, false));
        archiveReceptionStock(reception);
        receptionRepository.delete(reception.getId());
        purshaseOrderRepository.delete(PurshaseOrderMapper.toDto(purshaseOrderRepository.findOne(Search.expression("code:" + reception.getPurshaseOrder().getCode(), RcpPurshaseOrder.class)), false).getId());
    }

    private void archiveReceptionLine(ReceptionArc receptionArc, Reception reception) {
        Set<ReceptionLineArc> lineArcSet = new HashSet<>();
        reception.getReceptionLines().forEach(receptionLine -> {
            ReceptionLineArc receptionLineArc = new ReceptionLineArc();
            receptionLineArc.setComment(receptionLine.getComment());
            receptionLineArc.setProduct(receptionLine.getProduct());
            receptionLineArc.setOrderStatus(receptionLine.getOrderStatus());
            receptionLineArc.setLocation(receptionLine.getLocation());
            receptionLineArc.setDescription(receptionLineArc.getDescription());
            receptionLineArc.setWarehouse(receptionLine.getWarehouse());
            receptionLineArc.setQuality(receptionLine.getQuality());
            receptionLineArc.setContainerCode(receptionLine.getContainerCode());
            receptionLineArc.setQuantityReceived(receptionLine.getQuantityReceived());
            receptionLineArc.setBlockedQuantity(receptionLine.getBlockedQuantity());
            receptionLineArc.setQuantity(receptionLine.getQuantity());
            receptionLineArc.setLot(receptionLine.getLot());
            receptionLineArc.setCreationDate(receptionLine.getCreationDate());
            receptionLineArc.setReceptionDate(receptionLine.getReceptionDate());
            receptionLineArc.setUom(receptionLine.getUom());
            receptionLineArc.setUomReceived(receptionLine.getUomReceived());
            receptionLineArc.setLineNumber(receptionLine.getLineNumber());
            receptionLineArc.setSerialNo(receptionLine.getSerialNo());
            receptionLineArc.setSuppOfLife(receptionLine.getSuppOfLife());
            receptionLineArc.setWeight(receptionLine.getWeight());
            receptionLineArc.setBlockType(receptionLine.getBlockType());
            receptionLineArc.setUpdateDate(receptionLine.getUpdateDate());
            receptionLineArc.setDlc(receptionLine.getDlc());
            receptionLineArc.setDluo(receptionLine.getDluo());
            receptionLineArc.setColor(receptionLine.getColor());
            receptionLineArc.setOwner(receptionLine.getOwner());
            receptionLineArc.setBlockedQuantity(receptionLine.getBlockedQuantity());
            try {
                receptionLineArc.setPurshaseOrderLine(PurshaseOrderLineArcMapper.toDto(purshaseOrderLineArcRepository.findOne(Search.expression("number:" + receptionLine.getPurshaseOrderLine().getNumber() + ",purshaseOrder.code:" + reception.getPurshaseOrder().getCode(), RcpPurshaseOrderLineArc.class)), false));
            } catch (AttributesNotFound attributesNotFound) {
                attributesNotFound.printStackTrace();
            } catch (ErrorType errorType) {
                errorType.printStackTrace();
            }
            receptionLineArc.setVariable1(receptionLine.getVariable1());
            receptionLineArc.setVariable2(receptionLine.getVariable2());
            receptionLineArc.setVariable3(receptionLine.getVariable3());
            receptionLineArc.setVariable4(receptionLine.getVariable4());
            receptionLineArc.setVariable5(receptionLine.getVariable5());
            receptionLineArc.setVariable6(receptionLine.getVariable6());
            receptionLineArc.setVariable7(receptionLine.getVariable7());
            receptionLineArc.setVariable8(receptionLine.getVariable8());
            receptionLineArc.setVariable9(receptionLine.getVariable9());
            receptionLineArc.setVariable10(receptionLine.getVariable10());
            lineArcSet.add(receptionLineArc);
        });

        receptionArc.setReceptionLines(lineArcSet);
    }

    private void archiveReceptionStock(Reception reception) throws AttributesNotFound, ErrorType {
        ReceptionStockMapper.toDtos(receptionStockRepository.findAll(Search.expression("reception.code:" + reception.getCode(), RcpReceptionStock.class)), false)
                .forEach(rs -> {
                    try {
                        ReceptionStockArc rsa = new ReceptionStockArc();
                        rsa.setOwner(rs.getOwner());
                        rsa.setUpdateDate(rs.getUpdateDate());
                        rsa.setCreationDate(rs.getCreationDate());
                        rsa.setReceptionDate(rs.getReceptionDate());
                        rsa.setWarehouse(rs.getWarehouse());
                        rsa.setProduct(rs.getProduct());
                        rsa.setBlockType(rs.getBlockType());
                        rsa.setSupplier(rs.getSupplier());
                        rsa.setColor(rs.getColor());
                        rsa.setDlc(rs.getDlc());
                        rsa.setDluo(rs.getDluo());
                        rsa.setSerialNo(rs.getSerialNo());
                        rsa.setLot(rs.getLot());
                        rsa.setReception(ReceptionArcMapper.toDto(receptionArcRepository.findOne(Search.expression(String.format("code:%s", reception.getCode()), RcpReceptionArc.class)), false));
                        rsa.setReceptionLine(ReceptionLineArcMapper.toDto(receptionLineArcRepository.findOne(Search.expression(String.format("lineNumber:%s", rs.getReceptionLine().getLineNumber()), RcpReceptionLineArc.class)), false));
                        rsa.setQuantityReceived(rs.getQuantityReceived());
                        rsa.setUom(rs.getUom());
                        rsa.setLocation(rs.getLocation());
                        rsa.setUomReceived(rs.getUomReceived());
                        rsa.setQuality(rs.getQuality());
                        rsa.setWeight(rs.getWeight());
                        rsa.setOrderStatus(rs.getOrderStatus());

                        receptionStockArcRepository.saveAndFlush(ReceptionStockArcMapper.toEntity(rsa, false));
                        receptionStockRepository.delete(rs.getId());

                    } catch (AttributesNotFound attributesNotFound) {
                        attributesNotFound.printStackTrace();
                    } catch (ErrorType errorType) {
                        errorType.printStackTrace();
                    }
                });
    }

    @Override
    @Transactional
    public Reception loadWmsReception(com.sinno.wms.crud.modelbasic.receptions.Reception reception) {
        Reception emsReception = ReceptionMapper.toDto(receptionRepository.findByRcpReceptionCode(reception.getReceptionCode()), false);
        Owner owner = OwnerMapper.toDto(ownerRepository.findByOwnOwnerCode(reception.getOwner_code()), false);
        Warehouse warehouse = WarehouseMapper.toDto(warehouseRepository.findByWrhWarehouseCode(reception.getWarehouse()), false);//TODO WAREHOUSE MUST CHANGE THIS VALUE IS ONLY FOR TEST
        Transport transport = TransportMapper.toDto(transportRepository.findByTrpTransportCode(reception.getCarrier_code()), false);
        Supplier supplier = SupplierMapper.toDto(supplierRepository.findByRcpSupplierCode(reception.getSupplier_code()), false);
        Location location = LocationMapper.toDto(locationRepository.findByLocLocationCode(reception.getDock_code()), false);
        if (null == emsReception) {

            emsReception = new Reception();
            emsReception.setCreationDate(EmsDate.getDateNow());

        }
        if (null == location) {
            try {
                location = LocationMapper.toDto(locationRepository.findOne(Search.expression("locationStatus.id:2,defaultLocation:true", LocLocation.class)), false);
            } catch (AttributesNotFound attributesNotFound) {
                attributesNotFound.printStackTrace();
            } catch (ErrorType errorType) {
                errorType.printStackTrace();
            }
        }

        if (null != emsReception) {
            emsReception.setUpdateDate(EmsDate.getDateNow());
            emsReception = MapperReception.convertToEmsDto(emsReception, reception);
            emsReception.setAddress(warehouse.getAddress());
            if ("STANDARD".equals(reception.getReception_type_code().trim()))
                emsReception.setOrderType(OrderTypeMapper.toDto(orderTypeRepository.findOne(1L), false));
            if ("RETURN".equals(reception.getReception_type_code().trim()))
                emsReception.setOrderType(OrderTypeMapper.toDto(orderTypeRepository.findOne(10010L), false));

            emsReception.setTransport(transport);
            emsReception.setSupplier(supplier);
            emsReception.setLocation(location);
            emsReception.setWarehouse(warehouse);
            emsReception.setOwner(owner);
            emsReception = ReceptionMapper.toDto(receptionRepository.saveAndFlush(ReceptionMapper.toEntity(emsReception, false)), false);
            return emsReception;
        }
        return null;
    }

    @Override
    public List<Reception> exportWmsReception(List<Reception> receptions) {
        writeFileReception(null != getPrmMsgSend() ? getPrmMsgSend().getPrmMsgSendPath() : System.getenv("APPDATA"), receptions);
        return receptions;
    }


}