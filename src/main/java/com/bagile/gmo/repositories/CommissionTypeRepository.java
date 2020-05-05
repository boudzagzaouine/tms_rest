package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoCommissionType;


public interface CommissionTypeRepository extends JpaRepository<GmoCommissionType, Long>,
        QuerydslPredicateExecutor<GmoCommissionType> {
}
