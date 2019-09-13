package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsBadge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
public interface BadgeRepository extends JpaRepository<TmsBadge,Long>,

        QuerydslPredicateExecutor<TmsBadge> {

}

