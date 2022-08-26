package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.InvSupplierInvoiceReception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface SupplierInvoiceReceptionRepository extends JpaRepository<InvSupplierInvoiceReception,Long>
        , QuerydslPredicateExecutor<InvSupplierInvoiceReception> {

}
