package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 06/12/2016.
 */
public interface PaymentStatusRepository extends JpaRepository<PrmPaymentStatus,Long>,QueryDslPredicateExecutor<PrmPaymentStatus> {
}
