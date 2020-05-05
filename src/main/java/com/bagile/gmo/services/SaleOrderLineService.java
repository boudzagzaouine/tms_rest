package com.bagile.gmo.services;

import com.bagile.gmo.dto.SaleOrderLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface SaleOrderLineService {
    SaleOrderLine save(SaleOrderLine saleOrderLine);
    List<SaleOrderLine> updateAll(List<SaleOrderLine> saleOrderLines);


    Long size();

    Boolean isExist(Long id);

    SaleOrderLine findById(Long id) throws IdNotFound;

    SaleOrderLine findOne(String search) throws AttributesNotFound, ErrorType;

    List<SaleOrderLine> find(String search) throws AttributesNotFound, ErrorType;

    List<SaleOrderLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SaleOrderLine saleOrderLine);

    List<SaleOrderLine> findAll();

    List<SaleOrderLine> findAll(int page, int size);

    String getNextVal();

   
}
