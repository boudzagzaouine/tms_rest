package com.bagile.tms.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.PdtProduct;
import com.bagile.gmo.entities.PdtProductPack;
import com.bagile.gmo.entities.PdtUom;

import java.util.List;

public interface ProductPackRepository extends JpaRepository<PdtProductPack, Long>,
		QuerydslPredicateExecutor<PdtProductPack> {
	List<PdtProductPack> findByPdtUomAndPdtProduct(PdtUom pdtUom, PdtProduct pdtProduct);
}