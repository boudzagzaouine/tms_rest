package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.UsrUserGroup;

public interface UserGroupRepository extends JpaRepository<UsrUserGroup, Long>,
		QuerydslPredicateExecutor<UsrUserGroup> {
}