package com.bagile.tms.repositories;

import com.bagile.tms.entities.UsrAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface AgencyRepository extends JpaRepository<UsrAgency,Long>,QuerydslPredicateExecutor<UsrAgency> {
}
