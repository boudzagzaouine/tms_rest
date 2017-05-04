package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvInvoiceRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface InvoiceRulesRepository extends JpaRepository<InvInvoiceRules, Long>,
		QueryDslPredicateExecutor<InvInvoiceRules> {
}