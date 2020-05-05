package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.UsrGroupHabilitation;

public interface GroupHabilitationRepository extends JpaRepository<UsrGroupHabilitation, Long>,
		QuerydslPredicateExecutor<UsrGroupHabilitation> {
}