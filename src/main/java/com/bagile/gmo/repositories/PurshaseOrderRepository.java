package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.RcpPurshaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface PurshaseOrderRepository extends JpaRepository<RcpPurshaseOrder, Long>,
		QuerydslPredicateExecutor<RcpPurshaseOrder> {
	@Query(value="select nextval('schema_emsgc.seq_purchase_order_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();

}