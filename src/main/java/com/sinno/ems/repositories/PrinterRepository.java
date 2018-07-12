package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 03/08/2016.
 */
public interface PrinterRepository extends JpaRepository<PrmPrinter,Long>,QueryDslPredicateExecutor<PrmPrinter> {
}
