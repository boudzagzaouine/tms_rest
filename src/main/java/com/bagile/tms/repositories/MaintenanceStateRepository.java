package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsMaintenanceState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MaintenanceStateRepository extends JpaRepository<TmsMaintenanceState,Long>,
        QuerydslPredicateExecutor<TmsMaintenanceState> {
}
