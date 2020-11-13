package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoConditionalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ConditionalTypeRepository extends JpaRepository<GmoConditionalType,Long>,
        QuerydslPredicateExecutor<GmoConditionalType> {
}
