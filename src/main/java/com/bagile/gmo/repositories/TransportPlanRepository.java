package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionPlan;
import com.bagile.gmo.entities.TmsTransportPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransportPlanRepository extends JpaRepository<TmsTransportPlan,Long>,
        QuerydslPredicateExecutor<TmsTransportPlan> {

 
}