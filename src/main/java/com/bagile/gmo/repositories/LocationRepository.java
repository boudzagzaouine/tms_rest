package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.LocLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface LocationRepository extends JpaRepository<LocLocation, Long>,
        QuerydslPredicateExecutor<LocLocation> {
    public LocLocation findByLocLocationCode(String locLocationCode);

}