package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsInsuranceTermsVehicule;


public interface InsuranceTermsVehicleRepository extends JpaRepository<TmsInsuranceTermsVehicule, Long>,
        QuerydslPredicateExecutor<TmsInsuranceTermsVehicule> {
}
