package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsAccountPricing;
import com.bagile.gmo.entities.TmsAccountService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountServiceRepository extends JpaRepository<TmsAccountService,Long>,
        QuerydslPredicateExecutor<TmsAccountService> {

 
}