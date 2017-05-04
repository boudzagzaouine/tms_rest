package com.sinno.ems.service;

import com.sinno.ems.dto.SaleOrder;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

public interface SaleOrderService {

    public SaleOrder save(SaleOrder saleOrder);

    public Long size();

    public Boolean isExist(Long id);

    public SaleOrder findById(Long id) throws IdNotFound;

    public List<SaleOrder> find(String search) throws AttributesNotFound, ErrorType;

    public List<SaleOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(SaleOrder saleOrder);

    public List<SaleOrder> findAll();

    public List<SaleOrder> findAll(Pageable pageable);
    public BigInteger getNextVal();
    public String getTransfertCode();

    @Transactional
    SaleOrder loadWmsSaleOrder(com.sinno.wms.crud.modelbasic.saleorders.SaleOrder saleOrder);

}