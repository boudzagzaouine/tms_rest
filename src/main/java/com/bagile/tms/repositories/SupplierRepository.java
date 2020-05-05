package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.RcpSupplier;

public interface SupplierRepository extends JpaRepository<RcpSupplier,Long>,
        QuerydslPredicateExecutor<RcpSupplier> {
}

