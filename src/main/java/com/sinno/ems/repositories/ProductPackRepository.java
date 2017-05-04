package com.sinno.ems.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.sinno.ems.entities.PdtProduct;
import com.sinno.ems.entities.PdtProductPack;
import com.sinno.ems.entities.PdtUom;

public interface ProductPackRepository extends JpaRepository<PdtProductPack, Long>,
		QueryDslPredicateExecutor<PdtProductPack> {
	public List<PdtProductPack> findByPdtUomAndPdtProduct(PdtUom pdtUom, PdtProduct pdtProduct);
}