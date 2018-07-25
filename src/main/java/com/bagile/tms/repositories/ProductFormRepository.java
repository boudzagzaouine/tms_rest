package com.bagile.tms.repositories;

import com.bagile.tms.entities.PdtProductForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by Enissay on 13/03/2017.
 */
public interface ProductFormRepository extends QuerydslPredicateExecutor<PdtProductForm>, JpaRepository<PdtProductForm, Long> {
}
