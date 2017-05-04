package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmInvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface InvoiceStatusRepository extends JpaRepository<PrmInvoiceStatus, Long>,
		QueryDslPredicateExecutor<PrmInvoiceStatus> {
}