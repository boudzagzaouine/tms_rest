package com.bagile.gmo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.math.BigDecimal;

// These are read-only KPI aggregates. Run them non-transactionally (each query
// auto-commits) so that if one stored function is missing/errors, the failure
// is isolated and returns 0 instead of poisoning a shared transaction whose
// later commit would then fail with HTTP 500.
@Repository
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TmsDashboardRepository {
    //@org.springframework.data.jpa.repository.Query(value = "SELECT * FROM schema_tmsvoieexpress.averageconsumptionvehicle(:vehicleId,:CategoryId,:3,:4)", nativeQuery = true)
    //public BigDecimal avg(String vehicleId,String CategoryId, String dateDepart,String dateFin);
    @PersistenceContext(unitName="entityManagerFactory")
    EntityManager em;
    public BigDecimal Vehiclemileage(String vehicleId,String trajetId,String categoryId,String marqueId ,String senioritymode, String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.total_mileage_vehicle(?,?,?,?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,trajetId);
        query.setParameter(3,categoryId);
        query.setParameter(4, marqueId);
        query.setParameter(5, senioritymode);
        query.setParameter(6,dateDepart);
        query.setParameter(7,dateFin);
        return scalarOrZero(query);
    }

    public BigDecimal numberTrajetsVehicle(String vehicleId,String trajetId,String categoryId,String marqueId,String senioritymode, String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.number_trajetvehicle(?,?,?,?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,trajetId);
        query.setParameter(3,categoryId);
        query.setParameter(4, marqueId);
        query.setParameter(5, senioritymode);
        query.setParameter(6,dateDepart);
        query.setParameter(7,dateFin);
        return scalarOrZero(query);
    }

    public BigDecimal numberTrajetsDriver(String driverId,String trajetId,String dateDepart, String dateFin)
    {

        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.number_trajetdriver(?,?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,trajetId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return scalarOrZero(query);

    }
    public BigDecimal Drivermileage(String driverId,String trajetId,String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.total_mileage_driver(?,?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,trajetId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return scalarOrZero(query);
    }
    public BigDecimal AvgDurationTrajet(String driverId,String trajetId,String dateDepart, String dateFin)
    {

        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duree_trajet_driver(?,?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,trajetId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return scalarOrZero(query);
    }
    public BigDecimal AvgDurationTrajetVehicle(String vehicleId,String trajetId,String categoryId,String marqueId,String senioritymode ,String dateDepart, String dateFin)
    {

        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duree_trajet_vehicle(?,?,?,?,?,?,?)");
        query.setParameter(1, vehicleId);
        query.setParameter(2, trajetId);
        query.setParameter(3, categoryId);
        query.setParameter(4, marqueId);
        query.setParameter(5, senioritymode);
        query.setParameter(6,dateDepart);
        query.setParameter(7,dateFin);
        return scalarOrZero(query);
    }
    public BigDecimal AvgDurationTrajetAttent(String driverId,String trajetId,String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duree_trajet_attentdriver(?,?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,trajetId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return scalarOrZero(query);
    }
    public BigDecimal AvgDurationTrajetAttentvehicle(String vehicleId,String trajetId,String categoryId,String marqueId ,String senioritymode, String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duree_trajet_attentvehicle(?,?,?,?,?,?,?)");
        query.setParameter(1, vehicleId);
        query.setParameter(2, trajetId);
        query.setParameter(3, categoryId);
        query.setParameter(4, marqueId);
        query.setParameter(5, senioritymode);
        query.setParameter(6,dateDepart);
        query.setParameter(7,dateFin);
        return scalarOrZero(query);
    }
    public BigDecimal AvgDurationOperationTrajet(String driverId,String trajetId, String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duration_operation_trajetdriver(?,?,?,?)");
        query.setParameter(1, driverId);
        query.setParameter(2, trajetId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return scalarOrZero(query);
    }
    public BigDecimal AvgDurationOperationTrajetVehicle(String vehicleId,String trajetId,String categoryId,String marqueId ,String senioritymode, String dateDepart, String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.avg_duration_operation_trajetvehicle(?,?,?,?,?,?,?)");
        query.setParameter(1, vehicleId);
        query.setParameter(2, trajetId);
        query.setParameter(3, categoryId);
        query.setParameter(4, marqueId);
        query.setParameter(5, senioritymode);
        query.setParameter(6,dateDepart);
        query.setParameter(7,dateFin);
        return scalarOrZero(query);
    }
    public BigDecimal refused_transportplan(String transportId,String dateDepart,String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.transportplan_refused(?,?,?)");
        query.setParameter(1,transportId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return scalarOrZero(query);
    }
    public BigDecimal valider_transportplan(String transportId,String dateDepart,String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.transportplan_validé(?,?,?)");
        query.setParameter(1,transportId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return scalarOrZero(query);
    }
    public BigDecimal canceled_transportplan(String transportId,String dateDepart,String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.transportplan_canceled(?,?,?)");
        query.setParameter(1,transportId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return scalarOrZero(query);
    }
    public BigDecimal rejected_transportplan(String transportId,String dateDepart,String dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_tmsvoieexpress.transportplan_rejected(?,?,?)");
        query.setParameter(1,transportId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return scalarOrZero(query);
    }

    /**
     * Runs a scalar KPI query, returning 0 instead of propagating an error.
     * Several dashboard aggregates rely on Postgres stored functions
     * (transportplan_refused, total_mileage_vehicle, ...) that are provisioned
     * per-environment. Where a function is missing (or the query otherwise
     * fails) the dashboard should show 0, not return HTTP 500 and break the
     * whole page.
     */
    private BigDecimal scalarOrZero(Query query) {
        try {
            Object result = query.getSingleResult();
            return result == null ? BigDecimal.ZERO : (BigDecimal) result;
        } catch (Exception e) {
            LOGGER.warn("dashboard KPI query failed ({}), returning 0", e.getMessage());
            return BigDecimal.ZERO;
        }
    }

    private static final org.slf4j.Logger LOGGER =
            org.slf4j.LoggerFactory.getLogger(TmsDashboardRepository.class);
}
