package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsTurnSoPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TurnSoPoRepository extends JpaRepository<TmsTurnSoPo,Long>,
        QuerydslPredicateExecutor<TmsTurnSoPo> {
}