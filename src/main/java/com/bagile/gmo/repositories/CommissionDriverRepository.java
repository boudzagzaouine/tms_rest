package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsCommissionDriver;


public interface CommissionDriverRepository extends JpaRepository<TmsCommissionDriver, Long>,
        QuerydslPredicateExecutor<TmsCommissionDriver> {
}
