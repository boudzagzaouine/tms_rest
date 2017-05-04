package com.sinno.ems.repositories;

import com.sinno.ems.entities.UsrUserActions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserActionsRepository extends JpaRepository<UsrUserActions, Long>,
		QueryDslPredicateExecutor<UsrUserActions> {
}