package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpReceptionArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ReceptionArcRepository extends JpaRepository<RcpReceptionArc, Long>,
		QueryDslPredicateExecutor<RcpReceptionArc> {
}