package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsTransportAccountService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransportAccountServiceRepository extends JpaRepository<TmsTransportAccountService,Long>,
        QuerydslPredicateExecutor<TmsTransportAccountService> {

 
}