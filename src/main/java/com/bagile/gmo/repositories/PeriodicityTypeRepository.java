package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoPeriodicityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PeriodicityTypeRepository extends JpaRepository<GmoPeriodicityType,Long>,
        QuerydslPredicateExecutor<GmoPeriodicityType> {
}