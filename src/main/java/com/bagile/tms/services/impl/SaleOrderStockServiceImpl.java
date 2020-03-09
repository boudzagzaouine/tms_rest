package com.bagile.tms.services.impl;

import com.bagile.tms.dto.SaleOrderStock;
import com.bagile.tms.dto.SaleOrderLine;
import com.bagile.tms.entities.CmdSaleOrderStock;
import com.bagile.tms.exceptions.*;
import com.bagile.tms.mapper.SaleOrderStockMapper;
import com.bagile.tms.repositories.SaleOrderStockRepository;
import com.bagile.tms.services.SaleOrderStockService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class SaleOrderStockServiceImpl implements SaleOrderStockService {
    private final SaleOrderStockRepository saleOrderStockRepository;
    public SaleOrderStockServiceImpl(SaleOrderStockRepository saleOrderStockRepository) {
        this.saleOrderStockRepository = saleOrderStockRepository;
    }



    @Override
    public SaleOrderStock save(SaleOrderStock saleOrderStock) throws ProductControls, IdNotFound, CustomException, AttributesNotFound, ErrorType {
        return SaleOrderStockMapper.toDto(saleOrderStockRepository.saveAndFlush(SaleOrderStockMapper.toEntity(saleOrderStock, false)), false);

    }

    @Override
    public Long size() {
        return saleOrderStockRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return saleOrderStockRepository.existsById(id);
    }

    @Override
    public SaleOrderStock findById(Long id) throws IdNotFound {
        return SaleOrderStockMapper.toDto(saleOrderStockRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public SaleOrderStock findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<SaleOrderStock> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return SaleOrderStockMapper.toDtos(saleOrderStockRepository.findAll(Search.expression(search, CmdSaleOrderStock.class)), false);
    }


    @Override
    public List<SaleOrderStock> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderStockMapper.toDtos(saleOrderStockRepository.findAll(Search.expression(search, CmdSaleOrderStock.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return saleOrderStockRepository.count(Search.expression(search, CmdSaleOrderStock.class));
    }

    @Override
    public void delete(Long id) {
        saleOrderStockRepository.deleteById(id);
    }

    @Override
    public void delete(SaleOrderStock saleOrderStock) {
        saleOrderStockRepository.delete(SaleOrderStockMapper.toEntity(saleOrderStock, false));
    }

    @Override
    public List<SaleOrderStock> findAll() {
        return SaleOrderStockMapper.toDtos(saleOrderStockRepository.findAll(), false);
    }



    @Override
    public List<SaleOrderStock> saveAll(List<SaleOrderStock> saleOrderStockList, boolean fromPos) {
        return null;
    }






    @Override
    public List<SaleOrderStock> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderStockMapper.toDtos(saleOrderStockRepository.findAll(pageable), false);
    }

}

