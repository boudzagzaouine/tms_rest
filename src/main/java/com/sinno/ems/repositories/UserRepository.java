package com.sinno.ems.repositories;

import com.sinno.ems.entities.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserRepository extends JpaRepository<UsrUser, Long>,
        QueryDslPredicateExecutor<UsrUser> {

    UsrUser findByUsrUserEmail(String username);

    UsrUser findByUsrUserEmailAndUsrUserPasswordAndUsrUserIsActive(String username, String password,Boolean active);
}