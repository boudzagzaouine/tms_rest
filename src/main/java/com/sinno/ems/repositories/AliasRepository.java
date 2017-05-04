package com.sinno.ems.repositories;

import com.sinno.ems.entities.PdtAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AliasRepository extends JpaRepository<PdtAlias, Long>,
        QueryDslPredicateExecutor<PdtAlias> {
    public PdtAlias findByPdtAliasEanCode(String pdtAliasEanCode);
}