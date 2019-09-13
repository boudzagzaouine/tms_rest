package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsDriverZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DriverZoneRepository extends JpaRepository<TmsDriverZone,Long>,

        QuerydslPredicateExecutor<TmsDriverZone> {

}
