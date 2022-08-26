package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.InvSupplierInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface SupplierInvoiceRepository extends JpaRepository<InvSupplierInvoice,Long>, QuerydslPredicateExecutor<InvSupplierInvoice> {
    @Query(value="select nextval('schema_crm.seq_invoicesupplier_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
    @Query(value = "select inv_supplierinvoicecode from schema_crm.inv_supplierinvoice where inv_supplierinvoiceid= (select max(inv.inv_supplierinvoiceid) from schema_crm.inv_supplierinvoice inv)" ,nativeQuery = true)
    public String lastCode();
}
