package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsInsuranceTermLigne;
import com.bagile.gmo.entities.TmsInsuranceTypeTerms;


public interface InsuranceTypeTermsRepository extends JpaRepository<TmsInsuranceTypeTerms, Long>,
        QuerydslPredicateExecutor<TmsInsuranceTypeTerms> {
}
