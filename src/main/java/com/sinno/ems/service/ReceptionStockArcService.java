package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceptionStockArcService {

    public ReceptionStockArc save(ReceptionStockArc receptionStockArc);

    public Long size();

    public Boolean isExist(Long id);

    public ReceptionStockArc findById(Long id) throws IdNotFound;

    public List<ReceptionStockArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<ReceptionStockArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(ReceptionStockArc receptionStockArc);

    public List<ReceptionStockArc> findAll();

    public List<ReceptionStockArc> findAll(Pageable pageable);
}