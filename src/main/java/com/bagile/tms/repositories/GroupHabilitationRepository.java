package com.bagile.tms.repositories;

import com.bagile.tms.entities.UsrGroupHabilitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GroupHabilitationRepository extends JpaRepository<UsrGroupHabilitation, Long>,
		QuerydslPredicateExecutor<UsrGroupHabilitation> {
}