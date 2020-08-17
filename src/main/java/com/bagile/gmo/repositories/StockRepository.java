package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoBadge;
import com.bagile.gmo.entities.StkStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StockRepository extends JpaRepository<StkStock,Long>,
        QuerydslPredicateExecutor<StkStock> {
}