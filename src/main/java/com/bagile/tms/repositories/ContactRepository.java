package com.bagile.tms.repositories;

import com.bagile.tms.entities.PrmContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ContactRepository extends JpaRepository<PrmContact, Long>,
        QuerydslPredicateExecutor<PrmContact> {

}