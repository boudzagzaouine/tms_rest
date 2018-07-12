package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface PreparationLineService {
    PreparationLine save(PreparationLine preparationLine);

    Long size();

    Boolean isExist(Long id);

    PreparationLine findById(Long id) throws IdNotFound;

    List<PreparationLine> find(String search) throws AttributesNotFound, ErrorType;

    List<PreparationLine> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PreparationLine preparationLine);

    List<PreparationLine> findAll();

    List<PreparationLine> findAll(Pageable pageable);
}
