package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.CmdSaleOrderLine;

public interface SaleOrderLineRepository extends JpaRepository<CmdSaleOrderLine, Long>,
		QuerydslPredicateExecutor<CmdSaleOrderLine> {

}