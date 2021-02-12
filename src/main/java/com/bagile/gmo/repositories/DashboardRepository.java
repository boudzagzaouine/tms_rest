package com.bagile.gmo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Date;

@Repository
@Transactional
public class DashboardRepository {

    @PersistenceContext(unitName="entityManagerFactory")
    EntityManager em;

    public BigDecimal averageConsumption(long vehicleId, Date dateDepart,Date dateFin,long CategoryId)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_ems.averageConsumption(?, ?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        query.setParameter(4,CategoryId);
        return (BigDecimal) query.getSingleResult();
    }

    /*@Query(value = "select averageConsumption (:vehicleId,:dateDepart,:dateFin,:CategoryId)",nativeQuery = true)
    Long averageConsumption(@Param("vehicleId") long vehicleId,
                            @Param("dateDepart") Date dateDepart,
                            @Param("dateFin") Date dateFin,
                            @Param("CategoryId")long CategoryId);*/



    /*Long mileageTraveled();
    BigDecimal costOfcorrectiveMaintenance();
    BigDecimal costOfPreventiveMaintenance();
    Long totalNumberOfproblemsGenerated ();*/

}
