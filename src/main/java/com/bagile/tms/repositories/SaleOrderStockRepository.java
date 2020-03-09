package com.bagile.tms.repositories;

import com.bagile.tms.entities.CmdSaleOrderStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SaleOrderStockRepository extends JpaRepository<CmdSaleOrderStock, Long>,
		QuerydslPredicateExecutor<CmdSaleOrderStock> {
}