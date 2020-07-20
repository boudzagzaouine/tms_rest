package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface MaintenanceRepository extends JpaRepository<GmoMaintenance,Long>,
        QuerydslPredicateExecutor<GmoMaintenance>{

}
