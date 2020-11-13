package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TemplateRepository extends JpaRepository<Template,Long>, QuerydslPredicateExecutor<Template> {
}
