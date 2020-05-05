package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.PrmOrderType;

public interface OrderTypeRepository extends JpaRepository<PrmOrderType, Long>,
		QuerydslPredicateExecutor<PrmOrderType> {
}