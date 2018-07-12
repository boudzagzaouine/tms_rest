package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BankService {

    Bank save(Bank bank);

    Long size();

    Boolean isExist(Long id);

    Bank findById(Long id) throws IdNotFound;

    List<Bank> find(String search) throws AttributesNotFound, ErrorType;

    List<Bank> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Bank bank);

    List<Bank> findAll();

    List<Bank> findAll(Pageable pageable);
}