package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdSaleOrderArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SaleOrderArcRepository extends JpaRepository<CmdSaleOrderArc, Long>,
		QueryDslPredicateExecutor<CmdSaleOrderArc> {
}