package com.bagile.tms.services;

import com.bagile.tms.dto.SaleOrderStock;
import com.bagile.tms.exceptions.*;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleOrderStockService {

    SaleOrderStock save(SaleOrderStock saleOrderStock) throws ProductControls, IdNotFound, CustomException, AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    SaleOrderStock findById(Long id) throws IdNotFound;

    SaleOrderStock findOne(String search) throws AttributesNotFound, ErrorType;

    List<SaleOrderStock> find(String search) throws AttributesNotFound, ErrorType;

    List<SaleOrderStock> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SaleOrderStock saleOrderStock);

    List<SaleOrderStock> findAll();

    List<SaleOrderStock> findAll(int page, int size);

    List<SaleOrderStock> saveAll(List<SaleOrderStock> saleOrderStockList, boolean fromPos);
}