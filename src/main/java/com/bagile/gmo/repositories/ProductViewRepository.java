package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.PdtProductView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface ProductViewRepository extends JpaRepository<PdtProductView, Long>,
        QuerydslPredicateExecutor<PdtProductView> {
}
