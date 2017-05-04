package com.sinno.ems.service.impl;

import com.sinno.ems.dto.StockException;
import com.sinno.ems.entities.StkStockException;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.StockExceptionMapper;
import com.sinno.ems.repositories.StockExceptionRepository;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.StockExceptionService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASMAE on 28/04/2016.
 */

@Service
public class StockExceptionServiceImpl implements StockExceptionService{

    @Autowired
    private StockExceptionRepository stockExceptionRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(StockExceptionService.class);

    @Override
    public StockException save(StockException stockException) {
        LOGGER.info("save StockException");
        stockException.setUpdateDateOld(EmsDate.getDateNow());
        if (0 >= stockException.getId()) {
            stockException.setCreationDateNew(EmsDate.getDateNow());
        }
        return StockExceptionMapper.toDto(stockExceptionRepository.saveAndFlush(StockExceptionMapper.toEntity(stockException, false)), false);

    }

    @Override
    public Long size() {
        return stockExceptionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return stockExceptionRepository.exists(id);
    }

    @Override
    public StockException findById(Long id) throws IdNotFound {
        StockException stockException = StockExceptionMapper.toDto(stockExceptionRepository.findOne(id), false);
        if (null != stockException) {
            return stockException;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<StockException> find(String search) throws AttributesNotFound, ErrorType {
        return StockExceptionMapper.toDtos(stockExceptionRepository.findAll(Search.expression(search, StkStockException.class)), false);

    }

    @Override
    public List<StockException> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return StockExceptionMapper.toDtos(stockExceptionRepository.findAll(Search.expression(search, StkStockException.class), pageable), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return stockExceptionRepository.count(Search.expression(search, StkStockException.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete StockException");
        stockExceptionRepository.delete(id);
    }

    @Override
    public void delete(StockException stockException) {
        LOGGER.info("delete StockException");
        stockExceptionRepository.delete(StockExceptionMapper.toEntity(stockException, false));
    }

    @Override
    public List<StockException> findAll() throws AttributesNotFound, ErrorType {
        return StockExceptionMapper.toDtos(stockExceptionRepository.findAll(), false);
    }

    @Override
    public List<StockException> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return StockExceptionMapper.toDtos(stockExceptionRepository.findAll(pageable), false);
    }
}
