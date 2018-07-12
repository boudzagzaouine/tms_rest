package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContainerArcService {

    public ContainerArc save(ContainerArc containerArc);

    public Long size();

    public Boolean isExist(Long id);

    public ContainerArc findById(Long id) throws IdNotFound;

    public List<ContainerArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<ContainerArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(ContainerArc containerArc);

    public List<ContainerArc> findAll();

    public List<ContainerArc> findAll(Pageable pageable);
}