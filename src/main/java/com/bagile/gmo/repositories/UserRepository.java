package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.UsrUser;

import java.math.BigInteger;
import java.util.List;

public interface UserRepository extends JpaRepository<UsrUser, Long>,
        QuerydslPredicateExecutor<UsrUser> {

    @Query(value="select nextval('schema_tmsvoieexpress.seq_user_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();

    UsrUser findByUsrUserEmail(String username);

    UsrUser findByUsrUserEmailAndUsrUserPasswordAndUsrUserIsActive(String username, String password, Boolean active);
}