package com.sinno.ems.service;

import com.sinno.ems.dto.Stock;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockService {

    public Stock save(Stock stock) throws ProductControls;

    public Long size();

    public Boolean isExist(Long id);

    public Stock findById(Long id) throws IdNotFound;

    public List<Stock> find(String search) throws AttributesNotFound, ErrorType;

    public List<Stock> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Stock stock);

    public List<Stock> findAll() throws AttributesNotFound, ErrorType;

    public List<Stock> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;
}