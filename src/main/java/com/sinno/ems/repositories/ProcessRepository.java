package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 28/03/2017.
 */
public interface ProcessRepository extends JpaRepository<PdtProcess, Long>, QueryDslPredicateExecutor<PdtProcess> {
}
