package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockReservedService {

    public StockReserved save(StockReserved stockReserved);

    public Long size();

    public Boolean isExist(Long id);

    public StockReserved findById(Long id) throws IdNotFound;

    public List<StockReserved> find(String search) throws AttributesNotFound, ErrorType;

    public List<StockReserved> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(StockReserved stockReserved);

    public List<StockReserved> findAll();

    public List<StockReserved> findAll(Pageable pageable);
}