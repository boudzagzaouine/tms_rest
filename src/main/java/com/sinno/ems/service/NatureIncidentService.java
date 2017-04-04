package com.sinno.ems.service;

import com.sinno.ems.dto.NatureIncident;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by bouzi on 4/3/2017.
 */
public interface NatureIncidentService {
    NatureIncident save(NatureIncident natureIncident);

    Long size();

    Boolean isExist(Long id);

    NatureIncident findById(Long id)throws IdNotFound;

    List<NatureIncident> find(String search)throws AttributesNotFound,ErrorType;

    List<NatureIncident>find(String search, Pageable pageable)throws AttributesNotFound,ErrorType;

    Long size(String search)throws AttributesNotFound,ErrorType;

    void delete(Long id);

    void delete(NatureIncident natureIncident);

    List<NatureIncident>findAll();

    List<NatureIncident>findAll(Pageable pageable);
}
