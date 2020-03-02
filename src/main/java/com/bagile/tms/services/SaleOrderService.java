package com.bagile.tms.services;

import com.bagile.tms.dto.SaleOrder;
import com.bagile.tms.dto.SaleOrderLine;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.CustomException;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface SaleOrderService {

     SaleOrder save(SaleOrder saleOrder) throws IdNotFound, CustomException;

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
     String getTransfertCode();

    @Transactional
    SaleOrder loadWmsSaleOrder(SaleOrder saleOrder) throws IdNotFound, CustomException;

    void calculateAllLines(SaleOrder saleOrder, Collection<SaleOrderLine> lines);

    SaleOrder findByCode(String code);

    SaleOrder updateSaleOrder(SaleOrder saleOrder) throws IdNotFound, CustomException;

    void updatePaymentStatus(SaleOrder saleOrder) throws IdNotFound, CustomException;

    SaleOrder duplicate(SaleOrder saleOrder) throws IdNotFound, AttributesNotFound, ErrorType, CustomException;


    SaleOrder cancelSaleOrder(SaleOrder saleOrder) throws AttributesNotFound, ErrorType, IdNotFound, CustomException, IOException;

    @Transactional
    SaleOrder close(SaleOrder saleOrder) throws AttributesNotFound, ErrorType, IdNotFound, CustomException;
}