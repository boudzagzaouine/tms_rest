package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface PurshaseOrderService {

    public PurshaseOrder save(PurshaseOrder purshaseOrder);

    public Long size();

    public Boolean isExist(Long id);

    public PurshaseOrder findById(Long id) throws IdNotFound;

    public List<PurshaseOrder> find(String search) throws AttributesNotFound, ErrorType;

    public List<PurshaseOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(PurshaseOrder purshaseOrder);

    public List<PurshaseOrder> findAll();

    public List<PurshaseOrder> findAll(Pageable pageable);

   public BigInteger getNextVal();
    public String getTransfertCode();
}