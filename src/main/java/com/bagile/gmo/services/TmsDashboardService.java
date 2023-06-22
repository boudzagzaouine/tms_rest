package com.bagile.gmo.services;

import java.math.BigDecimal;


public interface TmsDashboardService {
    BigDecimal getVehiclemileage(String vehicleId,String trajetId,String categoryId,String marqueId,String senioritymode, String dateDepart, String dateFin);
    BigDecimal getdrivermileage(String driverId,String trajetId,  String dateDepart, String dateFin);
    BigDecimal getVehicleNumberTrajets(String vehicleId,String trajetId,String categoryId,String marqueId,String senioritymode, String dateDepart, String dateFin);
    BigDecimal getDriverNumberTrajets(String driverId,String trajetId, String dateDepart, String dateFin);
    BigDecimal getAvgdurationtrajet(String driverId,String trajetId, String dateDepart, String dateFin);
    BigDecimal getAvgdurationtrajetAttent(String driverId,String trajetId, String dateDepart, String dateFin);

    BigDecimal getrefusedtransportplan(String transportId,String dateDepart, String dateFin);
    BigDecimal getAvgDurationOperationTrajetVehicle(String driverId ,String trajetId,String categoryId,String marqueId,String senioritymode, String dateDepart, String dateFin);
    BigDecimal getAvgdurationtrajetAttentVehicle(String vehicleId ,String trajetId,String categoryId,String marqueId,String senioritymode, String dateDepart, String dateFin);
    BigDecimal getAvgdurationtrajetVehicle(String vehicleId ,String trajetId,String categoryId,String marqueId,String senioritymode, String dateDepart, String dateFin);
    BigDecimal getAvgDurationOperationTrajet(String driverId ,String trajetId, String dateDepart, String dateFin);

    BigDecimal getvalidertransportplan(String transportId,String dateDepart, String dateFin);

    BigDecimal getcanceledtransportplan(String transportId,String dateDepart, String dateFin);
    BigDecimal getrectedtransportplan(String transportId,String dateDepart, String dateFin);
}
