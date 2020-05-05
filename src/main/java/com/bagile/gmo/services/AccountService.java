package com.bagile.gmo.services;

import com.bagile.gmo.dto.Account;
import com.bagile.gmo.dto.Badge;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

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

    List<Account> findAll() ;

    List<Account> findAll(int page, int size) ;

    String getNextVal();
}