package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 03/04/2017.
 */
public interface ProductionRepository extends QueryDslPredicateExecutor<PrcProduction>,JpaRepository<PrcProduction,Long> {
}
