package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdSaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface SaleOrderRepository extends JpaRepository<CmdSaleOrder, Long>,
		QueryDslPredicateExecutor<CmdSaleOrder> {
	@Query(value="select nextval('schema_ems.seq_sale_order_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();
	@Query(value = "select nextval('schema_ems.seq_code_transfert')",nativeQuery = true)
	public List<BigInteger> getTransferCode();
	public CmdSaleOrder findByCmdSaleOrderCode(String cmdSaleOrderCode);

}