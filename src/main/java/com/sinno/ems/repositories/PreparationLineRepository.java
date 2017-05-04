package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdPreparationLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface PreparationLineRepository extends JpaRepository<CmdPreparationLine,Long>,QueryDslPredicateExecutor<CmdPreparationLine> {
}
