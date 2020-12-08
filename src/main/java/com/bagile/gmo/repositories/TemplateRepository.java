package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TemplateRepository extends JpaRepository<GmoTemplate,Long>, QuerydslPredicateExecutor<GmoTemplate> {
}
