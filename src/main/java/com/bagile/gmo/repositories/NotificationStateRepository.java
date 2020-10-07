package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoNotificationState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface NotificationStateRepository extends JpaRepository<GmoNotificationState,Long>,
        QuerydslPredicateExecutor<GmoNotificationState> {
}