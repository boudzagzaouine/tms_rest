package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OperationTypeRepository extends JpaRepository<GmoService,Long>,
        QuerydslPredicateExecutor<GmoService> {
}