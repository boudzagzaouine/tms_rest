package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvInvoiceArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface InvoiceArcRepository extends JpaRepository<InvInvoiceArc, Long>,
		QueryDslPredicateExecutor<InvInvoiceArc> {
}