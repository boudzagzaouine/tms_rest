package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoMaintenancePlan;
import com.bagile.gmo.entities.GmoMaintenancePreventive;
import com.bagile.gmo.entities.GmoMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MaintenancePreventiveRepository extends JpaRepository<GmoMaintenancePreventive,Long>,
        QuerydslPredicateExecutor<GmoMaintenancePreventive> {
}