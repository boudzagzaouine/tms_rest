package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsBadge;
public interface BadgeRepository extends JpaRepository<TmsBadge,Long>,
        QuerydslPredicateExecutor<TmsBadge> {
}