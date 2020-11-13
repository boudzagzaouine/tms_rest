package com.bagile.gmo.repositories;

import com.bagile.gmo.config.mail.MailConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MailConfigRepository extends JpaRepository<MailConfig, Long>, QuerydslPredicateExecutor<MailConfig> {
}
