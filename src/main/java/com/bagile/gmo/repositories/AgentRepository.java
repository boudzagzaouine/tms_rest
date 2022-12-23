package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;


public interface AgentRepository extends JpaRepository<GmoAgent, Long>,
        QuerydslPredicateExecutor<GmoAgent> {


    @Query(value="select nextval('schema_crmexpress.seq_agent_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
