package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsCatalogTransportType;
import com.bagile.tms.entities.TrpTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CatalogTransportTypeRepository extends JpaRepository<TmsCatalogTransportType, Long>,
		QuerydslPredicateExecutor<TmsCatalogTransportType> {


}