package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvInvoice, Long>,
		QueryDslPredicateExecutor<InvInvoice> {
	@Query(value="select nextval('schema_ems.seq_invoice_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();
}