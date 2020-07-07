package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.bagile.gmo.entities.GmoAction;

@Repository
public interface ActionTypeRepository extends JpaRepository<GmoActionType,Long>,
        QuerydslPredicateExecutor<GmoActionType>{

}
