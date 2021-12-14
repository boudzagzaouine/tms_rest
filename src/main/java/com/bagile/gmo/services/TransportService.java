package com.bagile.gmo.services;

import com.bagile.gmo.dto.Transport;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface TransportService {
    Transport save(Transport transport);

    Long size() throws AttributesNotFound, ErrorType;

    Boolean isExist(Long id);

    Transport findById(Long id) throws IdNotFound;

    List<Transport> find(String search) throws AttributesNotFound, ErrorType;

    List<Transport> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Transport transport);
    void deleteAll (List<Long> ids);

    List<Transport> findAll() throws AttributesNotFound, ErrorType;

    List<Transport> findAll(int page, int size) throws AttributesNotFound, ErrorType;
    String getNextVal();
}
