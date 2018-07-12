package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/01/2017.
 */
public interface UserAgencyService {
    UserAgency save(UserAgency zoneWarehouse);

    Long size();

    Boolean isExist(Long id);

    UserAgency findById(Long id) throws IdNotFound;

    List<UserAgency> find(String search) throws AttributesNotFound, ErrorType;

    List<UserAgency> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(UserAgency zoneWarehouse);

    List<UserAgency> findAll();

    List<UserAgency> findAll(Pageable pageable);
}
