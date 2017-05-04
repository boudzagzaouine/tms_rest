package com.sinno.ems.service;

import com.sinno.ems.dto.Kit;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KitService {

    public Kit save(Kit kit);

    public Long size();

    public Boolean isExist(Long id);

    public Kit findById(Long id) throws IdNotFound;

    public List<Kit> find(String search) throws AttributesNotFound, ErrorType;

    public List<Kit> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Kit kit);

    public List<Kit> findAll();

    public List<Kit> findAll(Pageable pageable);
}