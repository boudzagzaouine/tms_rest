package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.UsrUser;

public interface UserRepository extends JpaRepository<UsrUser, Long>,
        QuerydslPredicateExecutor<UsrUser> {

    UsrUser findByUsrUserEmail(String username);

    UsrUser findByUsrUserEmailAndUsrUserPasswordAndUsrUserIsActive(String username, String password, Boolean active);
}