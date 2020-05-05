package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsVacationType;

public interface VacationTypeRepository extends JpaRepository<TmsVacationType,Long>,
        QuerydslPredicateExecutor<TmsVacationType> {

}
