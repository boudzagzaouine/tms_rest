package com.bagile.tms.repositories;

import com.bagile.tms.entities.PrmOrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OrderTypeRepository extends JpaRepository<PrmOrderType, Long>,
		QuerydslPredicateExecutor<PrmOrderType> {
}