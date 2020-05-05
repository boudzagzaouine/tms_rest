package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoTurn;


public interface TurnRepository extends JpaRepository<GmoTurn, Long>,
        QuerydslPredicateExecutor<GmoTurn> {
}
