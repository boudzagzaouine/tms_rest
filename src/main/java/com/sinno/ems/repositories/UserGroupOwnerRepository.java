package com.sinno.ems.repositories;

import com.sinno.ems.entities.UsrUserGroupOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserGroupOwnerRepository extends JpaRepository<UsrUserGroupOwner, Long>,
        QueryDslPredicateExecutor<UsrUserGroupOwner> {
}