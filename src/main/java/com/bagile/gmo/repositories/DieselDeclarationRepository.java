package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoDieselDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface DieselDeclarationRepository extends JpaRepository<GmoDieselDeclaration,Long>,
        QuerydslPredicateExecutor<GmoDieselDeclaration> {



    @Query(value="select nextval('schema_tmsvoieexpress.seq_gmo_diseldeclaration_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}