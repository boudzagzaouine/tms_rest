package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsTurn;


public interface TurnRepository extends JpaRepository<TmsTurn, Long>,
        QuerydslPredicateExecutor<TmsTurn> {
}
