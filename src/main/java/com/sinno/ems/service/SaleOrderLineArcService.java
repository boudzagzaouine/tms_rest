package com.sinno.ems.service;

import com.sinno.ems.dto.SaleOrderLineArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleOrderLineArcService {

    public SaleOrderLineArc save(SaleOrderLineArc saleOrderLineArc);

    public Long size();

    public Boolean isExist(Long id);

    public SaleOrderLineArc findById(Long id) throws IdNotFound;

    public List<SaleOrderLineArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<SaleOrderLineArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(SaleOrderLineArc saleOrderLineArc);

    public List<SaleOrderLineArc> findAll();

    public List<SaleOrderLineArc> findAll(Pageable pageable);
}