package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsInsuranceTermLigne;


public interface InsuranceTermLigneRepository extends JpaRepository<TmsInsuranceTermLigne, Long>,
        QuerydslPredicateExecutor<TmsInsuranceTermLigne> {
}
