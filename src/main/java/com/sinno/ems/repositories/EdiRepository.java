package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface EdiRepository extends JpaRepository<PrmEdi, Long>,
		QueryDslPredicateExecutor<PrmEdi> {
}