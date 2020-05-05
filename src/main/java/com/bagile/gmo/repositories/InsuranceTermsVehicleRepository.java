package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoInsuranceTermsVehicule;


public interface InsuranceTermsVehicleRepository extends JpaRepository<GmoInsuranceTermsVehicule, Long>,
        QuerydslPredicateExecutor<GmoInsuranceTermsVehicule> {
}
