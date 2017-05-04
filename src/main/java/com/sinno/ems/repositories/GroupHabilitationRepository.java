package com.sinno.ems.repositories;

import com.sinno.ems.entities.UsrGroupHabilitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface GroupHabilitationRepository extends JpaRepository<UsrGroupHabilitation, Long>,
		QueryDslPredicateExecutor<UsrGroupHabilitation> {
}