package com.bagile.tms.repositories;

import com.bagile.tms.entities.UsrUserGroupOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserGroupOwnerRepository extends JpaRepository<UsrUserGroupOwner, Long>,
        QuerydslPredicateExecutor<UsrUserGroupOwner> {
}