package com.bagile.tms.services;

import com.bagile.tms.dto.SaleOrder;
import com.bagile.tms.dto.SaleOrder;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.CustomException;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;


public interface SaleOrderService {
    SaleOrder save(SaleOrder saleOrder);


    Long size();

    Boolean isExist(Long id);

    SaleOrder findById(Long id) throws IdNotFound;

    SaleOrder findOne(String search) throws AttributesNotFound, ErrorType;

    List<SaleOrder> find(String search) throws AttributesNotFound, ErrorType;

    List<SaleOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SaleOrder saleOrder);

    List<SaleOrder> findAll();

    List<SaleOrder> findAll(int page, int size);

    String getNextVal();

   
}
