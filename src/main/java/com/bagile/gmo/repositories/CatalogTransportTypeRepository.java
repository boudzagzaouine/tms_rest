package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoCatalogTransportType;
import com.bagile.gmo.entities.TrpTransport;

public interface CatalogTransportTypeRepository extends JpaRepository<GmoCatalogTransportType, Long>,
		QuerydslPredicateExecutor<GmoCatalogTransportType> {


}