package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsCommission;
import com.bagile.tms.entities.TmsDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface CommissionRepository extends JpaRepository<TmsCommission, Long>,
        QuerydslPredicateExecutor<TmsCommission> {
}
