package com.bagile.tms.repositories;

import com.sinno.ems.entities.PdtProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ProductTypeRepository extends JpaRepository<PdtProductType, Long>,
		QueryDslPredicateExecutor<PdtProductType> {
	public PdtProductType findByPdtProductTypeCode(String pdtProductTypeCode);

}