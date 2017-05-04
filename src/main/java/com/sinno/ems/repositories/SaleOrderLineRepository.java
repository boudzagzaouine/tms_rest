package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdSaleOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SaleOrderLineRepository extends JpaRepository<CmdSaleOrderLine, Long>,
		QueryDslPredicateExecutor<CmdSaleOrderLine> {

}