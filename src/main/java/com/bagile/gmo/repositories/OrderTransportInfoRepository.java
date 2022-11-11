package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsOrderTransportInfo;
import com.bagile.gmo.entities.TmsOrderTransportInfoLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTransportInfoRepository extends JpaRepository<TmsOrderTransportInfo,Long>,
        QuerydslPredicateExecutor<TmsOrderTransportInfo>{


}
