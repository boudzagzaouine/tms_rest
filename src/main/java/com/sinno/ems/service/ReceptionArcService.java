package com.sinno.ems.service;

import com.sinno.ems.dto.ReceptionArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceptionArcService {

    public ReceptionArc save(ReceptionArc receptionArc);

    public Long size();

    public Boolean isExist(Long id);

    public ReceptionArc findById(Long id) throws IdNotFound;

    public List<ReceptionArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<ReceptionArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(ReceptionArc receptionArc);

    public List<ReceptionArc> findAll();

    public List<ReceptionArc> findAll(Pageable pageable);
}