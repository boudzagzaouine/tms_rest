package com.bagile.gmo.services.impl;

import com.bagile.gmo.repositories.TmsDashboardRepository;
import com.bagile.gmo.services.TmsDashboardService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TmsDashboardServiceImpl implements TmsDashboardService {
    private final TmsDashboardRepository tmsDashboardRepository;

    public TmsDashboardServiceImpl( TmsDashboardRepository tmsDashboardRepository) {
        this.tmsDashboardRepository = tmsDashboardRepository;
    }

    @Override
    public BigDecimal getVehiclemileage(String vehicleId,String trajetId,String categoryId ,String marqueId,String senioritymode, String dateDepart, String dateFin) {
        return tmsDashboardRepository.Vehiclemileage(vehicleId, trajetId,categoryId,marqueId,senioritymode,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getVehicleNumberTrajets(String vehicleId,String trajetId, String categoryId,String marqueId,String senioritymode, String dateDepart, String dateFin) {
        return tmsDashboardRepository.numberTrajetsVehicle(vehicleId, trajetId,categoryId,marqueId,senioritymode,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getDriverNumberTrajets(String driverId,String trajetId,String dateDepart, String dateFin) {
        return tmsDashboardRepository.numberTrajetsDriver(driverId,trajetId,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getAvgdurationtrajet(String driverId, String trajetId, String dateDepart, String dateFin) {
        return tmsDashboardRepository.AvgDurationTrajet( driverId, trajetId,  dateDepart, dateFin);
    }

    @Override
    public BigDecimal getAvgdurationtrajetAttent(String driverId, String trajetId, String dateDepart, String dateFin) {
        return tmsDashboardRepository.AvgDurationTrajetAttent(driverId, trajetId,  dateDepart, dateFin);
    }

    @Override
    public BigDecimal getdrivermileage(String driverId,String trajetId,String dateDepart, String dateFin) {
        return tmsDashboardRepository.Drivermileage(driverId,trajetId,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getrefusedtransportplan(String transportId,String dateDepart, String dateFin) {
        return tmsDashboardRepository.refused_transportplan(transportId,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getAvgDurationOperationTrajetVehicle(String vehicleId, String trajetId, String categoryId,String marqueId,String senioritymode, String dateDepart, String dateFin) {
        return tmsDashboardRepository.AvgDurationOperationTrajetVehicle(vehicleId,trajetId,categoryId,marqueId,senioritymode, dateDepart,dateFin);
    }

    @Override
    public BigDecimal getAvgdurationtrajetAttentVehicle(String vehicleId, String trajetId, String categoryId, String marqueId,String senioritymode, String dateDepart, String dateFin) {
        return tmsDashboardRepository.AvgDurationTrajetAttentvehicle(vehicleId,trajetId,categoryId,marqueId,senioritymode, dateDepart,dateFin);
    }

    @Override
    public BigDecimal getAvgdurationtrajetVehicle(String vehicleId, String trajetId, String categoryId,String marqueId,String senioritymode, String dateDepart, String dateFin) {
        return tmsDashboardRepository.AvgDurationTrajetVehicle(vehicleId,trajetId,categoryId,marqueId,senioritymode,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getAvgDurationOperationTrajet(String driverId, String trajetId, String dateDepart, String dateFin) {
        return tmsDashboardRepository.AvgDurationOperationTrajet(driverId,trajetId,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getvalidertransportplan(String transportId,String dateDepart, String dateFin) {
        return tmsDashboardRepository.valider_transportplan(transportId,dateDepart,dateFin);
    }
    @Override
    public BigDecimal getcanceledtransportplan(String transportId,String dateDepart, String dateFin) {
        return tmsDashboardRepository.canceled_transportplan(transportId,dateDepart,dateFin);
    }
    @Override
    public BigDecimal getrectedtransportplan(String transportId,String dateDepart, String dateFin) {
        return tmsDashboardRepository.rejected_transportplan(transportId,dateDepart,dateFin);
    }
}
