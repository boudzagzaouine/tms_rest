package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoAction;
import com.bagile.gmo.entities.GmoActionMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionMaintenanceRepository extends JpaRepository<GmoActionMaintenance,Long>,
        QuerydslPredicateExecutor<GmoActionMaintenance>{

}
