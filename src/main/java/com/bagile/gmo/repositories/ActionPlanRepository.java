package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ActionPlanRepository extends JpaRepository<GmoActionPlan,Long>,
        QuerydslPredicateExecutor<GmoActionPlan> {

 
}