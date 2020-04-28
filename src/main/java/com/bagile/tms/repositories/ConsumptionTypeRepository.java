package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsBadge;
import com.bagile.tms.entities.TmsConsumptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ConsumptionTypeRepository extends JpaRepository<TmsConsumptionType,Long>,
        QuerydslPredicateExecutor<TmsConsumptionType> {
}