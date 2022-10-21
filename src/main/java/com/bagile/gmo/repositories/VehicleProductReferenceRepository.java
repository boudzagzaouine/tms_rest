package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoVehicleProductReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleProductReferenceRepository extends JpaRepository<GmoVehicleProductReference,Long>,
        QuerydslPredicateExecutor<GmoVehicleProductReference>{

}
