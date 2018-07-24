package com.bagile.tms.repositories;

import com.sinno.ems.entities.PdtProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface ProductRepository extends JpaRepository<PdtProduct, Long>,
		QueryDslPredicateExecutor<PdtProduct> {
	@Query(value="select nextval('schema_ems.seq_product_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();

	public PdtProduct findByPdtProductCode(String pdtProductCode);
	@Query(value = "select sum(stk_stockquantity) from schema_ems.stk_stock where stk_stockproductid=:id and stk_stockblockid is null",nativeQuery = true)
	public BigDecimal stockQuantity(@Param("id") Long id);
	@Query(value = "select sum(stk_stockreservedquantity) from schema_ems.stk_stockreserved where stk_stockreservedproductid=:id",nativeQuery = true)
	public BigDecimal reservedQuantity(@Param("id") Long id);
	@Query(value = "select sum(stk_stockquantity) from schema_ems.stk_stock where stk_stockproductid=:id and stk_stockblockid is not null",nativeQuery = true)
	public BigDecimal blockedQuantity(@Param("id") Long id);
	@Query(value = "SELECT sum( COALESCE(cmd_saleorderline.cmd_saleorderlinequantity, 0)-COALESCE(cmd_saleorderline.cmd_saleorderlinequantityserved, 0)) FROM schema_ems.cmd_saleorderline  where  cmd_saleorderlinestatusid not in  (1,3,4) and cmd_saleorderlineproductid=:id",nativeQuery = true)
	public BigDecimal orderedQuantity(@Param("id") Long id);
	@Query(value = "SELECT  sum(  COALESCE(rcp_receptionlinequantity, 0)-COALESCE(rcp_receptionlinequantityreceived, 0)) FROM   schema_ems.rcp_receptionline  where  rcp_receptionlinestatusid not in  (1,3,4) and rcp_receptionlineproductid=:id",nativeQuery = true)
	public BigDecimal quantityToReceive(@Param("id") Long id);

}