package com.bagile.gmo.services;

import com.bagile.gmo.dto.SupplierInvoicePurchaseOrder;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SupplierInvoicePurchaseOrderService {
    SupplierInvoicePurchaseOrder save(SupplierInvoicePurchaseOrder deliveryInvoicePurchaseOrder);

    SupplierInvoicePurchaseOrder findOne(String search) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    SupplierInvoicePurchaseOrder findById(Long id) throws IdNotFound;

    List<SupplierInvoicePurchaseOrder> find(String search) throws AttributesNotFound, ErrorType;

    List<SupplierInvoicePurchaseOrder> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SupplierInvoicePurchaseOrder deliveryInvoicePurchaseOrder);

    List<SupplierInvoicePurchaseOrder> findAll();

    List<SupplierInvoicePurchaseOrder> findAll(Pageable pageable);
}
