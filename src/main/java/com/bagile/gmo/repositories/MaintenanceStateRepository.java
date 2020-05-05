package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoMaintenanceState;

public interface MaintenanceStateRepository extends JpaRepository<GmoMaintenanceState,Long>,
        QuerydslPredicateExecutor<GmoMaintenanceState> {
}
