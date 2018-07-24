package com.bagile.tms.repositories;

import com.sinno.ems.entities.PdtProductDimension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 15/03/2017.
 */
public interface ProductDimensionRepository extends JpaRepository<PdtProductDimension, Long>, QueryDslPredicateExecutor<PdtProductDimension> {
}
