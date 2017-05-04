package com.sinno.ems.service;

import com.sinno.ems.dto.SaleOrderLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SaleOrderLineService {

    public SaleOrderLine save(SaleOrderLine saleOrderLine) throws ProductControls;

    public Long size();

    public Boolean isExist(Long id);

    public SaleOrderLine findById(Long id) throws IdNotFound;

    public List<SaleOrderLine> find(String search) throws AttributesNotFound, ErrorType;

    public List<SaleOrderLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(SaleOrderLine saleOrderLine);

    public List<SaleOrderLine> findAll();

    public List<SaleOrderLine> findAll(Pageable pageable);

    @Transactional
    SaleOrderLine loadWmsSaleOrderLine(com.sinno.wms.crud.modelbasic.saleorders.SaleOrderLine saleOrderLine);

}