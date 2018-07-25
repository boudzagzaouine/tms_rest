package com.bagile.tms.repositories;

import com.bagile.tms.entities.PdtProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProductTypeRepository extends JpaRepository<PdtProductType, Long>,
		QuerydslPredicateExecutor<PdtProductType> {
	public PdtProductType findByPdtProductTypeCode(String pdtProductTypeCode);

}