package com.bagile.gmo.services;

import com.bagile.gmo.dto.ContractAccount;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ContractAccountService {

    ContractAccount save(ContractAccount contractAccount);

    Long size();

    Boolean isExist(Long id);

    ContractAccount findById(Long id) throws IdNotFound;

    ContractAccount findByCode(String code);

    List<ContractAccount> find(String search) throws AttributesNotFound, ErrorType;

    List<ContractAccount> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ContractAccount contractAccount);

    ContractAccount findOne(String search) throws AttributesNotFound, ErrorType;

    List<ContractAccount> findAll() ;

    List<ContractAccount> findAll(int page, int size) ;

    String getNextVal();
}