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

    public BigDecimal averageconsumptionvehicle(long vehicleId,long CategoryId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.averageconsumptionvehicle(?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,CategoryId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal correctivemaintenancecostsbyvehicle(long vehicleId,long CategoryId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.correctivemaintenancecostsbyvehicle(?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,CategoryId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal preventivemaintenancecostsbyvehicle(long vehicleId,long CategoryId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.preventivemaintenancecostsbyvehicle(?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,CategoryId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal traveledmileagebyvechile(long vehicleId,long CategoryId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.traveledmileagebyvechile(?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,CategoryId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal totalnumberofproblemsbyvehicle(long vehicleId,long CategoryId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.totalnumberofproblemsbyvehicle(?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,CategoryId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }






    public BigDecimal averageconsumptiondriver(long driverId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.averageconsumptiondriver(?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal correctivemaintenancecostsbydriver(long driverId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.correctivemaintenancecostsbydriver(?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal preventivemaintenancecostsbydriver(long driverId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.preventivemaintenancecostsbydriver(?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal traveledmileagebydriver(long driverId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.traveledmileagebydriver(?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal totalnumberofproblemsbydriver(long driverId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.totalnumberofproblemsbydriver(?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }


 /* */


    public BigDecimal averageconsumptionvehicleseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.averageconsumptionseniorityvehicle(?,?,?,?)");
        query.setParameter(1,categoryid);
        query.setParameter(2,slice1);
        query.setParameter(3,slice2);
        query.setParameter(4,senioritymode);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal correctivemaintenancecostsbyseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.correctivemaintenancecostsbyseniorityvehicle(?,?,?,?)");
        query.setParameter(1,categoryid);
        query.setParameter(2,slice1);
        query.setParameter(3,slice2);
        query.setParameter(4,senioritymode);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal preventivemaintenancecostsbyseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.preventivemaintenancecostsbyseniorityvehicle(?,?,?,?)");
        query.setParameter(1,categoryid);
        query.setParameter(2,slice1);
        query.setParameter(3,slice2);
        query.setParameter(4,senioritymode);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal traveledmileagebyvechileseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.traveledmileagebyseniorityvehicle(?,?,?,?)");
        query.setParameter(1,categoryid);
        query.setParameter(2,slice1);
        query.setParameter(3,slice2);
        query.setParameter(4,senioritymode);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal totalnumberofproblemsbyseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_emsgc.totalnumberofproblemsbyseniorityvehicle(?,?,?,?)");
        query.setParameter(1,categoryid);
        query.setParameter(2,slice1);
        query.setParameter(3,slice2);
        query.setParameter(4,senioritymode);
        return (BigDecimal) query.getSingleResult();
    }


}
