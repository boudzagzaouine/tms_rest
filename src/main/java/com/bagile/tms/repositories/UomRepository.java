package com.bagile.tms.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.PdtUom;

public interface UomRepository extends JpaRepository<PdtUom, Long>,
		QuerydslPredicateExecutor<PdtUom> {
		PdtUom findFirstByPdtUomCode(String pdtUomCode);
}