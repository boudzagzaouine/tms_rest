package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.CmdSaleOrder;

import java.math.BigInteger;
import java.util.List;

public interface SaleOrderRepository extends JpaRepository<CmdSaleOrder, Long>,
		QuerydslPredicateExecutor<CmdSaleOrder> {
	@Query(value="select nextval('schema_crmexpress.seq_sale_order_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();
	@Query(value = "select nextval('schema_crmexpress.seq_code_transfert')",nativeQuery = true)
	public List<BigInteger> getTransferCode();
	public CmdSaleOrder findByCmdSaleOrderCode(String cmdSaleOrderCode);

}