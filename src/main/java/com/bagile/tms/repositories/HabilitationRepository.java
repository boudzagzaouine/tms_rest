package com.bagile.tms.repositories;

import com.sinno.ems.entities.UsrHabilitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface HabilitationRepository extends JpaRepository<UsrHabilitation, Long>,
		QueryDslPredicateExecutor<UsrHabilitation> {
}