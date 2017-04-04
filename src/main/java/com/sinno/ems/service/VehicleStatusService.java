package com.sinno.ems.service;

import com.sinno.ems.dto.VehiculeStatus;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by bouzi on 4/4/2017.
 */
public interface VehicleStatusService {
    VehiculeStatus save(VehiculeStatus vehiculeStatus);

    Long size();

    Boolean isExist(Long id);

    VehiculeStatus findById(Long id) throws IdNotFound;

    List<VehiculeStatus> find(String search) throws AttributesNotFound, ErrorType;

    List<VehiculeStatus> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(VehiculeStatus vehiculeStatus);

    List<VehiculeStatus> findAll();

    List<VehiculeStatus> findAll(Pageable pageable);
}
