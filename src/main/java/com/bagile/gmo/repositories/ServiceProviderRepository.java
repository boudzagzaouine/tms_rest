package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ServiceProviderRepository extends JpaRepository<GmoServiceProvider,Long>,
        QuerydslPredicateExecutor<GmoServiceProvider> {
}