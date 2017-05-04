package com.sinno.ems.service;

import com.sinno.ems.dto.Printer;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/08/2016.
 */
public interface PrinterService {
    Printer save(Printer printer);

    Long size();

    Boolean isExist(Long id);

    Printer findById(Long id) throws IdNotFound;

    List<Printer> find(String search) throws AttributesNotFound, ErrorType;

    List<Printer> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Printer printer);

    List<Printer> findAll();

    List<Printer> findAll(Pageable pageable);
}
