package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.StockReservedMapper;
import com.sinno.ems.repositories.StockReservedRepository;
import com.sinno.ems.service.StockReservedService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockReservedServiceImpl implements StockReservedService {

    @Autowired
    private StockReservedRepository stockReservedRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(StockReservedService.class);

    @Override
    public StockReserved save(StockReserved stockReserved) {
        LOGGER.info("save StockReserved");
        stockReserved.setUpdateDate(EmsDate.getDateNow());
        if (0 >= stockReserved.getId()) {
            stockReserved.setCreationDate(EmsDate.getDateNow());
        }
        return StockReservedMapper.toDto(stockReservedRepository.saveAndFlush(StockReservedMapper.toEntity(stockReserved, false)), false);
    }

    @Override
    public Long size() {
        return stockReservedRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return stockReservedRepository.exists(id);
    }

    @Override
    public StockReserved findById(Long id) throws IdNotFound {
        StockReserved stockReserved = StockReservedMapper.toDto(stockReservedRepository.findOne(id), false);
        if (null != stockReserved) {
            return stockReserved;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<StockReserved> find(String search) throws AttributesNotFound, ErrorType {
        return StockReservedMapper.toDtos(stockReservedRepository.findAll(Search.expression(search, StkStockReserved.class)), false);
    }

    @Override
    public List<StockReserved> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return StockReservedMapper.toDtos(stockReservedRepository.findAll(Search.expression(search, StkStockReserved.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return stockReservedRepository.count(Search.expression(search, StkStockReserved.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete StockReserved");
        stockReservedRepository.delete(id);
    }

    @Override
    public void delete(StockReserved stockReserved) {
        LOGGER.info("delete stockReserved");
        stockReservedRepository.delete(StockReservedMapper.toEntity(stockReserved, false));
    }

    @Override
    public List<StockReserved> findAll() {
        return StockReservedMapper.toDtos(stockReservedRepository.findAll(), false);
    }

    @Override
    public List<StockReserved> findAll(Pageable pageable) {
        return StockReservedMapper.toDtos(stockReservedRepository.findAll(pageable), false);
    }
}