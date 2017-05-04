package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmVat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import javax.tools.JavaCompiler;

/**
 * Created by Enissay on 22/12/2016.
 */
public interface VatRepository extends JpaRepository<PrmVat, Long>, QueryDslPredicateExecutor<PrmVat> {
}
