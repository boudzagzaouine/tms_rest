package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface VehicleRepository extends JpaRepository<TmsVehicle,Long>,
        QuerydslPredicateExecutor<TmsVehicle> {
}
