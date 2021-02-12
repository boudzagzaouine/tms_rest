package com.bagile.gmo.services;

import java.math.BigDecimal;
import java.util.Date;

public interface DashboardService {



    BigDecimal averageConsumption(long vehicleId, Date dateDepart, Date dateFin, long CategoryId);

   /* Long mileageTraveled();
    BigDecimal costOfcorrectiveMaintenance();
    BigDecimal costOfPreventiveMaintenance();
    Long totalNumberOfproblemsGenerated ();*/
    
}
