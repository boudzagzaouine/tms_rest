package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.SaleOrder;
import com.bagile.gmo.entities.CmdSaleOrder;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SaleOrderMapper;
import com.bagile.gmo.repositories.SaleOrderRepository;
import com.bagile.gmo.services.SaleOrderService;
import com.bagile.gmo.util.GmaoSearch;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SaleOrderServiceImpl implements SaleOrderService, GmaoSearch {
    private final SaleOrderRepository saleOrderOrderRepository;
    public SaleOrderServiceImpl(SaleOrderRepository saleOrderOrderRepository) {
        this.saleOrderOrderRepository = saleOrderOrderRepository;
    }

    @Override
    public SaleOrder save(SaleOrder saleOrderOrder) {
        saleOrderOrder.setGmao(true);
        return SaleOrderMapper.toDto(saleOrderOrderRepository.saveAndFlush(SaleOrderMapper.toEntity(saleOrderOrder, false)), false);
    }

    @Override
    public Long size() throws AttributesNotFound, ErrorType {
        return saleOrderOrderRepository.count(Search.expression(addGmaoToSearch(""),SaleOrder.class));
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
        return SaleOrderMapper.toDtos(saleOrderOrderRepository.findAll(Search.expression(addGmaoToSearch(search), CmdSaleOrder.class)), false);
    }

    @Override
    public List<SaleOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderMapper.toDtos(saleOrderOrderRepository.findAll(Search.expression(addGmaoToSearch(search), CmdSaleOrder.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return saleOrderOrderRepository.count(Search.expression(addGmaoToSearch(search), CmdSaleOrder.class));
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
    public List<SaleOrder> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderMapper.toDtos(saleOrderOrderRepository.findAll(Search.expression(addGmaoToSearch(""), CmdSaleOrder.class),pageable), false);
    }

}

