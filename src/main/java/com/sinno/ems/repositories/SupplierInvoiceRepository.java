package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvSupplierInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface SupplierInvoiceRepository extends JpaRepository<InvSupplierInvoice,Long>,QueryDslPredicateExecutor<InvSupplierInvoice> {
    @Query(value="select nextval('schema_ems.seq_invoicesupplier_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
