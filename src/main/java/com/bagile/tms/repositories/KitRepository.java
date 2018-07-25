package com.bagile.tms.repositories;

import com.bagile.tms.entities.PdtKit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface KitRepository extends JpaRepository<PdtKit, Long>,
        QuerydslPredicateExecutor<PdtKit> {
}