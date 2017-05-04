package com.sinno.ems.service;

import com.sinno.ems.dto.WarrantyPeriod;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 15/12/2016.
 */
public interface WarrantyPeriodService {
    WarrantyPeriod save(WarrantyPeriod warrantyPeriod);

    Long size();

    Boolean isExist(Long id);

    WarrantyPeriod findById(Long id) throws IdNotFound;

    List<WarrantyPeriod> find(String search) throws AttributesNotFound, ErrorType;

    List<WarrantyPeriod> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(WarrantyPeriod warrantyPeriod);

    List<WarrantyPeriod> findAll();

    List<WarrantyPeriod> findAll(Pageable pageable);
}
