package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoAction;
import com.bagile.gmo.entities.GmoActionLine;
import com.bagile.gmo.entities.GmoActionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionLineRepository extends JpaRepository<GmoActionLine,Long>,
        QuerydslPredicateExecutor<GmoActionLine>{

}
