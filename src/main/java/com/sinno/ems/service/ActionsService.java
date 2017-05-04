package com.sinno.ems.service;

import com.sinno.ems.dto.Actions;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActionsService {

    public Actions save(Actions actions);

    public Long size();

    public Boolean isExist(Long id);

    public Actions findById(Long id) throws IdNotFound;

    public List<Actions> find(String search) throws AttributesNotFound, ErrorType;

    public List<Actions> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Actions actions);

    public List<Actions> findAll();

    public List<Actions> findAll(Pageable pageable);
}