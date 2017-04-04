package com.sinno.ems.service;

import com.sinno.ems.dto.VehiculeType;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by bouzi on 4/4/2017.
 */
public interface VehicleTypeService {
    VehiculeType save(VehiculeType vehiculeType);

    Long size();

    Boolean isExist(Long id);

    VehiculeType findById(Long id) throws IdNotFound;

    List<VehiculeType> find(String search) throws AttributesNotFound, ErrorType;

    List<VehiculeType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(VehiculeType vehiculeType);

    List<VehiculeType> findAll();

    List<VehiculeType> findAll(Pageable pageable);
}
