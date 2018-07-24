package com.bagile.tms.services;

import com.sinno.ems.dto.DriverBadge;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by khalil on 26/04/2017.
 */
public interface DriverBadgeService {
    DriverBadge save(DriverBadge driverBadge);

    Long size();

    Boolean isExist(Long id);

    DriverBadge findById(Long id) throws IdNotFound;

    List<DriverBadge> find(String search) throws AttributesNotFound, ErrorType;

    List<DriverBadge> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(DriverBadge driverBadge);

    List<DriverBadge> findAll();

    List<DriverBadge> findAll(Pageable pageable);
}
