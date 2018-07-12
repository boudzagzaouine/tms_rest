package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 02/01/2017.
 */
public interface AgencyService {
    Agency save(Agency agency);

    Long size();

    Boolean isExist(Long id);

    Agency findById(Long id) throws IdNotFound;

    List<Agency> find(String search) throws AttributesNotFound, ErrorType;

    List<Agency> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Agency agency);

    List<Agency> findAll();

    List<Agency> findAll(Pageable pageable);
}
