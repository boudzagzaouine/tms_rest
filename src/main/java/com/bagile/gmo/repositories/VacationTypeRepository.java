package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoVacationType;

public interface VacationTypeRepository extends JpaRepository<GmoVacationType,Long>,
        QuerydslPredicateExecutor<GmoVacationType> {

}
