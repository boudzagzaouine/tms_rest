package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface VariableRepository extends JpaRepository<PrmVariable, Long>,
		QueryDslPredicateExecutor<PrmVariable> {
}