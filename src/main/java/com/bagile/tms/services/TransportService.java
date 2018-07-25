package com.bagile.tms.services;

import com.bagile.tms.dto.Transport;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface TransportService {

    public Transport save(Transport transport);

    public Long size();

    public Boolean isExist(Long id);

    public Transport findById(Long id) throws IdNotFound;

    public List<Transport> find(String search) throws AttributesNotFound, ErrorType;

    public List<Transport> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Transport transport);

    public List<Transport> findAll();

    public List<Transport> findAll(int page, int size) throws AttributesNotFound, ErrorType;

}