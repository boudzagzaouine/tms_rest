package com.bagile.gmo.services.impl;

import com.bagile.gmo.repositories.TmsDashboardRepository;
import com.bagile.gmo.services.TmsDashboardService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class TmsDashboardServiceImpl implements TmsDashboardService {
    private final TmsDashboardRepository tmsDashboardRepository;

    public TmsDashboardServiceImpl( TmsDashboardRepository tmsDashboardRepository) {
        this.tmsDashboardRepository = tmsDashboardRepository;
    }

    @Override
    public BigDecimal getVehiclemileage(long vehicleId,long categoryId ,Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.Vehiclemileage(vehicleId,categoryId,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getVehicleNumberTrajets(long vehicleId, long categoryId, Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.numberTrajetsVehicle(vehicleId,categoryId,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getDriverNumberTrajets(long driverId,Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.numberTrajetsDriver(driverId,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getAvgdurationtrajet(long driverId,long operationId, long trajetId, Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.AvgDurationTrajet( driverId,operationId, trajetId,  dateDepart, dateFin);
    }

    @Override
    public BigDecimal getAvgdurationtrajetAttent(long driverId,long operationId, long trajetId, Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.AvgDurationTrajetAttent(driverId,operationId, trajetId,  dateDepart, dateFin);
    }

    @Override
    public BigDecimal getdrivermileage(long driverId,long trajetId,Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.Drivermileage(driverId,trajetId,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getrefusedtransportplan(long transportId,Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.refused_transportplan(transportId,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getAvgDurationOperationTrajet(long driverId, long operationId, long trajetId, Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.AvgDurationOperationTrajet(driverId,operationId,trajetId,dateDepart,dateFin);
    }

    @Override
    public BigDecimal getvalidertransportplan(long transportId,Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.valider_transportplan(transportId,dateDepart,dateFin);
    }
    @Override
    public BigDecimal getcanceledtransportplan(long transportId,Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.canceled_transportplan(transportId,dateDepart,dateFin);
    }
    @Override
    public BigDecimal getrectedtransportplan(long transportId,Date dateDepart, Date dateFin) {
        return tmsDashboardRepository.rejected_transportplan(transportId,dateDepart,dateFin);
    }
}
