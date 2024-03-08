package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsTransportPlanProductService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransportPlanProductServiceRepository extends JpaRepository<TmsTransportPlanProductService, Long>,
		QuerydslPredicateExecutor<TmsTransportPlanProductService> {



}