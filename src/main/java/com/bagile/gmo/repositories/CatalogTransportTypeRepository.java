package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsCatalogTransportType;
import com.bagile.gmo.entities.TrpTransport;

public interface CatalogTransportTypeRepository extends JpaRepository<TmsCatalogTransportType, Long>,
		QuerydslPredicateExecutor<TmsCatalogTransportType> {


}