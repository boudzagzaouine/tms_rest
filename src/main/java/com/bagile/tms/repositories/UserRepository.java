package com.bagile.tms.repositories;

import com.bagile.tms.entities.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<UsrUser, Long>,
        QuerydslPredicateExecutor<UsrUser> {

    UsrUser findByUsrUserEmail(String username);

    UsrUser findByUsrUserEmailAndUsrUserPasswordAndUsrUserIsActive(String username, String password, Boolean active);
}