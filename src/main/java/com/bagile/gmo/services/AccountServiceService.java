package com.bagile.gmo.services;

import com.bagile.gmo.dto.AccountService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface AccountServiceService {
    AccountService save(AccountService accopuntServiceService);
    List<AccountService> saveAll(List<AccountService> accopuntServiceServices) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    AccountService findById(Long id) throws IdNotFound;

    List<AccountService> find(String search) throws AttributesNotFound, ErrorType;

    List<AccountService> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(AccountService accopuntServiceService);
    void deleteAll (List<Long> ids);

    List<AccountService> findAll();

    List<AccountService> findAll(int page, int size);

	AccountService findOne(String search) throws AttributesNotFound, ErrorType;

}
