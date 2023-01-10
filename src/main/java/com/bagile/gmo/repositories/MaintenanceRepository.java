package com.bagile.gmo.repositories;

import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.entities.GmoMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;


public interface MaintenanceRepository extends JpaRepository<GmoMaintenance,Long>,
        QuerydslPredicateExecutor<GmoMaintenance>{
    @Query(value="select nextval('schema_crmexpress.seq_gmo_diesel_declaration_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();


    @Query(value="select  * from schema_crmexpress.gmo_maintenance m\n" +
            "where m.gmo_actiontypeid =1\n" +
            "  and m.gmopatrimony_gmo_patrimonyid=8\n" +
            "  and m.gmo_maintenancestateid=4\n" +
            "order by m.gmo_maintenanceid desc limit 1",nativeQuery = true)
    public Maintenance getMaintenanceByActionType( long actionTypeId, long patrimonyId);
}
