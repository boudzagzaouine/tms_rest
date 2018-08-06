package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsVacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface VacationRepository extends JpaRepository<TmsVacation,Long>,
        QuerydslPredicateExecutor<TmsVacation> {
}
