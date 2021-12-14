package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsTurnLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TurnLineRepository extends JpaRepository<TmsTurnLine, Long>,
		QuerydslPredicateExecutor<TmsTurnLine> {

}