package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.PurshaseOrderLine;
import com.bagile.gmo.entities.RcpPurshaseOrderLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PurshaseOrderLineMapper;
import com.bagile.gmo.repositories.PurshaseOrderLineRepository;
import com.bagile.gmo.services.OrderStatusService;
import com.bagile.gmo.services.PurshaseOrderLineService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Service
public class PurshaseOrderLineServiceImpl implements PurshaseOrderLineService {
    
    private final PurshaseOrderLineRepository purshaseOrderLineRepository;
    private OrderStatusService orderStatusService;
    public PurshaseOrderLineServiceImpl(PurshaseOrderLineRepository purshaseOrderLineRepository,
                                        OrderStatusService orderStatusService) {
        this.purshaseOrderLineRepository = purshaseOrderLineRepository;
        this.orderStatusService = orderStatusService;
    }

    @Override
    public PurshaseOrderLine save(PurshaseOrderLine purshaseOrderLine) {
        return PurshaseOrderLineMapper.toDto(purshaseOrderLineRepository.saveAndFlush(PurshaseOrderLineMapper.toEntity(purshaseOrderLine, false)), false);
    }

    @Override
    public Long size() {
        return purshaseOrderLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return purshaseOrderLineRepository.existsById(id);
    }

    @Override
    public PurshaseOrderLine findById(Long id) throws IdNotFound {
        return PurshaseOrderLineMapper.toDto(purshaseOrderLineRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<PurshaseOrderLine> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return PurshaseOrderLineMapper.toDtos(purshaseOrderLineRepository.findAll(Search.expression(search, RcpPurshaseOrderLine.class)), false);
    }

    @Override
    public List<PurshaseOrderLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PurshaseOrderLineMapper.toDtos(purshaseOrderLineRepository.findAll(Search.expression(search, RcpPurshaseOrderLine.class), pageable), false);
    }

    @Override
    public PurshaseOrderLine findOne(String search) throws AttributesNotFound, ErrorType {
        return PurshaseOrderLineMapper.toDto (purshaseOrderLineRepository.findOne (Search.expression (search, RcpPurshaseOrderLine.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return purshaseOrderLineRepository.count(Search.expression(search, RcpPurshaseOrderLine.class));
    }

    @Override
    public void delete(Long id) {
        purshaseOrderLineRepository.deleteById(id);
    }

    @Override
    public void delete(PurshaseOrderLine purshaseOrderLine) {
        purshaseOrderLineRepository.delete(PurshaseOrderLineMapper.toEntity(purshaseOrderLine, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            purshaseOrderLineRepository.deleteById(id);        }
    }

    @Override
    public List<PurshaseOrderLine> findAll() {
        return PurshaseOrderLineMapper.toDtos(purshaseOrderLineRepository.findAll(), false);
    }

    @Override
    public List<PurshaseOrderLine> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PurshaseOrderLineMapper.toDtos(purshaseOrderLineRepository.findAll(pageable), false);
    }

    @Override
    public void updatePurshaseOrderLine(PurshaseOrderLine purshaseOrderLine) {
        try {
            if (purshaseOrderLine.getQuantityReceived().compareTo(purshaseOrderLine.getQuantity()) > -1) {
                purshaseOrderLine.setOrderStatus(orderStatusService.findById(1L));
            } else if (purshaseOrderLine.getQuantityReceived().compareTo(BigDecimal.ZERO) > 0) {
                purshaseOrderLine.setOrderStatus(orderStatusService.findById(7L));
            } else return;
            save(purshaseOrderLine);
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
    }


}

