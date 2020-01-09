package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsCommission;
import com.bagile.tms.entities.TmsCommissionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface CommissionTypeRepository extends JpaRepository<TmsCommissionType, Long>,
        QuerydslPredicateExecutor<TmsCommissionType> {
}
