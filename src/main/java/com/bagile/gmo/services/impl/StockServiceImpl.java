package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Stock;
import com.bagile.gmo.entities.StkStock;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.StockMapper;
import com.bagile.gmo.repositories.StockRepository;
import com.bagile.gmo.services.StockService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock save(Stock stock) {
        return StockMapper.toDto(stockRepository.saveAndFlush(StockMapper.toEntity(stock, false)), false);
    }

    @Override
    public Long size() {
        return stockRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return stockRepository.existsById(id);
    }

    @Override
    public Stock findById(Long id) throws IdNotFound {
        return StockMapper.toDto(stockRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Stock> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return StockMapper.toDtos(stockRepository.findAll(Search.expression(search, StkStock.class)), false);
    }

    @Override
    public List<Stock> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return StockMapper.toDtos(stockRepository.findAll(Search.expression(search, StkStock.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return stockRepository.count(Search.expression(search, StkStock.class));
    }

    @Override
    public void delete(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public void delete(Stock stock) {
        stockRepository.delete(StockMapper.toEntity(stock, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            stockRepository.deleteById(id);        }
    }


    @Override
    public List<Stock> findAll() {
        return StockMapper.toDtos(stockRepository.findAll(), false);
    }

    @Override
    public List<Stock> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return StockMapper.toDtos(stockRepository.findAll(pageable), false);
    }

}

