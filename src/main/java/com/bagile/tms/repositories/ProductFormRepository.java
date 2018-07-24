package com.bagile.tms.repositories;

import com.sinno.ems.entities.PdtProductForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 13/03/2017.
 */
public interface ProductFormRepository extends QueryDslPredicateExecutor<PdtProductForm>, JpaRepository<PdtProductForm, Long> {
}
