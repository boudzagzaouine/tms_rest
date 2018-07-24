package com.bagile.tms.repositories;

import com.sinno.ems.entities.UsrUserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserGroupRepository extends JpaRepository<UsrUserGroup, Long>,
		QueryDslPredicateExecutor<UsrUserGroup> {
}