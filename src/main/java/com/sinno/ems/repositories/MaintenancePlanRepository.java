package com.sinno.ems.repositories;

import com.sinno.ems.entities.MntMaintenancePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by khalil on 04/04/2017.
 */
public interface MaintenancePlanRepository extends JpaRepository<MntMaintenancePlan,Long>,
        QueryDslPredicateExecutor<MntMaintenancePlan>{
}
