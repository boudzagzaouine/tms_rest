package com.sinno.ems.service;

import com.sinno.ems.dto.PurshaseOrderLineArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurshaseOrderLineArcService {

    public PurshaseOrderLineArc save(PurshaseOrderLineArc purshaseOrderLineArc);

    public Long size();

    public Boolean isExist(Long id);

    public PurshaseOrderLineArc findById(Long id) throws IdNotFound;

    public List<PurshaseOrderLineArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<PurshaseOrderLineArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(PurshaseOrderLineArc purshaseOrderLineArc);

    public List<PurshaseOrderLineArc> findAll();

    public List<PurshaseOrderLineArc> findAll(Pageable pageable);
}