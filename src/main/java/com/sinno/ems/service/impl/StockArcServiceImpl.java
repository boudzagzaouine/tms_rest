package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.StockArcMapper;
import com.sinno.ems.repositories.StockArcRepository;
import com.sinno.ems.service.StockArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockArcServiceImpl implements StockArcService {

    @Autowired
    private StockArcRepository stockArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(StockArcService.class);

    @Override
    public StockArc save(StockArc stockArc) {
        LOGGER.info("save StockArc");
        return StockArcMapper.toDto(stockArcRepository.saveAndFlush(StockArcMapper.toEntity(stockArc, false)), false);
    }

    @Override
    public Long size() {
        return stockArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return stockArcRepository.exists(id);
    }

    @Override
    public StockArc findById(Long id) throws IdNotFound {
        StockArc stockArc = StockArcMapper.toDto(stockArcRepository.findOne(id), false);
        if (null != stockArc) {
            return stockArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<StockArc> find(String search) throws AttributesNotFound, ErrorType {
        return StockArcMapper.toDtos(stockArcRepository.findAll(Search.expression(search, StkStockArc.class)), false);
    }

    @Override
    public List<StockArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return StockArcMapper.toDtos(stockArcRepository.findAll(Search.expression(search, StkStockArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return stockArcRepository.count(Search.expression(search, StkStockArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete StockArc");
        stockArcRepository.delete(id);
    }

    @Override
    public void delete(StockArc stockArc) {
        LOGGER.info("delete StockArc");
        stockArcRepository.delete(StockArcMapper.toEntity(stockArc, false));
    }

    @Override
    public List<StockArc> findAll() {
        return StockArcMapper.toDtos(stockArcRepository.findAll(), false);
    }

    @Override
    public List<StockArc> findAll(Pageable pageable) {
        return StockArcMapper.toDtos(stockArcRepository.findAll(pageable), false);
    }
}