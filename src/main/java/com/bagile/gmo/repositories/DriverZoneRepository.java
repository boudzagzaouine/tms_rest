package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TmsDriverZone;

public interface DriverZoneRepository extends JpaRepository<TmsDriverZone,Long>,

        QuerydslPredicateExecutor<TmsDriverZone> {

}
