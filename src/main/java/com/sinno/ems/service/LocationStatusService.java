package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 04/05/2016.
 */
public interface LocationStatusService {
    Long size();

    Boolean isExist(Long id);

    LocationStatus findById(Long id) throws IdNotFound;

    List<LocationStatus> find(String search) throws AttributesNotFound, ErrorType;

    List<LocationStatus> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(LocationStatus locationStatus);

    List<LocationStatus> findAll();

    List<LocationStatus> findAll(Pageable pageable);
    LocationStatus save(LocationStatus locationStatus);
}
