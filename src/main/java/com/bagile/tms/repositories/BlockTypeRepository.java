package com.bagile.tms.repositories;

import com.bagile.tms.entities.PrmBlockType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BlockTypeRepository extends JpaRepository<PrmBlockType, Long>,
		QuerydslPredicateExecutor<PrmBlockType> {
}