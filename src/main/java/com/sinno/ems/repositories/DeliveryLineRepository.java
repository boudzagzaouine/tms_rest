package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdDeliveryLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 21/04/2016.
 */
public interface DeliveryLineRepository extends JpaRepository<CmdDeliveryLine, Long>,
        QueryDslPredicateExecutor<CmdDeliveryLine> {
}
