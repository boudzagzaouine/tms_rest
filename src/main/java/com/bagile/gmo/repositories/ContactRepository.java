package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.PrmContact;

public interface ContactRepository extends JpaRepository<PrmContact, Long>,
        QuerydslPredicateExecutor<PrmContact> {

}