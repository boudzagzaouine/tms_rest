package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoMaintenancePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MaintenancePlanRepository extends JpaRepository<GmoMaintenancePlan,Long>,
        QuerydslPredicateExecutor<GmoMaintenancePlan> {
}