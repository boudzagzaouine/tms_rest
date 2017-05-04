package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 22/12/2016.
 */
public interface CurrencyRepository extends JpaRepository<PrmCurrency, Long>, QueryDslPredicateExecutor<PrmCurrency> {
}
