package com.sinno.ems.service;

import com.sinno.ems.dto.Wallet;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WalletService {

    Wallet save(Wallet wallet);

    Long size();

    Boolean isExist(Long id);

    Wallet findById(Long id) throws IdNotFound;

    List<Wallet> find(String search) throws AttributesNotFound, ErrorType;

    List<Wallet> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Wallet wallet);

    List<Wallet> findAll();

    List<Wallet> findAll(Pageable pageable);
}