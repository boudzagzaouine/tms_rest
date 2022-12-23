package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoCatalogTransportType;
import com.bagile.gmo.entities.TrpTransport;

import java.math.BigInteger;
import java.util.List;

public interface CatalogTransportTypeRepository extends JpaRepository<GmoCatalogTransportType, Long>,
		QuerydslPredicateExecutor<GmoCatalogTransportType> {

	@Query(value="select nextval('schema_crmexpress.seq_catalog_transport_type_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();

}