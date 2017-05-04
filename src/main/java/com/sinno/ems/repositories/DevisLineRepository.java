package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdDevisLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 06/12/2016.
 */
public interface DevisLineRepository extends JpaRepository<CmdDevisLine,Long>,QueryDslPredicateExecutor<CmdDevisLine> {
}
