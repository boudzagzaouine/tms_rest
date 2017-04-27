package com.sinno.ems.repositories;

import com.sinno.ems.entities.TmsVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by bouzi on 3/27/2017.
 * QueryDslPredicateExecutor
 */
public interface VehicleRepository extends JpaRepository <TmsVehicle,Long>,
        QueryDslPredicateExecutor<TmsVehicle> {
}
