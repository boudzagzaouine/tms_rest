package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;


public interface VehicleRepository extends JpaRepository<GmoVehicle,Long>,
        QuerydslPredicateExecutor<GmoVehicle> {

    @Query(value="select nextval('schema_tmsvoieexpress.seq_vehicle_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
