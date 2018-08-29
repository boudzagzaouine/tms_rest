package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsVehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface VehicleCategoryRepository extends JpaRepository<TmsVehicleCategory, Long>,
        QuerydslPredicateExecutor<TmsVehicleCategory> {
}
