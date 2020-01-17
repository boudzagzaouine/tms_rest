package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsCommissionType;
import com.bagile.tms.entities.TmsInsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface InsuranceTypeRepository extends JpaRepository<TmsInsuranceType, Long>,
        QuerydslPredicateExecutor<TmsInsuranceType> {
}
