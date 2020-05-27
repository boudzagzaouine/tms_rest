package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoMachine;
import com.bagile.gmo.entities.GmoPatrimony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface PatrimonyRepository extends JpaRepository<GmoPatrimony,Long>,
        QuerydslPredicateExecutor<GmoPatrimony> {
}
