package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsOrderTransportInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryInfoRepository extends JpaRepository<TmsOrderTransportInfo,Long>,
        QuerydslPredicateExecutor<TmsOrderTransportInfo>{


}
