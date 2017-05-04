package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpReceptionLineArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ReceptionLineArcRepository extends JpaRepository<RcpReceptionLineArc, Long>,
		QueryDslPredicateExecutor<RcpReceptionLineArc> {
}