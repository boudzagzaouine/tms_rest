package com.bagile.tms.repositories;

import com.bagile.tms.entities.UsrUserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserGroupRepository extends JpaRepository<UsrUserGroup, Long>,
		QuerydslPredicateExecutor<UsrUserGroup> {
}