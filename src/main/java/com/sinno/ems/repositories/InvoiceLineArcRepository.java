package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvInvoiceLineArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface InvoiceLineArcRepository extends JpaRepository<InvInvoiceLineArc, Long>,
		QueryDslPredicateExecutor<InvInvoiceLineArc> {
}