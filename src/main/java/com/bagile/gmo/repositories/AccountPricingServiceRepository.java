package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsAccountPricingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountPricingServiceRepository extends JpaRepository<TmsAccountPricingService,Long>,
        QuerydslPredicateExecutor<TmsAccountPricingService> {

 
}