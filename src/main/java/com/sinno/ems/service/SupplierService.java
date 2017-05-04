package com.sinno.ems.service;

import com.sinno.ems.dto.Supplier;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import java.util.List;

public interface SupplierService {

    public Supplier save(Supplier supplier);

    public Long size();

    public Boolean isExist(Long id);

    public Supplier findById(Long id) throws IdNotFound;

    public List<Supplier> find(String search) throws AttributesNotFound, ErrorType;

    public List<Supplier> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Supplier supplier);

    public List<Supplier> findAll() throws AttributesNotFound, ErrorType;

    public List<Supplier> findAll(int page, int size) throws AttributesNotFound, ErrorType;

    public Supplier loadWmsSupplier(com.sinno.wms.crud.modelbasic.suppliers.Supplier supplier);

    List<Supplier> exportWmsSupplier(List<Supplier> suppliers);
}