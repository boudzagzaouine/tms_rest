package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.PrmBlockType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BlockTypeRepository extends JpaRepository<PrmBlockType, Long>,
		QuerydslPredicateExecutor<PrmBlockType> {
}