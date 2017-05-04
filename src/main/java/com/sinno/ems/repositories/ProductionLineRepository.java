package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrcProduction;
import com.sinno.ems.entities.PrcProductionLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 03/04/2017.
 */
public interface ProductionLineRepository extends QueryDslPredicateExecutor<PrcProductionLine>, JpaRepository<PrcProductionLine, Long> {
}
