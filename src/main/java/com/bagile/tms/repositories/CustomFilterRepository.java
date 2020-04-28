package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.tms.entities.FltrCustomFilter;

public interface CustomFilterRepository extends JpaRepository<FltrCustomFilter, Long>,
        QuerydslPredicateExecutor<FltrCustomFilter> {

}