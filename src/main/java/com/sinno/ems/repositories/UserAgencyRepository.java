package com.sinno.ems.repositories;

import com.sinno.ems.entities.UsrUserAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 03/01/2017.
 */
public interface UserAgencyRepository extends JpaRepository<UsrUserAgency, Long>,
        QueryDslPredicateExecutor<UsrUserAgency> {
}
