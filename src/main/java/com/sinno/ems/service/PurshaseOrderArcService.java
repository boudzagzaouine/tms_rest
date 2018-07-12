package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurshaseOrderArcService {

    public PurshaseOrderArc save(PurshaseOrderArc purshaseOrderArc);

    public Long size();

    public Boolean isExist(Long id);

    public PurshaseOrderArc findById(Long id) throws IdNotFound;

    public List<PurshaseOrderArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<PurshaseOrderArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(PurshaseOrderArc purshaseOrderArc);

    public List<PurshaseOrderArc> findAll();

    public List<PurshaseOrderArc> findAll(Pageable pageable);
}