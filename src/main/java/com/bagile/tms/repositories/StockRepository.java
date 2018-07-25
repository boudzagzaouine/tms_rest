package com.bagile.tms.repositories;

import com.bagile.tms.entities.StkStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StockRepository extends JpaRepository<StkStock, Long>,
		QuerydslPredicateExecutor<StkStock> {
}