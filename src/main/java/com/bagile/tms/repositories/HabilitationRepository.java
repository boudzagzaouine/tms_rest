package com.bagile.tms.repositories;

import com.bagile.tms.entities.UsrHabilitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface HabilitationRepository extends JpaRepository<UsrHabilitation, Long>,
		QuerydslPredicateExecutor<UsrHabilitation> {
}