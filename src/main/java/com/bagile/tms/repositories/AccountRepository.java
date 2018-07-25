package com.bagile.tms.repositories;

import com.bagile.tms.entities.CmdAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountRepository extends JpaRepository<CmdAccount, Long>,
		QuerydslPredicateExecutor<CmdAccount> {

	public CmdAccount findByCmdAccountCode(String cmdAccountCode);
	public CmdAccount findByCmdAccountCodeAndCmdAccountPassword(String cmdAccountCode, String cmdAccountPassword);

}