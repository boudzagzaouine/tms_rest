package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoSubscriptionCard;
import com.bagile.gmo.entities.GmoSubscriptionCardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionCardTypeRepository extends JpaRepository<GmoSubscriptionCardType,Long>,
        QuerydslPredicateExecutor<GmoSubscriptionCardType>{

}
