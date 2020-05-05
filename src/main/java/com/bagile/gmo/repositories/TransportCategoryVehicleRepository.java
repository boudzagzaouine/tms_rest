package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoTransportCategoryVehicle;
import com.bagile.gmo.entities.TrpTransport;

public interface TransportCategoryVehicleRepository extends JpaRepository<GmoTransportCategoryVehicle, Long>,
		QuerydslPredicateExecutor<GmoTransportCategoryVehicle> {


}