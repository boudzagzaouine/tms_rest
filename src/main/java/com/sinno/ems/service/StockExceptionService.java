package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by ASMAE on 27/04/2016.
 */
public interface StockExceptionService {
    public StockException save(StockException stockException);

    public Long size();

    public Boolean isExist(Long id);

    public StockException findById(Long id) throws IdNotFound;

    public List<StockException> find(String search) throws AttributesNotFound, ErrorType;

    public List<StockException> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(StockException stockException);

    public List<StockException> findAll() throws AttributesNotFound, ErrorType;

    public List<StockException> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;

}
