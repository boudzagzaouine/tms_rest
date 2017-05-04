package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmEdi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface EdiRepository extends JpaRepository<PrmEdi, Long>,
		QueryDslPredicateExecutor<PrmEdi> {
}