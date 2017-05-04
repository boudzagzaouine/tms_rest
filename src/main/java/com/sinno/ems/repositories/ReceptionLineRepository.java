package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpReceptionLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ReceptionLineRepository extends JpaRepository<RcpReceptionLine, Long>,
		QueryDslPredicateExecutor<RcpReceptionLine> {
}