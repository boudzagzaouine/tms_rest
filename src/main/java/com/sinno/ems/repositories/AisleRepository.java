package com.sinno.ems.repositories;

import com.sinno.ems.entities.LocAisle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AisleRepository extends JpaRepository<LocAisle, Long>,
		QueryDslPredicateExecutor<LocAisle> {
}