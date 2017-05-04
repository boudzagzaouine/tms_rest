package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdSaleOrderStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SaleOrderStockRepository extends JpaRepository<CmdSaleOrderStock, Long>,
		QueryDslPredicateExecutor<CmdSaleOrderStock> {
}