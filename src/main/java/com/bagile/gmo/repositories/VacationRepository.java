package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoVacation;
public interface VacationRepository extends JpaRepository<GmoVacation,Long>,
        QuerydslPredicateExecutor<GmoVacation> {
}
