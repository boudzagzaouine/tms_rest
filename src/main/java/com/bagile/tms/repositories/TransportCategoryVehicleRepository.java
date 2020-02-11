package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsTransportCategoryVehicle;
import com.bagile.tms.entities.TrpTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransportCategoryVehicleRepository extends JpaRepository<TmsTransportCategoryVehicle, Long>,
		QuerydslPredicateExecutor<TmsTransportCategoryVehicle> {


}