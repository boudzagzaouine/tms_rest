package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.CmdActivityArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by fama on 08/03/2017.
 */
public interface ActivityAreaRepository extends JpaRepository<CmdActivityArea, Long>,
        QuerydslPredicateExecutor<CmdActivityArea> {
}
