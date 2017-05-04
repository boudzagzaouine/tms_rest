package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvInvoiceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by Enissay on 31/10/2016.
 */
public interface InvoiceDataRepository extends JpaRepository<InvInvoiceData, Long>, QueryDslPredicateExecutor<InvInvoiceData> {
    @Query(value="select inv_invoicedatainvoicedate from schema_ems.inv_invoicedata where inv_invoicedatainvoicedate =(select max(inv_invoicedatainvoicedate) from schema_ems.inv_invoicedata where inv_invoicedataownerid=?1)",nativeQuery = true)
    public List getMaxDate(Long ownerId);

}
