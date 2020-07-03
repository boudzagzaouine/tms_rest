package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoResponsability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ResponsabilityRepository extends JpaRepository<GmoResponsability,Long>,
        QuerydslPredicateExecutor<GmoResponsability> {
}