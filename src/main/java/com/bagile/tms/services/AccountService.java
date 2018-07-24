package com.bagile.tms.services;

import com.sinno.ems.dto.Account;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import java.util.List;

public interface AccountService {

    public Account save(Account account);

    public Long size();

    public Boolean isExist(Long id);

    public Account findById(Long id) throws IdNotFound;

    public List<Account> find(String search) throws AttributesNotFound, ErrorType;

    public List<Account> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Account account);

    public List<Account> findAll() throws AttributesNotFound, ErrorType;

    public List<Account> findAll(int page, int size) throws AttributesNotFound, ErrorType;

    public Account loadWmsAccount(com.sinno.wms.crud.modelbasic.accounts.Account account);

    public List<Account> exportWmsAccount(List<Account> account);

    Account login(String code, String password);
}