package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoPump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface PumpRepository extends JpaRepository<GmoPump, Long>,
        QuerydslPredicateExecutor<GmoPump> {
}
