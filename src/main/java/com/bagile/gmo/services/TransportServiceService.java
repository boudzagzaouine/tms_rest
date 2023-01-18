package com.bagile.gmo.services;

import com.bagile.gmo.dto.TransportService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface TransportServiceService {
    TransportService save(TransportService transportServiceService);
    List<TransportService> saveAll(List<TransportService> transportServiceServices) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    TransportService findById(Long id) throws IdNotFound;

    List<TransportService> find(String search) throws AttributesNotFound, ErrorType;

    List<TransportService> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TransportService transportServiceService);
    void deleteAll (List<Long> ids);

    List<TransportService> findAll();

    List<TransportService> findAll(int page, int size);

	TransportService findOne(String search) throws AttributesNotFound, ErrorType;

}
