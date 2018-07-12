package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 04/05/2016.
 */
public interface LocationStatusRepository extends JpaRepository<PrmLocationStatus, Long>, QueryDslPredicateExecutor<PrmLocationStatus> {
}
