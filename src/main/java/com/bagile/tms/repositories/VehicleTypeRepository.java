package com.bagile.tms.repositories;

import com.sinno.ems.entities.TmsVehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by bouzi on 3/27/2017.
 */

public interface VehicleTypeRepository extends JpaRepository<TmsVehicleType,Long>,
        QueryDslPredicateExecutor<TmsVehicleType>{
}
