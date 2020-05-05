package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoCommissionDriver;


public interface CommissionDriverRepository extends JpaRepository<GmoCommissionDriver, Long>,
        QuerydslPredicateExecutor<GmoCommissionDriver> {
}
