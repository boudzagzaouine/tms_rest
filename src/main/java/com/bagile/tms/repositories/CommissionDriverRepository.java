package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsCommissionDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface CommissionDriverRepository extends JpaRepository<TmsCommissionDriver, Long>,
        QuerydslPredicateExecutor<TmsCommissionDriver> {
}
