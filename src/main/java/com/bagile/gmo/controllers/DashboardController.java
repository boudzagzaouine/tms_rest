package com.bagile.gmo.controllers;

import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;

@Controller
@RequestMapping(value = "/Dashboard")
public class DashboardController {



    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vehicleId,dateDepart,dateFin,CategoryId}")
    @ResponseBody
    public BigDecimal getAverageConsumption(@PathVariable("vehicleId") Long vehicleId, @PathVariable("dateDepart") Date dateDepart, @PathVariable("dateFin") Date dateFin, @PathVariable("CategoryId") long CategoryId) throws IdNotFound {
        return dashboardService.averageConsumption(vehicleId, dateDepart, dateFin, CategoryId);
    }

}