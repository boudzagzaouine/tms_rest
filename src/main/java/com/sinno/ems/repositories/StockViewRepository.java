package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.sinno.ems.entities.StkStockView;

public interface StockViewRepository extends JpaRepository<StkStockView, Long>,
QueryDslPredicateExecutor<StkStockView>  {

}
