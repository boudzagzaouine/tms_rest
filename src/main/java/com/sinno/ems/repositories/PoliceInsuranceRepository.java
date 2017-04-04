package com.sinno.ems.repositories;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sinno.ems.entities.AsrPoliceInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by bouzi on 3/27/2017.
 */
public interface PoliceInsuranceRepository extends JpaRepository <AsrPoliceInsurance,Long>,
        QueryDslPredicateExecutor<AsrPoliceInsurance>{
}
