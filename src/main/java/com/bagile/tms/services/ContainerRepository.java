package com.bagile.tms.services;

import com.bagile.tms.entities.StkContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface ContainerRepository extends JpaRepository<StkContainer, Long>,
        QuerydslPredicateExecutor<StkContainer> {


    public StkContainer findByStkContainerCode(String stkContainerCode);
}