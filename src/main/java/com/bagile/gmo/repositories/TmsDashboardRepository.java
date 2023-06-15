package com.bagile.gmo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Optional;

@Repository
@Transactional
public class TmsDashboardRepository {
    //@org.springframework.data.jpa.repository.Query(value = "SELECT * FROM schema_tmsvoieexpress.averageconsumptionvehicle(:vehicleId,:CategoryId,:3,:4)", nativeQuery = true)
    //public BigDecimal avg(String vehicleId,String CategoryId, String dateDepart,String dateFin);
    @PersistenceContext(unitName="entityManagerFactory")
    EntityManager em;
    public BigDecimal Vehiclemileage(String vehicleId,String trajetId,String categoryId, String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.vehicle_total_mileage(?,?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,trajetId);
        query.setParameter(3,categoryId);
        query.setParameter(4,dateDepart);
        query.setParameter(5,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal numberTrajetsVehicle(String vehicleId,String trajetId,String categoryId, String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.number_trajets_vehicle(?,?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,trajetId);
        query.setParameter(3,categoryId);
        query.setParameter(4,dateDepart);
        query.setParameter(5,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal numberTrajetsDriver(String driverId,String trajetId,String dateDepart, String dateFin)
    {

        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.number_trajets_driver(?,?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,trajetId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();

    }
    public BigDecimal Drivermileage(String driverId,String trajetId,String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.driver_total_mileage(?,?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,trajetId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
    public BigDecimal AvgDurationTrajet(String driverId,String trajetId,String dateDepart, String dateFin)
    {

        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duree_trajet(?,?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,trajetId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
    public BigDecimal AvgDurationTrajetVehicle(String vehicleId,String trajetId,String categoryId ,String dateDepart, String dateFin)
    {

        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duree_trajet_vehicle(?,?,?,?,?)");
        query.setParameter(1, vehicleId);
        query.setParameter(2, trajetId);
        query.setParameter(3, categoryId);
        query.setParameter(4,dateDepart);
        query.setParameter(5,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
    public BigDecimal AvgDurationTrajetAttent(String driverId,String trajetId,String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duree_trajet_attent(?,?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,trajetId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
    public BigDecimal AvgDurationTrajetAttentvehicle(String vehicleId,String trajetId,String categoryId ,String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duree_trajet_attent_vehicle(?,?,?,?,?)");
        query.setParameter(1, vehicleId);
        query.setParameter(2, trajetId);
        query.setParameter(3, categoryId);
        query.setParameter(4,dateDepart);
        query.setParameter(5,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
    public BigDecimal AvgDurationOperationTrajet(String driverId,String trajetId, String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duration_operation_trajet(?,?,?,?)");
        query.setParameter(1, driverId);
        query.setParameter(2, trajetId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
    public BigDecimal AvgDurationOperationTrajetVehicle(String vehicleId,String trajetId,String categoryId ,String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duration_operation_trajet_vehicle(?,?,?,?,?)");
        query.setParameter(1, vehicleId);
        query.setParameter(2, trajetId);
        query.setParameter(3, categoryId);
        query.setParameter(4,dateDepart);
        query.setParameter(5,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
    public BigDecimal refused_transportplan(String transportId,String dateDepart,String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.transportplan_refused(?,?,?)");
        query.setParameter(1,transportId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
    public BigDecimal valider_transportplan(String transportId,String dateDepart,String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.transportplanvalider(?,?,?)");
        query.setParameter(1,transportId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
    public BigDecimal canceled_transportplan(String transportId,String dateDepart,String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.transportplan_canceled(?,?,?)");
        query.setParameter(1,transportId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
    public BigDecimal rejected_transportplan(String transportId,String dateDepart,String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.transportplan_rejected(?,?,?)");
        query.setParameter(1,transportId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }
}
