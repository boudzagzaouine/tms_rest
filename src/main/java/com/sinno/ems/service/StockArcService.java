package com.sinno.ems.service;

import com.sinno.ems.dto.StockArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockArcService {

    public StockArc save(StockArc stockArc);

    public Long size();

    public Boolean isExist(Long id);

    public StockArc findById(Long id) throws IdNotFound;

    public List<StockArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<StockArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(StockArc stockArc);

    public List<StockArc> findAll();

    public List<StockArc> findAll(Pageable pageable);
}