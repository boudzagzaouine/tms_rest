package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.CmdSaleOrderStock;

public interface SaleOrderStockRepository extends JpaRepository<CmdSaleOrderStock, Long>,
		QuerydslPredicateExecutor<CmdSaleOrderStock> {
}