package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmOrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OrderTypeRepository extends JpaRepository<PrmOrderType, Long>,
		QueryDslPredicateExecutor<PrmOrderType> {
}