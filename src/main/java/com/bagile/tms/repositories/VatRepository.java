package com.bagile.tms.repositories;

import com.bagile.tms.entities.PrmVat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigDecimal;



public interface VatRepository extends  JpaRepository<PrmVat,Long>,
        QuerydslPredicateExecutor<PrmVat> {
}
