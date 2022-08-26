package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.PrmPaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface PaymentTypeRepository extends JpaRepository<PrmPaymentType,Long>
        , QuerydslPredicateExecutor<PrmPaymentType> {
}
