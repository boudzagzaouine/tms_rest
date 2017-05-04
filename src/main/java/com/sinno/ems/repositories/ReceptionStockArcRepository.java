package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpReceptionStockArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ReceptionStockArcRepository extends JpaRepository<RcpReceptionStockArc, Long>,
		QueryDslPredicateExecutor<RcpReceptionStockArc> {
}