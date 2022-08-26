package com.bagile.gmo.services;

import com.bagile.gmo.dto.PurshaseOrder;
import com.bagile.gmo.dto.SupplierInvoice;
import com.bagile.gmo.exceptions.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface SupplierInvoiceService {
    SupplierInvoice save(SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException;

    Long size();

    Boolean isExist(Long id);

    SupplierInvoice findById(Long id) throws IdNotFound;

    List<SupplierInvoice> find(String search) throws AttributesNotFound, ErrorType;

    SupplierInvoice findOne(String search) throws AttributesNotFound, ErrorType;

    List<SupplierInvoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id) throws IdNotFound;

    void delete(SupplierInvoice actions);

    List<SupplierInvoice> findAll();

    List<SupplierInvoice> findAll(Pageable pageable);

    String getNextVal();

    SupplierInvoice generateSupplierInvoice(PurshaseOrder purshaseOrder) throws IdNotFound, AttributesNotFound, ErrorType, CustomException;

    //SupplierInvoice generateSupplierInvoice(BillingTermPurshase billingTermPurshase) throws IdNotFound, CustomException, AttributesNotFound, ErrorType;

    SupplierInvoice merge(SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException;

    SupplierInvoice generateSupplierInvoiceFromReceptions(SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException, ProductControls, ContainerException;

    SupplierInvoice generateSupplierInvoiceFromOrders(SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException;
}
