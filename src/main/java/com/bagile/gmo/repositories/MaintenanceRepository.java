package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;


public interface MaintenanceRepository extends JpaRepository<GmoMaintenance,Long>,
        QuerydslPredicateExecutor<GmoMaintenance>{
    @Query(value="select nextval('schema_emsgc.seq_maintenance_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
