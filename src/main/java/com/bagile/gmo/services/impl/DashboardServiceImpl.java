package com.bagile.gmo.services.impl;

import com.bagile.gmo.repositories.DashboardRepository;
import com.bagile.gmo.services.DashboardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;


@Service
@Transactional
public class DashboardServiceImpl implements DashboardService {


    private final DashboardRepository dashboardRepository;

    public DashboardServiceImpl(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }


    @Override
    public BigDecimal getAverageconsumptionvehicle(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) {
        return dashboardRepository.averageconsumptionvehicle( vehicleId,  CategoryId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getCorrectivemaintenancecostsbyvehicle(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) {
        return dashboardRepository.correctivemaintenancecostsbyvehicle(vehicleId,  CategoryId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getPreventivemaintenancecostsbyvehicle(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) {
        return dashboardRepository.preventivemaintenancecostsbyvehicle(vehicleId,  CategoryId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getTraveledmileagebyvechile(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) {
        return dashboardRepository.traveledmileagebyvechile(vehicleId,  CategoryId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getTotalnumberofproblemsbyvehicle(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) {
        return dashboardRepository.totalnumberofproblemsbyvehicle(vehicleId,  CategoryId,  dateDepart,  dateFin);
    }


    @Override
    public BigDecimal getAverageconsumptiondriver(long driverId, Date dateDepart, Date dateFin) {
        return dashboardRepository.averageconsumptiondriver( driverId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getCorrectivemaintenancecostsbydriver(long driverId, Date dateDepart, Date dateFin) {
        return dashboardRepository.correctivemaintenancecostsbydriver( driverId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getPreventivemaintenancecostsbydriver(long driverId, Date dateDepart, Date dateFin) {
        return dashboardRepository.preventivemaintenancecostsbydriver( driverId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getTraveledmileagebydriver(long driverId, Date dateDepart, Date dateFin) {
        return dashboardRepository.traveledmileagebydriver( driverId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getTotalnumberofproblemsbydriver(long driverId, Date dateDepart, Date dateFin) {
        return dashboardRepository.totalnumberofproblemsbydriver( driverId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getAverageconsumptionseniorityvehicle(long categoryid, long slice1, long slice2, long senioritymode) {
        return dashboardRepository.averageconsumptionvehicleseniorityvehicle( categoryid,  slice1,  slice2,  senioritymode);
    }

    @Override
    public BigDecimal getCorrectivemaintenancecostsbyseniorityvehicle(long categoryid, long slice1, long slice2, long senioritymode) {
        return dashboardRepository.correctivemaintenancecostsbyseniorityvehicle(categoryid,  slice1,  slice2,  senioritymode);
    }

    @Override
    public BigDecimal getPreventivemaintenancecostsbyseniorityvehicle(long categoryid, long slice1, long slice2, long senioritymode) {
        return dashboardRepository.preventivemaintenancecostsbyseniorityvehicle(categoryid,  slice1,  slice2,  senioritymode);
    }

    @Override
    public BigDecimal getTraveledmileagebyseniorityvehicle(long categoryid, long slice1, long slice2, long senioritymode) {
        return dashboardRepository.traveledmileagebyvechileseniorityvehicle(categoryid,  slice1,  slice2,  senioritymode);
    }

    @Override
    public BigDecimal getTotalnumberofproblemsbyseniorityvehicle(long categoryid, long slice1, long slice2, long senioritymode) {
        return dashboardRepository.totalnumberofproblemsbyseniorityvehicle(categoryid,  slice1,  slice2,  senioritymode);
    }
}

