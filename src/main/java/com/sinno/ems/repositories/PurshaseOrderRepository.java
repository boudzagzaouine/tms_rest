package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpPurshaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface PurshaseOrderRepository extends JpaRepository<RcpPurshaseOrder, Long>,
		QueryDslPredicateExecutor<RcpPurshaseOrder> {
	@Query(value="select nextval('schema_ems.seq_purchase_order_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();

	@Query(value = "select nextval('schema_ems.seq_code_transfert')",nativeQuery = true)
	public List<BigInteger> getTransferCode();
}