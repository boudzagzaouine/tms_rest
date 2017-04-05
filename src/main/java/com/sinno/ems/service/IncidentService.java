package com.sinno.ems.service;

import com.sinno.ems.dto.Incident;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by khalil on 04/04/2017.
 */
public interface IncidentService {
    Incident save(Incident incident);

    Long size();

    Boolean isExist(Long id);

    Incident findById(Long id) throws IdNotFound;

    List<Incident> find(String search) throws AttributesNotFound, ErrorType;

    List<Incident> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Incident incident);

    List<Incident> findAll();

    List<Incident> findAll(Pageable pageable);
}
