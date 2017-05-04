package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvInvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface InvoiceLineRepository extends JpaRepository<InvInvoiceLine, Long>,
		QueryDslPredicateExecutor<InvInvoiceLine> {
}