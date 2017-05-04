package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ColumnRepository extends JpaRepository<PrmColumn, Long>,
		QueryDslPredicateExecutor<PrmColumn> {
}