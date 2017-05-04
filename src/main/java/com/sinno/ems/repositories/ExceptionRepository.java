package com.sinno.ems.repositories;

import com.sinno.ems.entities.StkException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ExceptionRepository extends JpaRepository<StkException, Long>,
        QueryDslPredicateExecutor<StkException> {

}