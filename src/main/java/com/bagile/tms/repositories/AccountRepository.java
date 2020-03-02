package com.bagile.tms.repositories;

import com.bagile.tms.entities.CmdAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountRepository extends JpaRepository<CmdAccount, Long>,
		QuerydslPredicateExecutor<CmdAccount> {

	CmdAccount findByCmdAccountCode(String cmdAccountCode);
	CmdAccount findByCmdAccountCodeAndCmdAccountPassword(String cmdAccountCode,String cmdAccountPassword);

	@Query(value = "select nextVal('schema_crm.seq_account_code')", nativeQuery = true)
	Long getNextVal();

}