package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.CmdDeliveryLine;


public interface DeliveryLineRepository extends JpaRepository<CmdDeliveryLine, Long>,
        QuerydslPredicateExecutor<CmdDeliveryLine> {
}
