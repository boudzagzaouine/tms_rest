package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


public interface LocationRepository extends JpaRepository<LocLocation, Long>,
        QueryDslPredicateExecutor<LocLocation> {
    public LocLocation findByLocLocationCode(String locLocationCode);

}