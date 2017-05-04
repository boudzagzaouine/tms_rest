package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpPurshaseOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface PurshaseOrderLineRepository extends JpaRepository<RcpPurshaseOrderLine, Long>,
		QueryDslPredicateExecutor<RcpPurshaseOrderLine> {
}