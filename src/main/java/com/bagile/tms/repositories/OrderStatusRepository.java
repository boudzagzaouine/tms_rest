package com.bagile.tms.repositories;

import com.bagile.tms.entities.PrmOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OrderStatusRepository extends JpaRepository<PrmOrderStatus, Long>,
		QuerydslPredicateExecutor<PrmOrderStatus> {
}