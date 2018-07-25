package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ContactRepository extends JpaRepository<com.bagile.tms.entities.PrmContact, Long>,
        QuerydslPredicateExecutor<com.bagile.tms.entities.PrmContact> {

    public com.bagile.tms.entities.PrmContact findByPrmContactName(String prmContactName);
}