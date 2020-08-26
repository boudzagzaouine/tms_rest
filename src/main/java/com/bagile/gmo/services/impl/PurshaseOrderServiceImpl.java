package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.PurshaseOrder;
import com.bagile.gmo.entities.RcpPurshaseOrder;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PurshaseOrderMapper;
import com.bagile.gmo.repositories.PurshaseOrderRepository;
import com.bagile.gmo.services.PurshaseOrderService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PurshaseOrderServiceImpl implements PurshaseOrderService {
    
    private final PurshaseOrderRepository purshaseOrderRepository;
    public PurshaseOrderServiceImpl(PurshaseOrderRepository purshaseOrderRepository) {
        this.purshaseOrderRepository = purshaseOrderRepository;
    }

    @Override
    public PurshaseOrder save(PurshaseOrder purshaseOrder) {
        return PurshaseOrderMapper.toDto(purshaseOrderRepository.saveAndFlush(PurshaseOrderMapper.toEntity(purshaseOrder, false)), false);
    }

    @Override
    public Long size() {
        return purshaseOrderRepository.count();
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
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(Search.expression(search, RcpPurshaseOrder.class)), false);
    }

    @Override
    public List<PurshaseOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(Search.expression(search, RcpPurshaseOrder.class), pageable), false);
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
        return purshaseOrderRepository.count(Search.expression(search, RcpPurshaseOrder.class));
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
    public List<PurshaseOrder> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PurshaseOrderMapper.toDtos(purshaseOrderRepository.findAll(pageable), false);
    }



}

