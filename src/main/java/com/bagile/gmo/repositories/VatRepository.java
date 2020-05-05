package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.PrmVat;

import java.math.BigDecimal;



public interface VatRepository extends  JpaRepository<PrmVat,Long>,
        QuerydslPredicateExecutor<PrmVat> {
}
