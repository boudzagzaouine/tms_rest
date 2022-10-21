package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsDeliveryInfo;
import com.bagile.gmo.entities.TmsOrderDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface DeliveryInfoRepository extends JpaRepository<TmsDeliveryInfo,Long>,
        QuerydslPredicateExecutor<TmsDeliveryInfo>{


}
