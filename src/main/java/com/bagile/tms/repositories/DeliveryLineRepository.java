package com.bagile.tms.repositories;

import com.bagile.tms.entities.CmdDeliveryLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface DeliveryLineRepository extends JpaRepository<CmdDeliveryLine, Long>,
        QuerydslPredicateExecutor<CmdDeliveryLine> {
}
