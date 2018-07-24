package com.bagile.tms.services.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.entities.CmdDeliveryLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.mapper.ContainerMapper;
import com.sinno.ems.mapper.DeliveryLineMapper;
import com.sinno.ems.mapper.PurshaseOrderMapper;
import com.sinno.ems.repositories.DeliveryLineRepository;
import com.sinno.ems.repositories.SettingRepository;
import com.sinno.ems.service.DeliveryLineService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Enissay on 21/04/2016.
 */
@Service

public class DeliveyLineServiceImpl implements DeliveryLineService {
    @Autowired
    private DeliveryLineRepository deliveryLineRepository;
    @Autowired
    private SettingRepository settingRepository;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private PurshaseOrderRepository purshaseOrderRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DeliveryLineService.class);

    @Override
    public DeliveryLine save(DeliveryLine deliveryLine) throws ProductControls {
        LOGGER.info("save DeliveryLine");
        deliveryLine.setUpdateDate(EmsDate.getDateNow());
        boolean containerManagement = settingRepository.findOne(1L).getPrmSettingValue().equals("1") ? true : false;

        if (!containerManagement) {
            if (null != deliveryLine.getContainerCode() || !"".equals(deliveryLine.getContainerCode().trim()))
                deliveryLine.setContainerCode(getContainerCode());
        }
        if (0 >= deliveryLine.getId()) {
            deliveryLine.setCreationDate(EmsDate.getDateNow());
        }
        return DeliveryLineMapper.toDto(deliveryLineRepository.saveAndFlush(DeliveryLineMapper.toEntity(deliveryLine, false)), false);
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
        try {
            reception.setPurshaseOrder(PurshaseOrderMapper.toDto(purshaseOrderRepository.findOne(Search.expression("code:" + delivery.getSaleOrder().getCode(), PurshaseOrder.class)), false));
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        reception.setCreationDate(EmsDate.getDateNow());
        reception.setUpdateDate(EmsDate.getDateNow());
        reception.setReceptionDate(delivery.getExpectedDate());
        //TODO
        //delivery.setLoadDate(reception.setReceptionDate());
        return reception;
    }

    private Reception setReceptionLinesFromDeliveryLines(Reception reception, Delivery delivery) {
        Set<ReceptionLine> receptionLines = new HashSet<>();
        if (null != reception.getReceptionLines()) {
            ReceptionLine receptionLine = new ReceptionLine();
            delivery.getLines().stream().forEach(line -> {
                receptionLine.setLocation(line.getLocation());
                receptionLine.setWarehouse(line.getWarehouse());
                receptionLine.setOwner(line.getOwner());
                receptionLine.setOrderStatus(line.getOrderStatus());
                receptionLine.setReception(reception);
                receptionLine.setOrderStatus(line.getOrderStatus());
                receptionLine.setSerialNo(line.getSerialNo());
                receptionLine.setLot(line.getLot());
                receptionLine.setColor(line.getColor());
                receptionLine.setDlc(line.getDlc());
                receptionLine.setDluo(line.getDluo());
                receptionLine.setWeight(line.getWeight());
                receptionLine.setQuality(line.getQuality());
                receptionLine.setQuantityReceived(line.getQuantityServed());
                receptionLines.add(receptionLine);
            });
            reception.setReceptionLines(receptionLines);
        }
        return reception;
    }


    @Override
    public Long size() {
        return deliveryLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return deliveryLineRepository.exists(id);
    }

    @Override
    public DeliveryLine findById(Long id) throws IdNotFound {
        DeliveryLine deliveryLine = DeliveryLineMapper.toDto(deliveryLineRepository.findOne(id), false);
        if (null != deliveryLine) {
            return deliveryLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<DeliveryLine> find(String search) throws AttributesNotFound, ErrorType {
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(Search.expression(search, CmdDeliveryLine.class)), false);
    }

    @Override
    public List<DeliveryLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "cmdDeliveryLineUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(Search.expression(search, CmdDeliveryLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return deliveryLineRepository.count(Search.expression(search, CmdDeliveryLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete DeliveryLine");
        deliveryLineRepository.delete(id);
    }

    @Override
    public void delete(DeliveryLine deliveryLine) {
        LOGGER.info("delete DeliveryLine");
        deliveryLineRepository.delete(DeliveryLineMapper.toEntity(deliveryLine, false));
    }

    @Override
    public List<DeliveryLine> findAll() {
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(), false);
    }

    @Override
    public List<DeliveryLine> findAll(Pageable pageable) {
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(pageable), false);
    }

    private String getContainerCode() {
        return String.format("%1$018d", containerRepository.getNextVal().get(0));
    }

    private Container createContainer(DeliveryLine deliveryLine) {
        Container container = new Container();
        container.setCode(getContainerCode());
        container.setLocation(deliveryLine.getLocation());
        container.setOwner(deliveryLine.getOwner());
        container.setWarehouse(deliveryLine.getWarehouse());
        container.setCreationDate(EmsDate.getDateNow());
        container.setUpdateDate(EmsDate.getDateNow());
        container.setReceptionDate(EmsDate.getDateNow());
        return ContainerMapper.toDto(containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false)), false);
    }
}
