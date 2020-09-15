package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoMaintenanceStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface MaintenanceStockRepository extends JpaRepository<GmoMaintenanceStock,Long>,
        QuerydslPredicateExecutor<GmoMaintenanceStock>{

}
