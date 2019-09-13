package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsMaintenanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface MaintenanceTypeRepository extends JpaRepository<TmsMaintenanceType,Long>,
        QuerydslPredicateExecutor<TmsMaintenanceType> {
}
