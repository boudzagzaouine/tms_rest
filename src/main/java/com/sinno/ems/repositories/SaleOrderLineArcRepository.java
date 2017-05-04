package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdSaleOrderLineArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SaleOrderLineArcRepository extends JpaRepository<CmdSaleOrderLineArc, Long>,
		QueryDslPredicateExecutor<CmdSaleOrderLineArc> {
}