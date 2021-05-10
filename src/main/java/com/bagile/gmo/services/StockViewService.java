package com.bagile.gmo.services;

import com.bagile.gmo.dto.StockView;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.CustomException;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface StockViewService {

    StockView save(StockView stockView) throws IdNotFound, CustomException, AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    StockView findById(Long id) throws IdNotFound;

    StockView findOne(String search) throws AttributesNotFound, ErrorType;

    List<StockView> find(String search) throws AttributesNotFound, ErrorType;

    List<StockView> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id) throws IdNotFound;

    void delete(StockView stockView);
    void deleteAll(List<Long> ids);

    List<StockView> findAll() throws AttributesNotFound, ErrorType;

    List<StockView> findAll(int page, int size) throws AttributesNotFound, ErrorType;



}