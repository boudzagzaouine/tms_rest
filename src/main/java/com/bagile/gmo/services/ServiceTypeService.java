package com.bagile.gmo.services;

import com.bagile.gmo.dto.ServiceType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ServiceTypeService {
    ServiceType save(ServiceType serviceType);

    Long size();

    Boolean isExist(Long id);

    ServiceType findById(Long id) throws IdNotFound;

    List<ServiceType> find(String search) throws AttributesNotFound, ErrorType;

    List<ServiceType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ServiceType serviceType);
    void deleteAll (List<Long> ids);

    List<ServiceType> findAll();

    List<ServiceType> findAll(int page, int size);

	ServiceType findOne(String search) throws AttributesNotFound, ErrorType;

}
