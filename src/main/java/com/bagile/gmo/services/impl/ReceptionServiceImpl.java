package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.RcpReception;
import com.bagile.gmo.exceptions.*;
import com.bagile.gmo.mapper.ReceptionMapper;
import com.bagile.gmo.repositories.ReceptionRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.GmaoSearch;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;


@Service
@Transactional
public class ReceptionServiceImpl implements ReceptionService, GmaoSearch {
    @Autowired

    private  ReceptionRepository receptionRepository;
    @Autowired
    private ReceptionStockService receptionStockService;
    @Autowired
    private PurshaseOrderService purshaseOrderService;
    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
     private ReceptionLineService receptionLineService;

    @Autowired
    private SettingService settingService;

    @Autowired
    private NotificationService notificationService;


    public ReceptionServiceImpl() {}


    @Override
    public Reception save(Reception reception) throws ContainerException, ProductControls, AttributesNotFound, ErrorType, IdNotFound, CustomException {
       // LOGGER.info("save Reception");
  reception.setGmao(true);

        reception.setUpdateDate(EmsDate.getDateNow());
        String operation = "F";
        if (0 >= reception.getId()) {
            reception.setCreationDate(EmsDate.getDateNow());
            changeStatusToOnProgress(reception);
            operation = "A";
            reception.setActive(true);
            calculateAllLines(reception);
            if (reception.getAccounted() == null) {
                reception.setAccounted(true);
            }
        } else {
            for (ReceptionLine receptionLine : reception.getReceptionLines()) {

                if (receptionLine.getQuantityReceived() != null && receptionLine.getQuantity().compareTo(receptionLine.getQuantityReceived()) < 0) {
                    receptionStockService.updateReceptionStock(receptionLine);
                }

            }

        }

        return ReceptionMapper.toDto(receptionRepository.saveAndFlush(ReceptionMapper.toEntity(reception, false)), false);
    }
    @Override
    public void calculateAllLines(Reception selectedReception) {
        BigDecimal priceTTC = BigDecimal.ZERO;
        BigDecimal priceHt = BigDecimal.ZERO;

        for (ReceptionLine receptionLine : selectedReception.getReceptionLines()) {
            if (null != receptionLine.getTotalPriceHT() && null != receptionLine.getTotalPriceTTC()) {
                priceHt = priceHt.add(receptionLine.getTotalPriceHT());
                priceTTC = priceTTC.add(receptionLine.getTotalPriceTTC());
            }
        }

        selectedReception.setTotalPriceHT(priceHt);
        selectedReception.setTotalPriceTTC(priceTTC);
        selectedReception.setVat(priceTTC.subtract(priceHt));
    }
    @Override
    public void changeStatusToOnProgress(Reception reception) throws IdNotFound {

        if (null != reception.getPurshaseOrder()) {
            PurshaseOrder order = purshaseOrderService.findById(reception.getPurshaseOrder().getId());
            OrderStatus orderStatus = orderStatusService.onProgressStatus();
            order.setOrderStatus(orderStatus);
            for (PurshaseOrderLine orderLine : order.getPurshaseOrderLines())
                orderLine.setOrderStatus(orderStatus);
           // LOGGER.info("calling save PurchaseOrder from receptionService");
            purshaseOrderService.save(order);
        }
    }
    @Override
    public Long size() throws AttributesNotFound, ErrorType {
        return receptionRepository.count(Search.expression(addGmaoToSearch(""), RcpReception.class));
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionRepository.existsById(id);
    }

    @Override
    public Reception findById(Long id) throws IdNotFound {
        return ReceptionMapper.toDto(receptionRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Reception> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ReceptionMapper.toDtos(receptionRepository.findAll(Search.expression(addGmaoToSearch(search), RcpReception.class)), false);
    }

    @Override
    public List<Reception> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ReceptionMapper.toDtos(receptionRepository.findAll(Search.expression(addGmaoToSearch(search), RcpReception.class), pageable), false);
    }

    @Override
    public Reception findOne(String search) throws AttributesNotFound, ErrorType {
        return ReceptionMapper.toDto (receptionRepository.findOne
                (Search.expression (search, RcpReception.class)).orElseThrow
                (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return receptionRepository.count(Search.expression(addGmaoToSearch(search), RcpReception.class));
    }

    @Override
    public void delete(Long id) {
        receptionRepository.deleteById(id);
    }

    @Override
    public void delete(Reception Reception) {
        receptionRepository.delete(ReceptionMapper.toEntity(Reception, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            receptionRepository.deleteById(id);        }
    }

    @Override
    public List<Reception> findAll() {
        return ReceptionMapper.toDtos(receptionRepository.findAll(), false);
    }

    @Override
    public void updateReception(Reception reception) {
        try {
            reception = findById(reception.getId());

            List<ReceptionLine> receptionLines = receptionLineService.find("reception.id:" + reception.getId());
            reception.setReceptionLines(new HashSet<>(receptionLines));
            long countClosedLines = receptionLines.stream().filter(receptionLine -> receptionLine.getOrderStatus().getId() == 4).count();

            if (countClosedLines == receptionLines.size()) {
                reception.setOrderStatus(orderStatusService.completedStatus());
                //   reception.setActive(false);
            } else if (countClosedLines >= 1 || reception.getReceptionLines().stream().anyMatch(receptionLine -> receptionLine.getOrderStatus().getId() == 7)) {
                reception.setOrderStatus(orderStatusService.partialStatus());
            } else return;
            save(reception);

        } catch (IdNotFound | AttributesNotFound | ErrorType | CustomException | ContainerException | ProductControls e) {
           // LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Reception> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ReceptionMapper.toDtos(receptionRepository.findAll(Search.expression(addGmaoToSearch(""), RcpReception.class), pageable), false);

    }

    @Override
    public String getNextVal() {
     String value=settingService.generateCodeReception() + receptionRepository.getNextVal().get(0);
        return value;


    }

}

