package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsOrderTransport;
import com.bagile.gmo.entities.TmsOrderTransportInfoLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface OrderTransportInfoLineRepository extends JpaRepository<TmsOrderTransportInfoLine,Long>,
        QuerydslPredicateExecutor<TmsOrderTransportInfoLine>{


}
