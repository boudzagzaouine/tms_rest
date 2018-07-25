package com.bagile.tms.repositories;

import com.bagile.tms.entities.UsrUserActions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserActionsRepository extends JpaRepository<UsrUserActions, Long>,
		QuerydslPredicateExecutor<UsrUserActions> {
}