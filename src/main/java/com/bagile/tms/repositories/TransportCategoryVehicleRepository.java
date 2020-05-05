package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsTransportCategoryVehicle;
import com.bagile.gmo.entities.TrpTransport;

public interface TransportCategoryVehicleRepository extends JpaRepository<TmsTransportCategoryVehicle, Long>,
		QuerydslPredicateExecutor<TmsTransportCategoryVehicle> {


}