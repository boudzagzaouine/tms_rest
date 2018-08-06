package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ZoneRepository extends JpaRepository<TmsZone,Long>,
        QuerydslPredicateExecutor<TmsZone> {
}
