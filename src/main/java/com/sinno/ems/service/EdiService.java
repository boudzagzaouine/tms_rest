package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EdiService {

    public Edi save(Edi edi);

    public Long size();

    public Boolean isExist(Long id);

    public Edi findById(Long id) throws IdNotFound;

    public List<Edi> find(String search) throws AttributesNotFound, ErrorType;

    public List<Edi> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Edi edi);

    public List<Edi> findAll();

    public List<Edi> findAll(Pageable pageable);
}