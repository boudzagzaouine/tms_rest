package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvPaymentSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface PaymentSupplierRepository extends JpaRepository<InvPaymentSupplier, Long>, QueryDslPredicateExecutor<InvPaymentSupplier> {
}
