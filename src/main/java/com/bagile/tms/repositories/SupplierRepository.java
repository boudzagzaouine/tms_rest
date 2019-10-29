package com.bagile.tms.repositories;

import com.bagile.tms.entities.RcpSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SupplierRepository extends JpaRepository<RcpSupplier,Long>,
        QuerydslPredicateExecutor<RcpSupplier> {
}

