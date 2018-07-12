package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceptionLineArcService {

    public ReceptionLineArc save(ReceptionLineArc receptionLineArc);

    public Long size();

    public Boolean isExist(Long id);

    public ReceptionLineArc findById(Long id) throws IdNotFound;

    public List<ReceptionLineArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<ReceptionLineArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(ReceptionLineArc receptionLineArc);

    public List<ReceptionLineArc> findAll();

    public List<ReceptionLineArc> findAll(Pageable pageable);
}