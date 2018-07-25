package com.bagile.tms.repositories;

import com.bagile.tms.entities.PdtAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AliasRepository extends JpaRepository<PdtAlias, Long>,
        QuerydslPredicateExecutor<PdtAlias> {
    public PdtAlias findByPdtAliasEanCode(String pdtAliasEanCode);
}