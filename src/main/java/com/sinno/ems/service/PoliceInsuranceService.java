package com.sinno.ems.service;

import com.sinno.ems.dto.PoliceAssurance;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by bouzi on 4/3/2017.
 */
public interface PoliceInsuranceService {
    PoliceAssurance save(PoliceAssurance policeAssurance);

    Long size();

    Boolean isExist(Long id);

    PoliceAssurance findById(Long id)throws IdNotFound;

    List<PoliceAssurance> find(String search)throws AttributesNotFound,ErrorType;

    List<PoliceAssurance>find(String search, Pageable pageable)throws AttributesNotFound,ErrorType;

    Long size(String search)throws AttributesNotFound,ErrorType;

    void delete(Long id);

    void delete(PoliceAssurance natureIncident);

    List<PoliceAssurance>findAll();

    List<PoliceAssurance> findAll(Pageable pageable);
}
