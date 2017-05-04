package com.sinno.ems.repositories;

import com.sinno.ems.entities.LocZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ZoneRepository extends JpaRepository<LocZone, Long>,
		QueryDslPredicateExecutor<LocZone> {
}