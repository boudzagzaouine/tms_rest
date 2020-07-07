package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<GmoAction,Long>,
        QuerydslPredicateExecutor<GmoAction>{

}
