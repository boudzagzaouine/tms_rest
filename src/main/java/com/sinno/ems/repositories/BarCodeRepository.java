package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmBarCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by ASMAE on 28/04/2016.
 */
public interface BarCodeRepository extends JpaRepository<PrmBarCode, Long>,
        QueryDslPredicateExecutor<PrmBarCode> {
}
