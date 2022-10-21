package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoBadgeType;
import com.bagile.gmo.entities.TmsTurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TurnStatusRepository extends JpaRepository<TmsTurnStatus,Long>,
        QuerydslPredicateExecutor<TmsTurnStatus> {
}
