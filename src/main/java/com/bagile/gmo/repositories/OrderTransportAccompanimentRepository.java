package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsOrderTransportAccompaniment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OrderTransportAccompanimentRepository extends JpaRepository<TmsOrderTransportAccompaniment, Long>,
        QuerydslPredicateExecutor<TmsOrderTransportAccompaniment> {
}
