package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SupplierRepository extends JpaRepository<RcpSupplier, Long>,
		QueryDslPredicateExecutor<RcpSupplier> {
	public RcpSupplier findByRcpSupplierCode(String RcpSupplierCode);
}