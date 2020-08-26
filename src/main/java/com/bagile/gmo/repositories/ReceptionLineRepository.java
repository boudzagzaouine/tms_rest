package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.RcpReceptionLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ReceptionLineRepository extends JpaRepository<RcpReceptionLine, Long>,
		QuerydslPredicateExecutor<RcpReceptionLine> {
}