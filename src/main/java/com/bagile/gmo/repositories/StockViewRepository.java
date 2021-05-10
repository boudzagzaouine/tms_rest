package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.StkStockView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StockViewRepository extends JpaRepository<StkStockView,Long>,
        QuerydslPredicateExecutor<StkStockView> {


}