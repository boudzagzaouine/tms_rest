package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoMaintenancePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface MaintenancePlanRepository extends JpaRepository<GmoMaintenancePlan,Long>,
        QuerydslPredicateExecutor<GmoMaintenancePlan> {

    @Query(value="select nextval('schema_tmsvoieexpress.seq_maintenancePlan_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}