package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsInsuranceTermLigne;
import com.bagile.tms.entities.TmsInsuranceTypeTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface InsuranceTypeTermsRepository extends JpaRepository<TmsInsuranceTypeTerms, Long>,
        QuerydslPredicateExecutor<TmsInsuranceTypeTerms> {
}
