package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsBadgeTypeDriver;
import com.bagile.tms.entities.TmsInsuranceTermsVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface InsuranceTermsVehicleRepository extends JpaRepository<TmsInsuranceTermsVehicule, Long>,
        QuerydslPredicateExecutor<TmsInsuranceTermsVehicule> {
}
