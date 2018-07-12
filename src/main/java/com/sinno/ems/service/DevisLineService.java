package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 06/12/2016.
 */
public interface DevisLineService {
    DevisLine save(DevisLine devisLine);

    Long size();

    Boolean isExist(Long id);

    DevisLine findById(Long id) throws IdNotFound;

    List<DevisLine> find(String search) throws AttributesNotFound, ErrorType;

    List<DevisLine> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(DevisLine devisLine);

    List<DevisLine> findAll() throws AttributesNotFound, ErrorType;

    List<DevisLine> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;
}
