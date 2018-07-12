package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface PreparationRepository extends JpaRepository<CmdPreparation,Long>,QueryDslPredicateExecutor<CmdPreparation> {
    @Query(value="select nextval('schema_ems.seq_preparation_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
