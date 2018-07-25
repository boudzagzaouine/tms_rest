package com.bagile.tms.repositories;

import com.bagile.tms.entities.UsrActions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ActionsRepository extends JpaRepository<UsrActions, Long>,
		QuerydslPredicateExecutor<UsrActions> {
}