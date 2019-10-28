package com.bagile.tms.services;

import com.bagile.tms.dto.BadgeType;
import com.bagile.tms.dto.DriverZone;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BadgeTypeService {
    BadgeType save(BadgeType badgeType);

    Long size();

    Boolean isExist(Long id);

    BadgeType findById(Long id) throws IdNotFound;

    List<BadgeType> find(String search) throws AttributesNotFound, ErrorType;

    List<BadgeType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(BadgeType badgeType);

    List<BadgeType> findAll();

    List<BadgeType> findAll(Pageable pageable);

    interface DriverZoneService {

        DriverZone save(DriverZone driverzone);

        Long size();

        Boolean isExist(Long id);

        DriverZone findById(Long id) throws IdNotFound;

        List<DriverZone> find(String search) throws AttributesNotFound, ErrorType;

        List<DriverZone> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

        Long size(String search) throws AttributesNotFound, ErrorType;

        void delete(Long id);

        void delete(DriverZone driverzone);

        List<DriverZone> findAll();

        List<DriverZone> findAll(Pageable pageable);
    }
}
