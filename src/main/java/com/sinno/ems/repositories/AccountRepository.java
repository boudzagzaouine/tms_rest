package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdAccount;
import com.sinno.ems.entities.PdtProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AccountRepository extends JpaRepository<CmdAccount, Long>,
		QueryDslPredicateExecutor<CmdAccount> {

	public CmdAccount findByCmdAccountCode(String cmdAccountCode);
	public CmdAccount findByCmdAccountCodeAndCmdAccountPassword(String cmdAccountCode,String cmdAccountPassword);

}