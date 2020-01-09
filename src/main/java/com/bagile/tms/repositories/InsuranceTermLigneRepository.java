package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsInsuranceTermLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface InsuranceTermLigneRepository extends JpaRepository<TmsInsuranceTermLigne, Long>,
        QuerydslPredicateExecutor<TmsInsuranceTermLigne> {
}
