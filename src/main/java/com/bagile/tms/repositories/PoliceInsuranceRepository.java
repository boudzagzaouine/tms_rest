package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by bouzi on 3/27/2017.
 */
public interface PoliceInsuranceRepository extends JpaRepository<TmsPoliceInsurance,Long>,
        QuerydslPredicateExecutor<TmsPoliceInsurance>{
}
