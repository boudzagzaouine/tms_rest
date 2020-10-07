package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface NotificationRepository extends JpaRepository<GmoNotification,Long>,
        QuerydslPredicateExecutor<GmoNotification> {
}