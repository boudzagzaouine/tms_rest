package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsVehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by bouzi on 3/27/2017.
 */
public interface VehicleStatusRepository extends JpaRepository<TmsVehicleStatus,Long>,
        QuerydslPredicateExecutor<TmsVehicleStatus>{
}
