package com.bagile.tms.services;

import com.sinno.ems.dto.Transport;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

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

    Transport loadWmsTransport(com.sinno.wms.crud.modelbasic.carriers.Carrier carrier);

    List<Transport> exportWmsTransport(List<Transport> transports);
}