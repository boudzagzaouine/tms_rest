package com.bagile.tms.services;

import com.bagile.tms.dto.Account;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface AccountService {

    public Account save(Account account);

    public Long size();

    public Boolean isExist(Long id);

    public Account findById(Long id) throws IdNotFound;

    Account findOne(String search) throws AttributesNotFound, ErrorType;

    public List<Account> find(String search) throws AttributesNotFound, ErrorType;

    public List<Account> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Account account);

    public List<Account> findAll() throws AttributesNotFound, ErrorType;

    public List<Account> findAll(int page, int size) throws AttributesNotFound, ErrorType;

}