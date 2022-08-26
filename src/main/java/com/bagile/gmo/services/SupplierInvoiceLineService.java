package com.bagile.gmo.services;

import com.bagile.gmo.dto.SupplierInvoiceLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 05/12/2016.
 */
public interface SupplierInvoiceLineService {
    SupplierInvoiceLine save(SupplierInvoiceLine paymentSupplier);

    Long size();

    Boolean isExist(Long id);

    SupplierInvoiceLine findById(Long id) throws IdNotFound;

    List<SupplierInvoiceLine> find(String search) throws AttributesNotFound, ErrorType;

    SupplierInvoiceLine findOne(String search) throws AttributesNotFound, ErrorType;

    List<SupplierInvoiceLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SupplierInvoiceLine paymentSupplier);

    List<SupplierInvoiceLine> findAll();

    List<SupplierInvoiceLine> findAll(Pageable pageable);
}
