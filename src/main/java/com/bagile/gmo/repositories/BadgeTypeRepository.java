package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoBadgeType;

public interface BadgeTypeRepository extends JpaRepository<GmoBadgeType,Long>,
        QuerydslPredicateExecutor<GmoBadgeType> {
}
