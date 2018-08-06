package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CategoryRepository extends JpaRepository<TmsCategory, Long>,
        QuerydslPredicateExecutor<TmsCategory> {
}
