package com.bagile.tms.repositories;

import com.sinno.ems.entities.TmsPoliceInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by bouzi on 3/27/2017.
 */
public interface PoliceInsuranceRepository extends JpaRepository<TmsPoliceInsurance,Long>,
        QueryDslPredicateExecutor<TmsPoliceInsurance>{
}
