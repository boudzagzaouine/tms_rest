package com.bagile.gmo.repositories;


import com.bagile.gmo.entities.PrmVille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface VilleRepository extends JpaRepository<PrmVille, Long>,
        QuerydslPredicateExecutor<PrmVille> {

}