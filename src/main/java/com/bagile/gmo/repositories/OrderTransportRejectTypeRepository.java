package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoBrandVehicleType;
import com.bagile.gmo.entities.TmsOrderTransportRejectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OrderTransportRejectTypeRepository extends JpaRepository<TmsOrderTransportRejectType, Long>,
		QuerydslPredicateExecutor<TmsOrderTransportRejectType> {



}