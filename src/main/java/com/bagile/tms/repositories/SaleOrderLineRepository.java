package com.bagile.tms.repositories;

import com.bagile.tms.entities.CmdSaleOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SaleOrderLineRepository extends JpaRepository<CmdSaleOrderLine, Long>,
		QuerydslPredicateExecutor<CmdSaleOrderLine> {

}