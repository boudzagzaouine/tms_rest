package com.bagile.tms.repositories;

import com.sinno.ems.entities.PdtUom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UomRepository extends JpaRepository<PdtUom, Long>,
		QueryDslPredicateExecutor<PdtUom> {
	public PdtUom findByPdtUomCode(String pdtUomCode);
}