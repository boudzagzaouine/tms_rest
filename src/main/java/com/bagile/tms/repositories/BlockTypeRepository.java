package com.bagile.tms.repositories;

import com.sinno.ems.entities.PrmBlockType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface BlockTypeRepository extends JpaRepository<PrmBlockType, Long>,
		QueryDslPredicateExecutor<PrmBlockType> {
}