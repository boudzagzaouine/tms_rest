package com.bagile.tms.repositories;

import com.sinno.ems.entities.CmdCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface CompanyRepository extends JpaRepository<CmdCompany, Long>,
		QueryDslPredicateExecutor<CmdCompany> {

	public CmdCompany findByCmdCompanyCode(String cmdCompanyCode);

}