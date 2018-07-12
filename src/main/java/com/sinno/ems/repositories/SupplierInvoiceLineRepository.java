package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 05/12/2016.
 */
public interface SupplierInvoiceLineRepository extends JpaRepository<InvSupplierInvoiceLine, Long>, QueryDslPredicateExecutor<InvSupplierInvoiceLine> {
}
