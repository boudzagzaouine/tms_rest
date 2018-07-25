package com.bagile.tms.repositories;

import com.bagile.tms.entities.PdtUom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UomRepository extends JpaRepository<PdtUom, Long>,
		QuerydslPredicateExecutor<PdtUom> {
	public PdtUom findByPdtUomCode(String pdtUomCode);
}