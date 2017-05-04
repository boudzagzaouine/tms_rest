package com.sinno.ems.service;

import com.sinno.ems.dto.SupplierLitigation;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface SupplierLitigationService {
    public SupplierLitigation save(com.sinno.ems.dto.SupplierLitigation supplierLitigation);

    public Long size();

    public Boolean isExist(Long id);

    public SupplierLitigation findById(Long id) throws IdNotFound;

    public List<SupplierLitigation> find(String search) throws AttributesNotFound, ErrorType;

    List<SupplierLitigation> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(SupplierLitigation actions);

    public List<SupplierLitigation> findAll();

    public List<SupplierLitigation> findAll(Pageable pageable);
}
