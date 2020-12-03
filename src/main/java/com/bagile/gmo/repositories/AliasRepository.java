package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.PdtAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AliasRepository extends JpaRepository<PdtAlias, Long>,
        QuerydslPredicateExecutor<PdtAlias> {
    public PdtAlias findByPdtAliasEanCode(String pdtAliasEanCode);


}