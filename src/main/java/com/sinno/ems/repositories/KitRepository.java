package com.sinno.ems.repositories;

import com.sinno.ems.entities.PdtKit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface KitRepository extends JpaRepository<PdtKit, Long>,
        QueryDslPredicateExecutor<PdtKit> {
}