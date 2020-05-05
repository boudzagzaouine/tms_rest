package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoVehicle;


public interface VehicleRepository extends JpaRepository<GmoVehicle,Long>,
        QuerydslPredicateExecutor<GmoVehicle> {
}
