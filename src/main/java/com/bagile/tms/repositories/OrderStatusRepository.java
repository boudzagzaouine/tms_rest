package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.PrmOrderStatus;

public interface OrderStatusRepository extends JpaRepository<PrmOrderStatus, Long>,
		QuerydslPredicateExecutor<PrmOrderStatus> {
}