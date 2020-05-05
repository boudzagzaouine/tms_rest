package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsVacation;
public interface VacationRepository extends JpaRepository<TmsVacation,Long>,
        QuerydslPredicateExecutor<TmsVacation> {
}
