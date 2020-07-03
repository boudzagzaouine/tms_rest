package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoBadge;
import com.bagile.gmo.entities.GmoProgramType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProgramTypeRepository extends JpaRepository<GmoProgramType,Long>,
        QuerydslPredicateExecutor<GmoProgramType> {
}