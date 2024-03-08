package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsSupplierProduct;
import com.bagile.gmo.entities.TmsTransportProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransportProductRepository extends JpaRepository<TmsTransportProduct, Long>,
		QuerydslPredicateExecutor<TmsTransportProduct> {



}