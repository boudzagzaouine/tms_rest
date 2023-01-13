package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoBrandVehicleType;
import com.bagile.gmo.entities.TmsTransportPlanHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransportPlanHistoryRepository extends JpaRepository<TmsTransportPlanHistory, Long>,
		QuerydslPredicateExecutor<TmsTransportPlanHistory> {



}