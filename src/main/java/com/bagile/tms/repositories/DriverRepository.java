package com.bagile.tms.repositories;

import com.sinno.ems.entities.TmsDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by khalil on 27/03/2017.
 */
public interface DriverRepository extends JpaRepository<TmsDriver, Long>,
        QueryDslPredicateExecutor<TmsDriver> {

}
