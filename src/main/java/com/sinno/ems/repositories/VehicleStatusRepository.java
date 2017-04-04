package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmVehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by bouzi on 3/27/2017.
 */
public interface VehicleStatusRepository extends JpaRepository <PrmVehicleStatus,Long>,
        QueryDslPredicateExecutor<PrmVehicleStatus>{
}
