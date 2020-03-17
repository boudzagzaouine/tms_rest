package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsDriver;
import com.bagile.tms.entities.TmsTransportCategoryVehicle;
import com.bagile.tms.entities.TmsTurn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface TurnRepository extends JpaRepository<TmsTurn, Long>,
        QuerydslPredicateExecutor<TmsTurn> {
}
