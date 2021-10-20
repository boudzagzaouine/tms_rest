package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.PurshaseOrder;
import com.bagile.gmo.dto.PurshaseOrderLine;
import com.bagile.gmo.entities.RcpPurshaseOrder;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PurshaseOrderMapper;
import com.bagile.gmo.repositories.PurshaseOrderRepository;
import com.bagile.gmo.services.OrderStatusService;
import com.bagile.gmo.services.PurshaseOrderLineService;
import com.bagile.gmo.services.PurshaseOrderService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.util.GmaoSearch;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;


@Service
public class PurshaseOrderServiceImpl implements PurshaseOrderService, GmaoSearch {
    
    private final PurshaseOrderRepository purshaseOrderRepository;
    @Autowired
    private PurshaseOrderLineService purshaseOrderLineService;

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private SettingService settingService;
    public PurshaseOrderServiceImpl(PurshaseOrderRepository purshaseOrderRepository) {
        this.purshaseOrderRepository = purshaseOrderRepository;
    }

    @Override
    public PurshaseOrder save(PurshaseOrder purshaseOrder) {
         purshaseOrder.setGmao(true);
        return PurshaseOrderMapper.toDto(purshaseOrderRepository.saveAndFlush(PurshaseOrderMapper.toEntity(purshaseOrder, false)), false);
    }

    @Override
    public Long size() throws AttributesNotFound, ErrorType {
        return purshaseOrderRepository.count(Search.expression(addGmaoToSearch(""),RcpPurshaseOrder.class));
    }

    @Override
    public Boolean isExist(Long id) {
        return purshaseOrderRepository.existsById(id);
    }

    @Override
    public PurshaseOrder findById(Long id) throws IdNotFound {
        return PurshaseOrderMapper.toDto(purshaseOrderRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<PurshaseOrder> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(Search.expression(addGmaoToSearch(search), RcpPurshaseOrder.class)), false);
    }

    @Override
    public List<PurshaseOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(Search.expression(addGmaoToSearch(search), RcpPurshaseOrder.class), pageable), false);
    }

    @Override
    public PurshaseOrder findOne(String search) throws AttributesNotFound, ErrorType {
        return PurshaseOrderMapper.toDto (purshaseOrderRepository.findOne (Search.expression (search, RcpPurshaseOrder.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return purshaseOrderRepository.count(Search.expression(addGmaoToSearch(search), RcpPurshaseOrder.class));
    }

    @Override
    public void delete(Long id) {
        purshaseOrderRepository.deleteById(id);
    }

    @Override
    public void delete(PurshaseOrder purshaseOrder) {
        purshaseOrderRepository.delete(PurshaseOrderMapper.toEntity(purshaseOrder, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            purshaseOrderRepository.deleteById(id);        }
    }

    @Override
    public List<PurshaseOrder> findAll() {
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(), false);
    }

    @Override
    public List<PurshaseOrder> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(Search.expression(addGmaoToSearch(""), RcpPurshaseOrder.class),pageable), false);
    }
    private void archivePurshaseOrder(PurshaseOrder purshaseOrder) throws IdNotFound {
        if (purshaseOrder.getOrderStatus().equals(orderStatusService.closedStatus())){
                //&& purshaseOrder.getPaymentStatus().equals(paymentStatusService.equals(paymentStatusService.payedStatus()))) {
            purshaseOrder.setActive(false);
        }
    }

    @Override
    public void updatePurshaseOrder(PurshaseOrder purshaseOrder) {

        try {
            purshaseOrder = findById(purshaseOrder.getId());
            List<PurshaseOrderLine> purshaseOrderLines = purshaseOrderLineService.find("purshaseOrder.id:" + purshaseOrder.getId());
            purshaseOrder.setPurshaseOrderLines(new HashSet<>(purshaseOrderLines));
            if (purshaseOrderLines.stream().allMatch(purshaseOrderLine -> purshaseOrderLine.getOrderStatus().getId() == 1)) {
                archivePurshaseOrder(purshaseOrder);
                purshaseOrder.setOrderStatus(orderStatusService.closedStatus());
            } else if (purshaseOrderLines.stream().anyMatch(purshaseOrderLine -> purshaseOrderLine.getOrderStatus().getId() == 1 ||purshaseOrderLine.getOrderStatus().getId() == 7)) {
                purshaseOrder.setOrderStatus(orderStatusService.partialStatus());
            }
            purshaseOrder.setPurshaseOrderLines(new HashSet<>(purshaseOrderLines));
            save(purshaseOrder);
        } catch (IdNotFound | AttributesNotFound | ErrorType idNotFound) {
            idNotFound.printStackTrace();
        }
    }

    @Override
    public String getNextVal() {

        String codePurshaseOrder = settingService.generateCodePurshaseOrder();
        if (null != codePurshaseOrder && !"".equals(codePurshaseOrder))
            return codePurshaseOrder + purshaseOrderRepository.getNextVal().get(0);
        return "";

    }


}

