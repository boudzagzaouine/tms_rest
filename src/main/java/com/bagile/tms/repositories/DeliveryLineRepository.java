package com.bagile.tms.repositories;

import com.bagile.tms.entities.CmdDeliveryLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by Enissay on 21/04/2016.
 */
public interface DeliveryLineRepository extends JpaRepository<CmdDeliveryLine, Long>,
        QuerydslPredicateExecutor<CmdDeliveryLine> {
}
