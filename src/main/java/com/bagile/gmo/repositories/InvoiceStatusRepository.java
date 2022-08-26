package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.PrmInvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface InvoiceStatusRepository extends JpaRepository<PrmInvoiceStatus, Long>,
		QuerydslPredicateExecutor<PrmInvoiceStatus> {
}