package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Dashboard;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public BigDecimal getAverageConsumption(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getAverageconsumptionvehicle(vehicleId, categoryId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/correctivemaintenancecostsbyvehicle")
    @ResponseBody
    public BigDecimal getCorrectivemaintenancecostsbyvehicle(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getCorrectivemaintenancecostsbyvehicle(vehicleId, categoryId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/preventivemaintenancecostsbyvehicle")
    @ResponseBody
    public BigDecimal getPreventivemaintenancecostsbyvehicle(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getPreventivemaintenancecostsbyvehicle(vehicleId, categoryId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/traveledmileagebyvechile")
    @ResponseBody
    public BigDecimal getTraveledmileagebyvechile(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getTraveledmileagebyvechile(vehicleId, categoryId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/totalnumberofproblemsbyvehicle")
    @ResponseBody
    public BigDecimal getTotalnumberofproblemsbyvehicle(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getTotalnumberofproblemsbyvehicle(vehicleId, categoryId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/LineChartMaintenanceCorrectiveByVehicle")
    @ResponseBody
    public List<Dashboard> getLineChartMaintenanceCorrectiveByVehicle(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException, AttributesNotFound, ErrorType {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getLineChartMaintenanceCorrectiveByVehicle(vehicleId, categoryId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/LineChartMaintenancePreventiveByVehicle")
    @ResponseBody
    public List<Dashboard> getLineChartMaintenancePreventiveByVehicle(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException, AttributesNotFound, ErrorType {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getLineChartMaintenancePreventiveByVehicle(vehicleId, categoryId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/BarChartGasoilByVehicle")
    @ResponseBody
    public List<Dashboard> getBarChartGasoilByVehicle(@RequestParam String vehicleId, @RequestParam Long categoryId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException, AttributesNotFound, ErrorType {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);

        return dashboardService.getBarChartGasoilByVehicle(vehicleId, categoryId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/averageAgeByVehicle")
    @ResponseBody
    public int getaverageAgeByVehicle() throws IdNotFound, ParseException, ParseException, AttributesNotFound, ErrorType {


        return dashboardService.getaverageAgeByVehicle();
    }

    /**/
    @RequestMapping(method = RequestMethod.GET, value ="/averageConsumptiondriver")
    @ResponseBody
    public BigDecimal getAverageConsumptionDriver(@RequestParam Long driverId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getAverageconsumptiondriver(driverId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/correctivemaintenancecostsbydriver")
    @ResponseBody
    public BigDecimal getCorrectivemaintenancecostsbyDriver(@RequestParam Long driverId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getCorrectivemaintenancecostsbydriver(driverId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/preventivemaintenancecostsbydriver")
    @ResponseBody
    public BigDecimal getPreventivemaintenancecostsbydriver(@RequestParam Long driverId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getPreventivemaintenancecostsbydriver(driverId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/traveledmileagebydriver")
    @ResponseBody
    public BigDecimal getTraveledmileagebydriver(@RequestParam Long driverId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getTraveledmileagebydriver(driverId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/totalnumberofproblemsbydriver")
    @ResponseBody
    public BigDecimal getTotalnumberofproblemsbydriver(@RequestParam Long driverId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getTotalnumberofproblemsbydriver(driverId, date1, date2);
    }



    @RequestMapping(method = RequestMethod.GET, value ="/BarChartGasoilByDriver")
    @ResponseBody
    public List<Dashboard> getBarChartGasoilByDriver(@RequestParam long driverId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException, AttributesNotFound, ErrorType {

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateDepart);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dateFin);
        return dashboardService.getBarChartGasoilByDriver(driverId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/PercentGasoilByDriver")
    @ResponseBody
    public List<Object> getPercentGasoilByDriver() throws IdNotFound, ParseException, ParseException, AttributesNotFound, ErrorType {


        return dashboardService.getPercentGasoilByDriver();
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