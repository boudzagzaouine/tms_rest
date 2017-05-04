package com.sinno.ems.service;

import com.sinno.ems.dto.Zone;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZoneService {

    public Zone save(Zone zone);

    public Long size();

    public Boolean isExist(Long id);

    public Zone findById(Long id) throws IdNotFound;

    public List<Zone> find(String search) throws AttributesNotFound, ErrorType;

    public List<Zone> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Zone zone);

    public List<Zone> findAll();

    public List<Zone> findAll(Pageable pageable);
}