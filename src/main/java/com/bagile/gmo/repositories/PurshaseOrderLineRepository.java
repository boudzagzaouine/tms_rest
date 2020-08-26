package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.RcpPurshaseOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PurshaseOrderLineRepository extends JpaRepository<RcpPurshaseOrderLine, Long>,
		QuerydslPredicateExecutor<RcpPurshaseOrderLine> {

}