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
    public BigDecimal averageConsumption(long vehicleId, Date dateDepart, Date dateFin, long CategoryId) {
        return dashboardRepository.averageConsumption( vehicleId,dateDepart, dateFin,CategoryId);
    }
}

