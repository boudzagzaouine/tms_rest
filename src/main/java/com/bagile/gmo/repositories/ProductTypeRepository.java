package com.bagile.gmo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.PdtProductType;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<PdtProductType, Long>,
		QuerydslPredicateExecutor<PdtProductType> {
	PdtProductType findByPdtProductTypeCode(String pdtProductTypeCode);

	List<PdtProductType> findByPdtProductTypeParentNull();

}