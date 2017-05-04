package com.sinno.ems.service;

import com.sinno.ems.dto.Vat;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 22/12/2016.
 */
public interface VatService {
    Vat save(Vat vat);

    Long size();

    Boolean isExist(Long id);

    Vat findById(Long id) throws IdNotFound;

    List<Vat> find(String search) throws AttributesNotFound, ErrorType;

    List<Vat> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Vat vat);

    List<Vat> findAll();

    List<Vat> findAll(Pageable pageable);
}
