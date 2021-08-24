package com.bagile.gmo.repositories;


import com.bagile.gmo.entities.PdtProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
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

	@Query(value = "select COALESCE(sum(stk_stockquantity),0) from schema_crm.stk_stock where stk_stockproductid=:id  and stk_stockactive=true", nativeQuery = true)
	BigDecimal stockQuantity(@Param("id") Long id);



}