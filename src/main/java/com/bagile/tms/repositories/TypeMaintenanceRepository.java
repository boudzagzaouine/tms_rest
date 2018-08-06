package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsTypeMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TypeMaintenanceRepository extends JpaRepository<TmsTypeMaintenance,Long>,
        QuerydslPredicateExecutor<TmsTypeMaintenance> {
}
