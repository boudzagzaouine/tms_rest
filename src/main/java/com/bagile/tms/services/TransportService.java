package com.bagile.tms.services;

import com.bagile.tms.dto.Transport;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;


public interface TransportService {
    Transport save(Transport transport);

    Long size();

    Boolean isExist(Long id);

    Transport findById(Long id) throws IdNotFound;

    List<Transport> find(String search) throws AttributesNotFound, ErrorType;

    List<Transport> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Transport transport);

    List<Transport> findAll();

    List<Transport> findAll(int page, int size);
}
