package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 02/01/2017.
 */
public interface BankAccountRepository extends JpaRepository<PrmBankAccount,Long>,QueryDslPredicateExecutor<PrmBankAccount> {
}
