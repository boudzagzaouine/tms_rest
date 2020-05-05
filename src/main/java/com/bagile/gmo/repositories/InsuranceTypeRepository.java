package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsCommissionType;
import com.bagile.gmo.entities.TmsInsuranceType;


public interface InsuranceTypeRepository extends JpaRepository<TmsInsuranceType, Long>,
        QuerydslPredicateExecutor<TmsInsuranceType> {
}
