package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsCatalogTransportAccountPricing;
import com.bagile.gmo.entities.TmsCatalogTransportPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface CatalogTransportAccountPricingRepository extends JpaRepository<TmsCatalogTransportAccountPricing, Long>,
		QuerydslPredicateExecutor<TmsCatalogTransportAccountPricing> {

	@Query(value="select nextval('schema_tmsvoieexpress.seq_catalog_transport_account_pricing_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();

}