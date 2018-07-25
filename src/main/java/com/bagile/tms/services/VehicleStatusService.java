package com.bagile.tms.services;

import com.bagile.tms.dto.VehiculeStatus;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
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
