package com.bagile.gmo.services;

import com.bagile.gmo.dto.SaleOrder;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface SaleOrderService {
    SaleOrder save(SaleOrder saleOrder);


    Long size() throws AttributesNotFound, ErrorType;

    Boolean isExist(Long id);

    SaleOrder findById(Long id) throws IdNotFound;

    SaleOrder findOne(String search) throws AttributesNotFound, ErrorType;

    List<SaleOrder> find(String search) throws AttributesNotFound, ErrorType;

    List<SaleOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SaleOrder saleOrder);

    List<SaleOrder> findAll();

    List<SaleOrder> findAll(int page, int size) throws AttributesNotFound, ErrorType;

    String getNextVal();

   
}
