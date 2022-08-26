package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.InvSupplierInvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by Enissay on 05/12/2016.
 */
public interface SupplierInvoiceLineRepository extends JpaRepository<InvSupplierInvoiceLine, Long>
        , QuerydslPredicateExecutor<InvSupplierInvoiceLine> {
}
