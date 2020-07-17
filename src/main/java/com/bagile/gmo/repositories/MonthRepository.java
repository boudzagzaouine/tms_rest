package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoDay;
import com.bagile.gmo.entities.GmoMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MonthRepository extends JpaRepository<GmoMonth,Long>,
        QuerydslPredicateExecutor<GmoMonth> {
}