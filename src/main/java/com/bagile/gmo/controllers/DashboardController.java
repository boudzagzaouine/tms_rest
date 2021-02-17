package com.bagile.gmo.controllers;

import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {



    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @RequestMapping(method = RequestMethod.GET, value ="/averageConsumption")
    @ResponseBody
    public BigDecimal getAverageConsumption(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam Date dateDepart, @RequestParam Date dateFin) throws IdNotFound, ParseException, ParseException {
        return dashboardService.getAverageconsumptionvehicle(vehicleId, categoryId, dateDepart, dateFin);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/correctivemaintenancecostsbyvehicle")
    @ResponseBody
    public BigDecimal getCorrectivemaintenancecostsbyvehicle(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam Date dateDepart, @RequestParam Date dateFin) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getCorrectivemaintenancecostsbyvehicle(vehicleId, categoryId, dateDepart, dateFin);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/preventivemaintenancecostsbyvehicle")
    @ResponseBody
    public BigDecimal getPreventivemaintenancecostsbyvehicle(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam Date dateDepart, @RequestParam Date dateFin) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getPreventivemaintenancecostsbyvehicle(vehicleId, categoryId, dateDepart, dateFin);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/traveledmileagebyvechile")
    @ResponseBody
    public BigDecimal getTraveledmileagebyvechile(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam Date dateDepart, @RequestParam Date dateFin) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getTraveledmileagebyvechile(vehicleId, categoryId, dateDepart, dateFin);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/totalnumberofproblemsbyvehicle")
    @ResponseBody
    public BigDecimal getTotalnumberofproblemsbyvehicle(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam Date dateDepart, @RequestParam Date dateFin) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getTotalnumberofproblemsbyvehicle(vehicleId, categoryId, dateDepart, dateFin);
    }


    /**/


    @RequestMapping(method = RequestMethod.GET, value ="/averageConsumptiondriver")
    @ResponseBody
    public BigDecimal getAverageConsumptionDriver(@RequestParam Long driverId, @RequestParam Date dateDepart, @RequestParam Date dateFin) throws IdNotFound, ParseException, ParseException {
        return dashboardService.getAverageconsumptiondriver(driverId, dateDepart, dateFin);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/correctivemaintenancecostsbydriver")
    @ResponseBody
    public BigDecimal getCorrectivemaintenancecostsbyDriver(@RequestParam Long driverId, @RequestParam Date dateDepart, @RequestParam Date dateFin) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getCorrectivemaintenancecostsbydriver(driverId, dateDepart, dateFin);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/preventivemaintenancecostsbydriver")
    @ResponseBody
    public BigDecimal getPreventivemaintenancecostsbydriver(@RequestParam Long driverId, @RequestParam Date dateDepart, @RequestParam Date dateFin) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getPreventivemaintenancecostsbydriver(driverId, dateDepart, dateFin);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/traveledmileagebydriver")
    @ResponseBody
    public BigDecimal getTraveledmileagebydriver(@RequestParam Long driverId, @RequestParam Date dateDepart, @RequestParam Date dateFin) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getTraveledmileagebydriver(driverId, dateDepart, dateFin);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/totalnumberofproblemsbydriver")
    @ResponseBody
    public BigDecimal getTotalnumberofproblemsbydriver(@RequestParam Long driverId, @RequestParam Date dateDepart, @RequestParam Date dateFin) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getTotalnumberofproblemsbydriver(driverId, dateDepart, dateFin);
    }


/* seniority*/


    @RequestMapping(method = RequestMethod.GET, value ="/averageConsumptionseniorityvehicle")
    @ResponseBody
    public BigDecimal getAverageConsumptionseniorityvehicle(@RequestParam Long categoryid, @RequestParam Long slice1, @RequestParam Long slice2, @RequestParam Long senioritymode) throws IdNotFound, ParseException, ParseException {
        return dashboardService.getAverageconsumptionseniorityvehicle(categoryid, slice1, slice2, senioritymode);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/correctivemaintenancecostsbyseniorityvehicle")
    @ResponseBody
    public BigDecimal getCorrectivemaintenancecostsbyseniorityvehicle(@RequestParam Long categoryid, @RequestParam Long slice1, @RequestParam Long slice2, @RequestParam Long senioritymode) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getCorrectivemaintenancecostsbyseniorityvehicle(categoryid, slice1, slice2, senioritymode);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/preventivemaintenancecostsbyseniorityvehicle")
    @ResponseBody
    public BigDecimal getPreventivemaintenancecostsbyseniorityvehicle(@RequestParam Long categoryid, @RequestParam Long slice1, @RequestParam Long slice2, @RequestParam Long senioritymode) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getPreventivemaintenancecostsbyseniorityvehicle(categoryid, slice1, slice2, senioritymode);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/traveledmileagebyseniorityvehicle")
    @ResponseBody
    public BigDecimal getTraveledmileagebyseniorityvehicle(@RequestParam Long categoryid, @RequestParam Long slice1, @RequestParam Long slice2, @RequestParam Long senioritymode) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getTraveledmileagebyseniorityvehicle(categoryid, slice1, slice2, senioritymode);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/totalnumberofproblemsbyseniorityvehicle")
    @ResponseBody
    public BigDecimal getTotalnumberofproblemsbyseniorityvehicle(@RequestParam Long categoryid, @RequestParam Long slice1, @RequestParam Long slice2, @RequestParam Long senioritymode) throws IdNotFound, ParseException, ParseException {


        return dashboardService.getTotalnumberofproblemsbyseniorityvehicle(categoryid, slice1, slice2, senioritymode);
    }



}