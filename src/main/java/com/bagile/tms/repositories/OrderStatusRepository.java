package com.bagile.tms.repositories;

import com.sinno.ems.entities.PrmOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OrderStatusRepository extends JpaRepository<PrmOrderStatus, Long>,
		QueryDslPredicateExecutor<PrmOrderStatus> {
}