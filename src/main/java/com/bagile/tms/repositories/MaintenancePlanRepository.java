package com.bagile.tms.repositories;

import com.bagile.gmo.dto.MaintenanceState;
import com.bagile.gmo.entities.GmoMaintenancePlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by khalil on 04/04/2017.
 */
public interface MaintenancePlanRepository extends JpaRepository<GmoMaintenancePlan,Long>,
        QuerydslPredicateExecutor<GmoMaintenancePlan>{

	@Query()
	void changeState(MaintenanceState maintenanceState);
}
