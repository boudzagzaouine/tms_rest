package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsCommissionType;


public interface CommissionTypeRepository extends JpaRepository<TmsCommissionType, Long>,
        QuerydslPredicateExecutor<TmsCommissionType> {
}
