package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoInsuranceTermLigne;


public interface InsuranceTermLigneRepository extends JpaRepository<GmoInsuranceTermLigne, Long>,
        QuerydslPredicateExecutor<GmoInsuranceTermLigne> {
}
