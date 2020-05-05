package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoVehicleCategory;

public interface VehicleCategoryRepository extends JpaRepository<GmoVehicleCategory, Long>,
        QuerydslPredicateExecutor<GmoVehicleCategory> {
}
