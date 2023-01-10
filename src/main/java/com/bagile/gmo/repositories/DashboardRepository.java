package com.bagile.gmo.repositories;

import com.bagile.gmo.dto.Maintenance;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class DashboardRepository {

    @PersistenceContext(unitName="entityManagerFactory")
    EntityManager em;

    public BigDecimal averageconsumptionvehicle(long vehicleId,long CategoryId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.averageconsumptionvehicle(?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,CategoryId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal correctivemaintenancecostsbyvehicle(long vehicleId,long CategoryId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.correctivemaintenancecostsbyvehicle(?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,CategoryId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal preventivemaintenancecostsbyvehicle(long vehicleId,long CategoryId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.preventivemaintenancecostsbyvehicle(?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,CategoryId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal traveledmileagebyvechile(long vehicleId,long CategoryId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.traveledmileagebyvechile(?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,CategoryId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal totalnumberofproblemsbyvehicle(long vehicleId,long CategoryId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.totalnumberofproblemsbyvehicle(?,?,?,?)");
        query.setParameter(1,vehicleId);
        query.setParameter(2,CategoryId);
        query.setParameter(3,dateDepart);
        query.setParameter(4,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public List<Maintenance> statisticMaintenance(long vehicleId, long CategoryId, Date dateDepart, Date dateFin)
    {
        Query query = em.createNativeQuery("select * from schema_crmexpress.gmo_maintenance where schema_crmexpress.gmo_maintenance.gmopatrimony_gmo_patrimonyid=? and schema_crmexpress.gmo_maintenance.gmo_maintenancemaintenancedate between ? and ? ");
        query.setParameter(1,vehicleId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);

        return   query.getResultList();
    }






    public BigDecimal averageconsumptiondriver(long driverId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.averageconsumptiondriver(?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal correctivemaintenancecostsbydriver(long driverId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.correctivemaintenancecostsbydriver(?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal preventivemaintenancecostsbydriver(long driverId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.preventivemaintenancecostsbydriver(?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal traveledmileagebydriver(long driverId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.traveledmileagebydriver(?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal totalnumberofproblemsbydriver(long driverId, Date dateDepart,Date dateFin)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.totalnumberofproblemsbydriver(?,?,?)");
        query.setParameter(1,driverId);
        query.setParameter(2,dateDepart);
        query.setParameter(3,dateFin);
        return (BigDecimal) query.getSingleResult();
    }

    public List<Object> getPercentGasoilByDriver()
    {
        Query query = em.createNativeQuery("select distinct gmo_drivercode,gmo_drivercin,gmo_driverdateofassignment,\n" +
                "sum(gmo_dieseldeclaration.gmo_dieseldeclarationamount) as amount,((sum(gmo_dieseldeclaration.gmo_dieseldeclarationamount)*100)/(select sum(gmo_dieseldeclaration.gmo_dieseldeclarationamount) from schema_crmexpress.gmo_dieseldeclaration )) as average\n" +
                "from schema_crmexpress.gmo_driver ,schema_crmexpress.gmo_dieseldeclaration\n" +
                "where gmo_dieseldeclaration.gmo_gmodriver=gmo_driver.gmo_driverid\n" +
                "group by gmo_drivercode,gmo_drivercin,gmo_driverdateofassignment");
        return (List<Object>) query.getResultList();
    }


 /* */


    public BigDecimal averageconsumptionvehicleseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.averageconsumptionseniorityvehicle(?,?,?,?)");
        query.setParameter(1,categoryid);
        query.setParameter(2,slice1);
        query.setParameter(3,slice2);
        query.setParameter(4,senioritymode);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal correctivemaintenancecostsbyseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.correctivemaintenancecostsbyseniorityvehicle(?,?,?,?)");
        query.setParameter(1,categoryid);
        query.setParameter(2,slice1);
        query.setParameter(3,slice2);
        query.setParameter(4,senioritymode);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal preventivemaintenancecostsbyseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.preventivemaintenancecostsbyseniorityvehicle(?,?,?,?)");
        query.setParameter(1,categoryid);
        query.setParameter(2,slice1);
        query.setParameter(3,slice2);
        query.setParameter(4,senioritymode);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal traveledmileagebyvechileseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.traveledmileagebyseniorityvehicle(?,?,?,?)");
        query.setParameter(1,categoryid);
        query.setParameter(2,slice1);
        query.setParameter(3,slice2);
        query.setParameter(4,senioritymode);
        return (BigDecimal) query.getSingleResult();
    }

    public BigDecimal totalnumberofproblemsbyseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode)
    {
        Query query = em.createNativeQuery("SELECT * FROM schema_crmexpress.totalnumberofproblemsbyseniorityvehicle(?,?,?,?)");
        query.setParameter(1,categoryid);
        query.setParameter(2,slice1);
        query.setParameter(3,slice2);
        query.setParameter(4,senioritymode);
        return (BigDecimal) query.getSingleResult();
    }


}
