package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.InvSupplierInvoicePurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface SupplierInvoicePurchaseOrderRepository extends JpaRepository<InvSupplierInvoicePurchaseOrder,Long>
        , QuerydslPredicateExecutor<InvSupplierInvoicePurchaseOrder> {

}
