package com.bagile.gmo.services;

import com.bagile.gmo.dto.DriverZone;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DriverZoneService {


    DriverZone save(DriverZone driverzone);

    Long size();

    Boolean isExist(Long id);

    DriverZone findById(Long id) throws IdNotFound;

    List<DriverZone> find(String search) throws AttributesNotFound, ErrorType;

    List<DriverZone> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(DriverZone driverzone);

    List<DriverZone> findAll();

    List<DriverZone> findAll(int page, int size);
}
