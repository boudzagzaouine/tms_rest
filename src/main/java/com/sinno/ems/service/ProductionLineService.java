package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/04/2017.
 */
public interface ProductionLineService {
    ProductionLine save(ProductionLine productionLine);

    Long size();

    Boolean isExist(Long id);

    ProductionLine findById(Long id) throws IdNotFound;

    List<ProductionLine> find(String search) throws AttributesNotFound, ErrorType;

    List<ProductionLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ProductionLine productionLine);

    List<ProductionLine> findAll();

    List<ProductionLine> findAll(Pageable pageable);
}
