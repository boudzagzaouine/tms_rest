package com.bagile.tms.repositories;

import com.sinno.ems.entities.CmdDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 21/04/2016.
 */

public interface DeliveryRepository extends JpaRepository<CmdDelivery, Long>,
        QueryDslPredicateExecutor<CmdDelivery> {
    @Query(value="select nextval('schema_ems.seq_delivery_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
