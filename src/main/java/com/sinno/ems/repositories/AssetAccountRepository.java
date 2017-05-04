package com.sinno.ems.repositories;

import com.sinno.ems.entities.CmdAssetAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 16/12/2016.
 */
public interface AssetAccountRepository extends JpaRepository<CmdAssetAccount,Long>,QueryDslPredicateExecutor<CmdAssetAccount> {
}
