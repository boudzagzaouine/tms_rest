package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 24/01/2017.
 */
public interface PromotionRepository extends JpaRepository<PmtPromotion, Long>,
        QueryDslPredicateExecutor<PmtPromotion> {
}
