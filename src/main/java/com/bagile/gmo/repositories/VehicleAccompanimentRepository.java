package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsAccountPricing;
import com.bagile.gmo.entities.TmsVehicleAccompaniment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface VehicleAccompanimentRepository extends JpaRepository<TmsVehicleAccompaniment,Long>,
        QuerydslPredicateExecutor<TmsVehicleAccompaniment> {

 
}