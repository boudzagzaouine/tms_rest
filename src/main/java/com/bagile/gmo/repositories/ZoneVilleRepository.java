package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsZoneVille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ZoneVilleRepository extends JpaRepository<TmsZoneVille,Long>,
        QuerydslPredicateExecutor<TmsZoneVille> {
}
