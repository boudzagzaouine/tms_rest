package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.CmdAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface AccountRepository extends JpaRepository<CmdAccount, Long>,
		QuerydslPredicateExecutor<CmdAccount> {

	CmdAccount findByCmdAccountCode(String cmdAccountCode);
	CmdAccount findByCmdAccountCodeAndCmdAccountPassword(String cmdAccountCode,String cmdAccountPassword);

	@Query(value = "select nextVal('schema_tmsvoieexpress.seq_account_code')", nativeQuery = true)
	public List<BigInteger> getNextVal();

}