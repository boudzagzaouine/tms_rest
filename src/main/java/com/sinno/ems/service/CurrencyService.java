package com.sinno.ems.service;

import com.sinno.ems.dto.Currency;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 22/12/2016.
 */
public interface CurrencyService {
    Currency save(Currency currency);

    Long size();

    Boolean isExist(Long id);

    Currency findById(Long id) throws IdNotFound;

    List<Currency> find(String search) throws AttributesNotFound, ErrorType;

    List<Currency> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Currency currency);

    List<Currency> findAll();

    List<Currency> findAll(Pageable pageable);
}
