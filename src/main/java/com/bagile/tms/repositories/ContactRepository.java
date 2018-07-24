package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ContactRepository extends JpaRepository<com.sinno.ems.entities.PrmContact, Long>,
        QueryDslPredicateExecutor<com.sinno.ems.entities.PrmContact> {

    public com.sinno.ems.entities.PrmContact findByPrmContactName(String prmContactName);
}