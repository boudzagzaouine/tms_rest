package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpPurshaseOrderLineArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface PurshaseOrderLineArcRepository extends JpaRepository<RcpPurshaseOrderLineArc, Long>,
		QueryDslPredicateExecutor<RcpPurshaseOrderLineArc> {
}