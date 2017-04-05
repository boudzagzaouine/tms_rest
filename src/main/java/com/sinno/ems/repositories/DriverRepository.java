package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by khalil on 27/03/2017.
 */
public interface DriverRepository extends JpaRepository<PrmDriver, Long>,
        QueryDslPredicateExecutor<PrmDriver> {

}
