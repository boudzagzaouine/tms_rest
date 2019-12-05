package com.bagile.tms.repositories;


import com.bagile.tms.entities.PdtProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface ProductRepository extends JpaRepository<PdtProduct, Long>,
		QuerydslPredicateExecutor<PdtProduct> {
	@Query(value="select nextval('schema_emswms.seq_product_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();
	@Query(value = "select p.pdtProductId from PdtProduct p where p.pdtProductIsActive=true")
	public List<Long> getIds();
	public PdtProduct findByPdtProductCode(String pdtProductCode);
	@Query(value = "select p.pdtProductCode from PdtProduct p ")
	List<String> getPendingProductsCodes();

	@Query(value = "select p.pdtProductCode from PdtProduct p where  p.pdtProductCode LIKE %:code%")
	List<String> getProductsCodes(@Param("code") String code);
}