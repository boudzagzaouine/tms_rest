package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleOrderStockArcService {

    public SaleOrderStockArc save(SaleOrderStockArc saleOrderStockArc);

    public Long size();

    public Boolean isExist(Long id);

    public SaleOrderStockArc findById(Long id) throws IdNotFound;

    public List<SaleOrderStockArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<SaleOrderStockArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(SaleOrderStockArc saleOrderStockArc);

    public List<SaleOrderStockArc> findAll();

    public List<SaleOrderStockArc> findAll(Pageable pageable);
}