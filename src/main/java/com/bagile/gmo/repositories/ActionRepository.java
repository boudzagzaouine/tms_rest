package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.bagile.gmo.entities.GmoAction;

@Repository
public interface ActionRepository extends JpaRepository<GmoAction,Long>,
        QuerydslPredicateExecutor<GmoAction>{

}
