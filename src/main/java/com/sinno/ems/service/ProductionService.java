package com.sinno.ems.service;

import com.sinno.ems.dto.Production;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/04/2017.
 */
public interface ProductionService {
    Production save(Production production);

    Long size();

    Boolean isExist(Long id);

    Production findById(Long id) throws IdNotFound;

    List<Production> find(String search) throws AttributesNotFound, ErrorType;

    List<Production> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Production production);

    List<Production> findAll();

    List<Production> findAll(Pageable pageable);
}
