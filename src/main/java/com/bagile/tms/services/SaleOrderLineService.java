package com.bagile.tms.services;


import com.bagile.tms.dto.SaleOrderLine;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.exceptions.ProductControls;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface SaleOrderLineService {

    SaleOrderLine save(SaleOrderLine saleOrderLine) throws ProductControls;

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

    List<SaleOrderLine> findAll(Pageable pageable);

    void updateSaleOrderLine(SaleOrderLine saleOrderLine, BigDecimal quantiyServed);
    
}