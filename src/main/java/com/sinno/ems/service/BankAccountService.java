package com.sinno.ems.service;

import com.sinno.ems.dto.BankAccount;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BankAccountService {

    BankAccount save(BankAccount bankAccount);

    Long size();

    Boolean isExist(Long id);

    BankAccount findById(Long id) throws IdNotFound;

    List<BankAccount> find(String search) throws AttributesNotFound, ErrorType;

    List<BankAccount> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(BankAccount bankAccount);

    List<BankAccount> findAll();

    List<BankAccount> findAll(Pageable pageable);
}