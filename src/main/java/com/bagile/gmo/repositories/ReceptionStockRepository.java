package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.RcpReceptionStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ReceptionStockRepository extends JpaRepository<RcpReceptionStock, Long>,
		QuerydslPredicateExecutor<RcpReceptionStock> {
}