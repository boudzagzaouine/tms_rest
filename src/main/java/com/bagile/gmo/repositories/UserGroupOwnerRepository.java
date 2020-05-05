package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.UsrUserGroupOwner;

public interface UserGroupOwnerRepository extends JpaRepository<UsrUserGroupOwner, Long>,
        QuerydslPredicateExecutor<UsrUserGroupOwner> {
}