package com.bagile.tms.repositories;

import com.bagile.tms.entities.CmdCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CompanyRepository extends JpaRepository<CmdCompany, Long>,
		QuerydslPredicateExecutor<CmdCompany> {

	public CmdCompany findByCmdCompanyCode(String cmdCompanyCode);

}