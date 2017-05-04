package com.sinno.ems.service;

import com.sinno.ems.dto.PurshaseOrderLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurshaseOrderLineService {

    public PurshaseOrderLine save(PurshaseOrderLine purshaseOrderLine) throws ProductControls;

    public Long size();

    public Boolean isExist(Long id);

    public PurshaseOrderLine findById(Long id) throws IdNotFound;

    public List<PurshaseOrderLine> find(String search) throws AttributesNotFound, ErrorType;

    public List<PurshaseOrderLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(PurshaseOrderLine purshaseOrderLine);

    public List<PurshaseOrderLine> findAll();

    public List<PurshaseOrderLine> findAll(Pageable pageable);
}