package com.bagile.gmo.services;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.importModels.AddressDelivery;

import java.util.List;

public interface AddressService {

    Address save(Address address);
    List<Address> saveAll(List<Address> addresses) throws AttributesNotFound, ErrorType;


    Long size();

    Boolean isExist(Long id);

    Address findById(Long id) throws IdNotFound;

    Address findByCode(String code);

    List<Address> find(String search) throws AttributesNotFound, ErrorType;

    List<Address> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Address address);
    void deleteAll (List<Long> ids);
    Address findOne(String search) throws AttributesNotFound, ErrorType;

    List<Address> findAll() ;

    List<Address> findAll(int page, int size) ;

    String getNextVal();

    List<AddressDelivery> loadingDataImport(List<AddressDelivery> addressDelivery) throws ErrorType, AttributesNotFound, IdNotFound;
}