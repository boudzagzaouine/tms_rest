package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.PrmContact;

import java.math.BigInteger;
import java.util.List;

public interface ContactRepository extends JpaRepository<PrmContact, Long>,
        QuerydslPredicateExecutor<PrmContact> {


    @Query(value="select nextval('schema_crm.seq_contact_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}