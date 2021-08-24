package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.RcpSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface SupplierRepository extends JpaRepository<RcpSupplier,Long>,
        QuerydslPredicateExecutor<RcpSupplier> {

    @Query(value="select nextval('schema_crm.seq_supplier_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}

