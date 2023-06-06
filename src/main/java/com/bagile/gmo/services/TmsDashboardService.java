package com.bagile.gmo.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;


public interface TmsDashboardService {
    BigDecimal getVehiclemileage(long vehicleId,long categoryId, Date dateDepart, Date dateFin);
    BigDecimal getdrivermileage(long driverId,long trajetId,  Date dateDepart, Date dateFin);
    BigDecimal getVehicleNumberTrajets(long vehicleId,long categoryId, Date dateDepart, Date dateFin);
    BigDecimal getDriverNumberTrajets(long driverId, Date dateDepart, Date dateFin);
    BigDecimal getAvgdurationtrajet(long driverId,long operationId,long trajetId, Date dateDepart, Date dateFin);
    BigDecimal getAvgdurationtrajetAttent(long driverId,long operationId,long trajetId, Date dateDepart, Date dateFin);

    BigDecimal getrefusedtransportplan(long transportId,Date dateDepart, Date dateFin);
    BigDecimal getAvgDurationOperationTrajet(long driverId,long operationId, long trajetId, Date dateDepart, Date dateFin);

    BigDecimal getvalidertransportplan(long transportId,Date dateDepart, Date dateFin);

    BigDecimal getcanceledtransportplan(long transportId,Date dateDepart, Date dateFin);
    BigDecimal getrectedtransportplan(long transportId,Date dateDepart, Date dateFin);
}
