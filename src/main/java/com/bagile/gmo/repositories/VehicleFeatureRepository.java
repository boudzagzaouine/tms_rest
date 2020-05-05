package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoBadge;
import com.bagile.gmo.entities.GmoVehicleFeature;

public interface VehicleFeatureRepository extends JpaRepository<GmoVehicleFeature,Long>,
        QuerydslPredicateExecutor<GmoVehicleFeature> {
}