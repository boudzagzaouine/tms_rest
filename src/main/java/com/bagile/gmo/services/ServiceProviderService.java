package com.bagile.gmo.services;

import com.bagile.gmo.dto.ServiceProvider;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ServiceProviderService {
    ServiceProvider save(ServiceProvider serviceProvider);

    Long size();

    Boolean isExist(Long id);

    ServiceProvider findById(Long id) throws IdNotFound;

    List<ServiceProvider> find(String search) throws AttributesNotFound, ErrorType;

    List<ServiceProvider> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ServiceProvider serviceProvider);
    void deleteAll(List<Long> ids);
    List<ServiceProvider> findAll();

    List<ServiceProvider> findAll(int page, int size);
}
