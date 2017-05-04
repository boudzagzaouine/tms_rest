package com.sinno.ems.service;

import com.sinno.ems.dto.SaleOrderStock;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleOrderStockService {

    public SaleOrderStock save(SaleOrderStock saleOrderStock) throws ProductControls;

    public Long size();

    public Boolean isExist(Long id);

    public SaleOrderStock findById(Long id) throws IdNotFound;

    public List<SaleOrderStock> find(String search) throws AttributesNotFound, ErrorType;

    public List<SaleOrderStock> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(SaleOrderStock saleOrderStock);

    public List<SaleOrderStock> findAll();

    public List<SaleOrderStock> findAll(Pageable pageable);
}