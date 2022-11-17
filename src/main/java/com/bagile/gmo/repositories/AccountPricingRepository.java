package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionPlan;
import com.bagile.gmo.entities.TmsAccountPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountPricingRepository extends JpaRepository<TmsAccountPricing,Long>,
        QuerydslPredicateExecutor<TmsAccountPricing> {

 
}