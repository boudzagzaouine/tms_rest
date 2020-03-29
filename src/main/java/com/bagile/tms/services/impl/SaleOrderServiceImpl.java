package com.bagile.tms.services.impl;

import com.bagile.tms.dto.SaleOrder;
import com.bagile.tms.dto.SaleOrder;
import com.bagile.tms.entities.CmdSaleOrder;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.CustomException;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.SaleOrderMapper;
import com.bagile.tms.repositories.SaleOrderRepository;
import com.bagile.tms.services.SaleOrderService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SaleOrderServiceImpl implements SaleOrderService {
    private final SaleOrderRepository saleOrderOrderRepository;
    public SaleOrderServiceImpl(SaleOrderRepository saleOrderOrderRepository) {
        this.saleOrderOrderRepository = saleOrderOrderRepository;
    }

    @Override
    public SaleOrder save(SaleOrder saleOrderOrder) {
        return SaleOrderMapper.toDto(saleOrderOrderRepository.saveAndFlush(SaleOrderMapper.toEntity(saleOrderOrder, false)), false);
    }

    @Override
    public Long size() {
        return saleOrderOrderRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return saleOrderOrderRepository.existsById(id);
    }

    @Override
    public SaleOrder findById(Long id) throws IdNotFound {
        return SaleOrderMapper.toDto(saleOrderOrderRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public SaleOrder findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<SaleOrder> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return SaleOrderMapper.toDtos(saleOrderOrderRepository.findAll(Search.expression(search, CmdSaleOrder.class)), false);
    }

    @Override
    public List<SaleOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderMapper.toDtos(saleOrderOrderRepository.findAll(Search.expression(search, CmdSaleOrder.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return saleOrderOrderRepository.count(Search.expression(search, CmdSaleOrder.class));
    }

    @Override
    public void delete(Long id) {
        saleOrderOrderRepository.deleteById(id);
    }

    @Override
    public void delete(SaleOrder saleOrderOrder) {
        saleOrderOrderRepository.delete(SaleOrderMapper.toEntity(saleOrderOrder, false));
    }

    @Override
    public List<SaleOrder> findAll() {
        return SaleOrderMapper.toDtos(saleOrderOrderRepository.findAll(), false);
    }


    @Override
    public String getNextVal() {
        return null;
    }


    @Override
    public List<SaleOrder> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderMapper.toDtos(saleOrderOrderRepository.findAll(pageable), false);
    }

}

