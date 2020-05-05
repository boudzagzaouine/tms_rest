package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsBadge;
import com.bagile.gmo.entities.TmsConsumptionType;

public interface ConsumptionTypeRepository extends JpaRepository<TmsConsumptionType,Long>,
        QuerydslPredicateExecutor<TmsConsumptionType> {
}