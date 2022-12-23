package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.CmdAccount;
import com.bagile.gmo.entities.TmsContractAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface ContractAccountRepository extends JpaRepository<TmsContractAccount, Long>,
		QuerydslPredicateExecutor<TmsContractAccount> {


	@Query(value = "select nextVal('schema_crmexpress.seq_contract_account_code')", nativeQuery = true)
	public List<BigInteger> getNextVal();

}