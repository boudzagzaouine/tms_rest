package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoMaintenancePlan;


public interface MaintenancePlanRepository extends JpaRepository<GmoMaintenancePlan,Long>,
        QuerydslPredicateExecutor<GmoMaintenancePlan>{

}
