package com.bagile.tms.repositories;

import com.bagile.tms.entities.PrmSetting;
import com.bagile.tms.entities.TmsTraffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TrafficRepository extends JpaRepository<TmsTraffic, Long>,
        QuerydslPredicateExecutor<TmsTraffic> {
}
