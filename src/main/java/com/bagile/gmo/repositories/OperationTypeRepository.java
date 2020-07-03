package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoOperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OperationTypeRepository extends JpaRepository<GmoOperationType,Long>,
        QuerydslPredicateExecutor<GmoOperationType> {
}