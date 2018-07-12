package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 15/12/2016.
 */
public interface PaymentSupplierInvoiceRepository extends JpaRepository<InvPaymentSupplierInvoice,Long>,QueryDslPredicateExecutor<InvPaymentSupplierInvoice> {
}
