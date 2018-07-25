package com.bagile.tms.repositories;

import com.bagile.tms.entities.PdtProductDimension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by Enissay on 15/03/2017.
 */
public interface ProductDimensionRepository extends JpaRepository<PdtProductDimension, Long>, QuerydslPredicateExecutor<PdtProductDimension> {
}
