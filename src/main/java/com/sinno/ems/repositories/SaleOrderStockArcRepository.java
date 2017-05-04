package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdSaleOrderStockArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SaleOrderStockArcRepository extends JpaRepository<CmdSaleOrderStockArc, Long>,
		QueryDslPredicateExecutor<CmdSaleOrderStockArc> {
}