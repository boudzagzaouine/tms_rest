package com.bagile.tms.repositories;

import com.bagile.tms.entities.CmdDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 21/04/2016.
 */

public interface DeliveryRepository extends JpaRepository<CmdDelivery, Long>,
        QuerydslPredicateExecutor<CmdDelivery> {
    @Query(value="select nextval('schema_crm.seq_delivery_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
