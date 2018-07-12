package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface VariableRepository extends JpaRepository<PrmVariable, Long>,
		QueryDslPredicateExecutor<PrmVariable> {
}