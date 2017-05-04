package com.sinno.ems.repositories;

import com.sinno.ems.dto.Contact;
import com.sinno.ems.entities.PrmContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ContactRepository extends JpaRepository<PrmContact, Long>,
        QueryDslPredicateExecutor<PrmContact> {

    public PrmContact findByPrmContactName(String prmContactName);
}