package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsBadge;
import com.bagile.tms.entities.TmsVehicleFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface VehicleFeatureRepository extends JpaRepository<TmsVehicleFeature,Long>,
        QuerydslPredicateExecutor<TmsVehicleFeature> {
}