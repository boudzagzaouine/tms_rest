package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoBadgeTypeDriver;


public interface BadgeTypeDriverRepository extends JpaRepository<GmoBadgeTypeDriver, Long>,
        QuerydslPredicateExecutor<GmoBadgeTypeDriver> {
}
