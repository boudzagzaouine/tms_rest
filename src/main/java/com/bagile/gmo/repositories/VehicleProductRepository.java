package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.CmdCompany;
import com.bagile.gmo.entities.GmoVehicle;
import com.bagile.gmo.entities.GmoVehicleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleProductRepository extends JpaRepository<GmoVehicleProduct,Long>,
        QuerydslPredicateExecutor<GmoVehicleProduct>{

}
