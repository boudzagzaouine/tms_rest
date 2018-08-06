package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsRoadState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RoadStateRepository extends JpaRepository<TmsRoadState, Long>,
        QuerydslPredicateExecutor<TmsRoadState> {
}
