package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.UsrHabilitation;

public interface HabilitationRepository extends JpaRepository<UsrHabilitation, Long>,
		QuerydslPredicateExecutor<UsrHabilitation> {
}