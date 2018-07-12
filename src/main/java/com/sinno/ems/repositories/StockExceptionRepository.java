package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by ASMAE on 27/04/2016.
 */
public interface StockExceptionRepository extends JpaRepository<StkStockException, Long>,
        QueryDslPredicateExecutor<StkStockException> {
}
