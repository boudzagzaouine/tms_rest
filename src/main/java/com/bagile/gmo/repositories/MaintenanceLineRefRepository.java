package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.bagile.gmo.entities.GmoMaintenanceLineRef;

@Repository
public interface MaintenanceLineRefRepository extends JpaRepository<GmoMaintenanceLineRef,Long>,
        QuerydslPredicateExecutor<GmoMaintenanceLineRef>{

}
