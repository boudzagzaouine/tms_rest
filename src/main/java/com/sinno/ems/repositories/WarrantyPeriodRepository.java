package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmWarrantyPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 15/12/2016.
 */
public interface WarrantyPeriodRepository extends JpaRepository<PrmWarrantyPeriod, Long>,
        QueryDslPredicateExecutor<PrmWarrantyPeriod> {
}
