package com.sinno.ems.repositories;

import com.sinno.ems.entities.StkContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface ContainerRepository extends JpaRepository<StkContainer, Long>,
        QueryDslPredicateExecutor<StkContainer> {
    @Query(value = "select nextval('schema_ems.seq_container_code')", nativeQuery = true)
    public List<BigInteger> getNextVal();

    public StkContainer findByStkContainerCode(String stkContainerCode);
}