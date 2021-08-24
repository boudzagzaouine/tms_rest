package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.StkContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface ContainerRepository extends JpaRepository<StkContainer, Long>,
        QuerydslPredicateExecutor<StkContainer> {
    @Query(value = "select nextval('schema_crm.seq_container_code')", nativeQuery = true)
    public List<BigInteger> getNextVal();

    public StkContainer findByStkContainerCode(String stkContainerCode);
}