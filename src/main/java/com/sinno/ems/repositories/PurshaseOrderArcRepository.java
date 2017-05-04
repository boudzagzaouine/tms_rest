package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpPurshaseOrderArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface PurshaseOrderArcRepository extends JpaRepository<RcpPurshaseOrderArc, Long>,
		QueryDslPredicateExecutor<RcpPurshaseOrderArc> {
}