package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.PrmPaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by Enissay on 06/12/2016.
 */
public interface PaymentStatusRepository extends JpaRepository<PrmPaymentStatus,Long>
        , QuerydslPredicateExecutor<PrmPaymentStatus> {
}
