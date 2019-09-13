package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsVacationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface VacationTypeRepository extends JpaRepository<TmsVacationType,Long>,

        QuerydslPredicateExecutor<TmsVacationType> {

}
