package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoDriverZone;

public interface DriverZoneRepository extends JpaRepository<GmoDriverZone,Long>,

        QuerydslPredicateExecutor<GmoDriverZone> {

}
