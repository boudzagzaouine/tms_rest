package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoZone;

public interface ZoneRepository extends JpaRepository<GmoZone,Long>,
        QuerydslPredicateExecutor<GmoZone> {
}
