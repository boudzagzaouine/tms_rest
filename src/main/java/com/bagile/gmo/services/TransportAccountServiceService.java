package com.bagile.gmo.services;

import com.bagile.gmo.dto.TransportAccountService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface TransportAccountServiceService {
    TransportAccountService save(TransportAccountService transportAccountServiceService);
    List<TransportAccountService> saveAll(List<TransportAccountService> transportAccountServiceServices) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    TransportAccountService findById(Long id) throws IdNotFound;

    List<TransportAccountService> find(String search) throws AttributesNotFound, ErrorType;

    List<TransportAccountService> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TransportAccountService transportAccountServiceService);
    void deleteAll (List<Long> ids);

    List<TransportAccountService> findAll();

    List<TransportAccountService> findAll(int page, int size);

	TransportAccountService findOne(String search) throws AttributesNotFound, ErrorType;

}
