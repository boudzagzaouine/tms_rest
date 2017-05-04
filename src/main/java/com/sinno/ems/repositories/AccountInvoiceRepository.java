package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvAccountInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface AccountInvoiceRepository extends JpaRepository<InvAccountInvoice,Long>,QueryDslPredicateExecutor<InvAccountInvoice>{
    @Query(value="select nextval('schema_ems.seq_invoiceaccount_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
