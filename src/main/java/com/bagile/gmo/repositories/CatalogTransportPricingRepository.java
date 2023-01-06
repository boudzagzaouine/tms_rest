package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsCatalogTransportPricing;

import java.math.BigInteger;
import java.util.List;

public interface CatalogTransportPricingRepository extends JpaRepository<TmsCatalogTransportPricing, Long>,
		QuerydslPredicateExecutor<TmsCatalogTransportPricing> {

	@Query(value="select nextval('schema_tmsvoieexpress.seq_catalog_transport_pricing_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();

}