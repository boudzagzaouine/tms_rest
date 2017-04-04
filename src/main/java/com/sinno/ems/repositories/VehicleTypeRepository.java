package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmVehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Service;

/**
 * Created by bouzi on 3/27/2017.
 */

public interface VehicleTypeRepository extends JpaRepository<PrmVehicleType,Long>,
        QueryDslPredicateExecutor<PrmVehicleType>{
}
