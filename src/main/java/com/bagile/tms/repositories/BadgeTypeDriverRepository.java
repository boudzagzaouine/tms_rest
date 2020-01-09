package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsBadgeTypeDriver;
import com.bagile.tms.entities.TmsCommissionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface BadgeTypeDriverRepository extends JpaRepository<TmsBadgeTypeDriver, Long>,
        QuerydslPredicateExecutor<TmsBadgeTypeDriver> {
}
