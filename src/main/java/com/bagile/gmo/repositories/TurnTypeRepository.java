package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsTurnType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TurnTypeRepository extends JpaRepository<TmsTurnType,Long>,
        QuerydslPredicateExecutor<TmsTurnType> {
}