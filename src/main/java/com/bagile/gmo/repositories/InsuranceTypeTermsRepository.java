package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoInsuranceTermLigne;
import com.bagile.gmo.entities.GmoInsuranceTypeTerms;


public interface InsuranceTypeTermsRepository extends JpaRepository<GmoInsuranceTypeTerms, Long>,
        QuerydslPredicateExecutor<GmoInsuranceTypeTerms> {
}
