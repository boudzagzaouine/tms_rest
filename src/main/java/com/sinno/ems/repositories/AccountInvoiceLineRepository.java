package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvAccountInvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 05/12/2016.
 */
public interface AccountInvoiceLineRepository extends JpaRepository<InvAccountInvoiceLine,Long>,QueryDslPredicateExecutor<InvAccountInvoiceLine> {
}
