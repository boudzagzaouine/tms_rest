package com.sinno.ems.service;

import com.sinno.ems.dto.Aisle;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AisleService {

    public Aisle save(Aisle aisle);

    public Long size();

    public Boolean isExist(Long id);

    public Aisle findById(Long id) throws IdNotFound;

    public List<Aisle> find(String search) throws AttributesNotFound, ErrorType;

    public List<Aisle> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Aisle aisle);

    public List<Aisle> findAll();

    public List<Aisle> findAll(Pageable pageable);
}