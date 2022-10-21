package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsOrderDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface OrderDeliveryRepository extends JpaRepository<TmsOrderDelivery,Long>,
        QuerydslPredicateExecutor<TmsOrderDelivery>{

    @Query(value="select nextval('schema_crm.seq_orderdelivery_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
