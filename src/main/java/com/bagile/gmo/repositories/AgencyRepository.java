package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoBadgeType;
import com.bagile.gmo.entities.UsrAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AgencyRepository extends JpaRepository<UsrAgency,Long>,
        QuerydslPredicateExecutor<UsrAgency> {
}
