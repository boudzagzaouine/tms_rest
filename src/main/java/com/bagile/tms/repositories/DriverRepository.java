package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoDriver;


public interface DriverRepository extends JpaRepository<GmoDriver, Long>,
        QuerydslPredicateExecutor<GmoDriver> {
}
