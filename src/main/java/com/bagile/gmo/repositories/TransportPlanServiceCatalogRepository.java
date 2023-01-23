package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsTransportPlanServiceCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransportPlanServiceCatalogRepository extends JpaRepository<TmsTransportPlanServiceCatalog, Long>,
		QuerydslPredicateExecutor<TmsTransportPlanServiceCatalog> {



}