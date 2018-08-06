package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsDoorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DoorTypeRepository extends JpaRepository<TmsDoorType, Long>,
        QuerydslPredicateExecutor<TmsDoorType> {
}
