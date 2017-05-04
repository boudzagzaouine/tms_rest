package com.sinno.ems.repositories;

import com.sinno.ems.entities.InvSupplierLitigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface SupplierLitigationRepository extends JpaRepository<InvSupplierLitigation,Long>,QueryDslPredicateExecutor<InvSupplierLitigation> {

}
