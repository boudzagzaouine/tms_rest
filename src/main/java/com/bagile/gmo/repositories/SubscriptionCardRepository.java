package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoSubscriptionCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionCardRepository extends JpaRepository<GmoSubscriptionCard,Long>,
        QuerydslPredicateExecutor<GmoSubscriptionCard>{

}
