package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsBadgeType;
import com.bagile.tms.entities.TmsMaintenancePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BadgeTypeRepository extends JpaRepository<TmsBadgeType,Long>,
        QuerydslPredicateExecutor<TmsBadgeType> {
}
