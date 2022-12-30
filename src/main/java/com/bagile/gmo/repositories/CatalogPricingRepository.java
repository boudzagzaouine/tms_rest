package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsCatalogPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CatalogPricingRepository extends JpaRepository<TmsCatalogPricing,Long>,
        QuerydslPredicateExecutor<TmsCatalogPricing> {
}