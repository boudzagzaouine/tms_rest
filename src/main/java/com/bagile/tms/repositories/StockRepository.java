package com.bagile.tms.repositories;

import com.sinno.ems.entities.StkStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface StockRepository extends JpaRepository<StkStock, Long>,
		QueryDslPredicateExecutor<StkStock> {
}