package com.sinno.ems.service;

import com.sinno.ems.dto.Devis;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 06/12/2016.
 */
public interface DevisService {
    Devis save(Devis devis);

    Long size();

    Boolean isExist(Long id);

    Devis findById(Long id) throws IdNotFound;

    List<Devis> find(String search) throws AttributesNotFound, ErrorType;

    List<Devis> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Devis devis);

    List<Devis> findAll() throws AttributesNotFound, ErrorType;

    List<Devis> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;

    BigInteger getNextVal();
}
