package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpReceptionStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ReceptionStockRepository extends JpaRepository<RcpReceptionStock, Long>,
		QueryDslPredicateExecutor<RcpReceptionStock> {
}