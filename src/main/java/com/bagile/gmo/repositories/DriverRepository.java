package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;


public interface DriverRepository extends JpaRepository<GmoDriver, Long>,
        QuerydslPredicateExecutor<GmoDriver> {


    @Query(value="select nextval('schema_crmexpress.seq_driver_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
