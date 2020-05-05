package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoTurnLine;

public interface TurnLineRepository extends JpaRepository<GmoTurnLine, Long>,
		QuerydslPredicateExecutor<GmoTurnLine> {

}