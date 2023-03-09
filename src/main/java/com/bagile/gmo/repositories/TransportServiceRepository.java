package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsTransportService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransportServiceRepository extends JpaRepository<TmsTransportService,Long>,
        QuerydslPredicateExecutor<TmsTransportService> {

 
}