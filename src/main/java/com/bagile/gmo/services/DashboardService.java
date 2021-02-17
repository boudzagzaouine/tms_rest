package com.bagile.gmo.services;

import java.math.BigDecimal;
import java.util.Date;

public interface DashboardService {



    BigDecimal getAverageconsumptionvehicle(long vehicleId,long CategoryId, Date dateDepart, Date dateFin);

    BigDecimal getCorrectivemaintenancecostsbyvehicle(long vehicleId,long CategoryId, Date dateDepart, Date dateFin);

    BigDecimal getPreventivemaintenancecostsbyvehicle(long vehicleId,long CategoryId, Date dateDepart, Date dateFin);

    BigDecimal getTraveledmileagebyvechile(long vehicleId,long CategoryId, Date dateDepart, Date dateFin);

    BigDecimal getTotalnumberofproblemsbyvehicle(long vehicleId,long CategoryId, Date dateDepart, Date dateFin);




    BigDecimal getAverageconsumptiondriver(long driverId, Date dateDepart, Date dateFin);

    BigDecimal getCorrectivemaintenancecostsbydriver(long driverId, Date dateDepart, Date dateFin);

    BigDecimal getPreventivemaintenancecostsbydriver(long driverId, Date dateDepart, Date dateFin);

    BigDecimal getTraveledmileagebydriver(long driverId, Date dateDepart, Date dateFin);

    BigDecimal getTotalnumberofproblemsbydriver(long driverId, Date dateDepart, Date dateFin);



    BigDecimal getAverageconsumptionseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode);

    BigDecimal getCorrectivemaintenancecostsbyseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode);

    BigDecimal getPreventivemaintenancecostsbyseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode);

    BigDecimal getTraveledmileagebyseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode);

    BigDecimal getTotalnumberofproblemsbyseniorityvehicle(long categoryid, long slice1,long slice2,long senioritymode);




}
