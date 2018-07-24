package com.bagile.tms.repositories;

import com.sinno.ems.entities.PdtProduct;
import com.sinno.ems.entities.PdtProductPack;
import com.sinno.ems.entities.PdtUom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface ProductPackRepository extends JpaRepository<PdtProductPack, Long>,
		QueryDslPredicateExecutor<PdtProductPack> {
	public List<PdtProductPack> findByPdtUomAndPdtProduct(PdtUom pdtUom, PdtProduct pdtProduct);
}