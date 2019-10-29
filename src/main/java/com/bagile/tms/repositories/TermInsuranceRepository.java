package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsTermInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TermInsuranceRepository extends JpaRepository<TmsTermInsurance,Long>,

        QuerydslPredicateExecutor<TmsTermInsurance> {
}
