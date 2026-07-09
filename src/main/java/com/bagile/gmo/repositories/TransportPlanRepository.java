package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionPlan;
import com.bagile.gmo.entities.TmsTransportPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TransportPlanRepository extends JpaRepository<TmsTransportPlan,Long>,
        QuerydslPredicateExecutor<TmsTransportPlan> {

    /**
     * Lightweight live-position update used by the driver app's tracking. A
     * targeted UPDATE (no entity graph load/save) so it's cheap to call often.
     */
    @Modifying
    @Transactional
    @Query("update TmsTransportPlan p set p.tmsTransportPlanlatitude = :lat, "
            + "p.tmsTransportPlanlongitude = :lng where p.tmsTransportPlanId = :id")
    int updateLivePosition(@Param("id") long id, @Param("lat") Double lat, @Param("lng") Double lng);

}