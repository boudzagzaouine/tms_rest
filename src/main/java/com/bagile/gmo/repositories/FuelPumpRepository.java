package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoFuelPump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface FuelPumpRepository extends JpaRepository<GmoFuelPump, Long>,
        QuerydslPredicateExecutor<GmoFuelPump> {
}
