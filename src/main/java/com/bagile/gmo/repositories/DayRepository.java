package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoBadge;
import com.bagile.gmo.entities.GmoDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DayRepository extends JpaRepository<GmoDay,Long>,
        QuerydslPredicateExecutor<GmoDay> {
}