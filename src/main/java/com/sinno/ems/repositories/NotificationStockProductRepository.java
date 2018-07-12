package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 07/10/2016.
 */
public interface NotificationStockProductRepository extends JpaRepository<NotificationStockProduct, Long>, QueryDslPredicateExecutor<NotificationStockProduct> {
}
