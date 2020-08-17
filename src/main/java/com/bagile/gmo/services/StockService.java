package com.bagile.gmo.services;

import com.bagile.gmo.dto.Stock;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface StockService {
    Stock save(Stock stock);

    Long size();

    Boolean isExist(Long id);

    Stock findById(Long id) throws IdNotFound;

    List<Stock> find(String search) throws AttributesNotFound, ErrorType;

    List<Stock> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Stock stock);
    void deleteAll(List<Long> ids);
    List<Stock> findAll();

    List<Stock> findAll(int page, int size);
}
