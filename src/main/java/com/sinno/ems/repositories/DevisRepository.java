package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 06/12/2016.
 */
public interface DevisRepository extends JpaRepository<CmdDevis,Long>,QueryDslPredicateExecutor<CmdDevis> {
    @Query(value="select nextval('schema_ems.seq_code_devis')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
