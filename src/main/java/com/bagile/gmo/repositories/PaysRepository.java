package com.bagile.gmo.repositories;


import com.bagile.gmo.entities.PrmPays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PaysRepository extends JpaRepository<PrmPays, Long>,
        QuerydslPredicateExecutor<PrmPays> {

}