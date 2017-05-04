package com.sinno.ems.service;

import com.sinno.ems.dto.SaleOrderArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleOrderArcService {

    public SaleOrderArc save(SaleOrderArc saleOrderArc);

    public Long size();

    public Boolean isExist(Long id);

    public SaleOrderArc findById(Long id) throws IdNotFound;

    public List<SaleOrderArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<SaleOrderArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(SaleOrderArc saleOrderArc);

    public List<SaleOrderArc> findAll();

    public List<SaleOrderArc> findAll(Pageable pageable);
}