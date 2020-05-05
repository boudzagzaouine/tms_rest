package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoMaintenanceType;


public interface MaintenanceTypeRepository extends JpaRepository<GmoMaintenanceType,Long>,
        QuerydslPredicateExecutor<GmoMaintenanceType> {
}
