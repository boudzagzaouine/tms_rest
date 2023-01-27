package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionPlan;
import com.bagile.gmo.entities.TmsTransportPlan;
import com.bagile.gmo.entities.TmsTransportPlanLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransportPlanLocationRepository extends JpaRepository<TmsTransportPlanLocation,Long>,
        QuerydslPredicateExecutor<TmsTransportPlanLocation> {

 
}