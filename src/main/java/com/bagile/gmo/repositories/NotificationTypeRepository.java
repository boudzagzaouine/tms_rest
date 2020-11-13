package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoNotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface NotificationTypeRepository extends JpaRepository<GmoNotificationType,Long>,
        QuerydslPredicateExecutor<GmoNotificationType> {
}