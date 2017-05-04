package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpAssetSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 20/12/2016.
 */
public interface AssetSupplierRepository extends JpaRepository<RcpAssetSupplier, Long>, QueryDslPredicateExecutor<RcpAssetSupplier> {
}
