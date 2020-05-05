package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoCommissionType;
import com.bagile.gmo.entities.GmoInsuranceType;


public interface InsuranceTypeRepository extends JpaRepository<GmoInsuranceType, Long>,
        QuerydslPredicateExecutor<GmoInsuranceType> {
}
