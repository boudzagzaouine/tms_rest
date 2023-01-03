package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.CmdCompany;
import com.bagile.gmo.entities.GmoSupplierType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CmdCompany,Long>,
        QuerydslPredicateExecutor<CmdCompany>{


    @Query(value = "select nextVal('schema_tmsvoieexpress.seq_company_code')", nativeQuery = true)
    public List<BigInteger> getNextVal();

}
