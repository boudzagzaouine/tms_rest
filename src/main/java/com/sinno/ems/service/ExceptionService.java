package com.sinno.ems.service;

import com.sinno.ems.dto.Exception;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import java.util.List;

public interface ExceptionService {

    public Exception save(Exception exception);

    public Long size();

    public Boolean isExist(Long id);

    public Exception findById(Long id) throws IdNotFound;

    public List<Exception> find(String search) throws AttributesNotFound, ErrorType;

    public List<Exception> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Exception exception);

    public List<Exception> findAll() throws AttributesNotFound, ErrorType;

    public List<Exception> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}