package com.bagile.tms.repositories;

import com.bagile.tms.dto.SaleOrder;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.sinno.ems.dto.Devis;
import com.sinno.ems.dto.SaleOrder;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SaleOrderService {

     SaleOrder save(SaleOrder saleOrder) throws IdNotFound;

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

     List<SaleOrder> findAll(Pageable pageable);
     String getNextVal();
     String getTransfertCode();


    SaleOrder findByCode(String code);

    void updateSaleOrder(SaleOrder saleOrder) throws IdNotFound;

    SaleOrder duplicate(SaleOrder saleOrder) throws IdNotFound, AttributesNotFound, ErrorType;

}