package com.bagile.tms.services;

import com.bagile.tms.dto.Account;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface AccountService {

    Account save(Account account);

    Long size();

    Boolean isExist(Long id);

    Account findById(Long id) throws IdNotFound;

    Account findByCode(String code);

    List<Account> find(String search) throws AttributesNotFound, ErrorType;

    List<Account> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Account account);

    Account findOne(String search) throws AttributesNotFound, ErrorType;

    List<Account> findAll() throws AttributesNotFound, ErrorType;

    List<Account> findAll(int page, int size) throws AttributesNotFound, ErrorType;

    Account loadWmsAccount(Account account);

    List<Account> exportWmsAccount(List<Account> account);

    Account login(String code, String password);

    String getNextVal();
}