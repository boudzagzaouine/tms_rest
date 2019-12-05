package com.bagile.tms.repositories;


import com.bagile.tms.entities.PdtProduct;
import com.bagile.tms.entities.PdtProductPack;
import com.bagile.tms.entities.PdtUom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ProductPackRepository extends JpaRepository<PdtProductPack, Long>,
		QuerydslPredicateExecutor<PdtProductPack> {
	List<PdtProductPack> findByPdtUomAndPdtProduct(PdtUom pdtUom, PdtProduct pdtProduct);
}