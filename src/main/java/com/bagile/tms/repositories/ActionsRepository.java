package com.bagile.tms.repositories;

import com.sinno.ems.entities.UsrActions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ActionsRepository extends JpaRepository<UsrActions, Long>,
		QueryDslPredicateExecutor<UsrActions> {
}