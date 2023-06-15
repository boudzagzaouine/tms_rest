package com.bagile.gmo.controllers;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.TmsDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/tmsdashboard")
public class TmsDashboardController {
    private final TmsDashboardService tmsDashboardService;

    @Autowired
    public TmsDashboardController(TmsDashboardService tmsDashboardService) {
        this.tmsDashboardService = tmsDashboardService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mileagevehicle")
    @ResponseBody
    public BigDecimal getMileageVehicle(@RequestParam(required = false) String vehicleId,@RequestParam(required = false) String trajetId, @RequestParam(required = false) String categoryId, @RequestParam(required = false) String dateDepart,
                                        @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
        if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getVehiclemileage(vehicleId,trajetId,categoryId, dateDepart, dateFin);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mileagedriver")
    @ResponseBody
    public BigDecimal getMileageDriver(@RequestParam(required = false) String driverId,@RequestParam(required = false) String trajetId,  @RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
         if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getdrivermileage(driverId,trajetId, dateDepart, dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/durationtrajet")
    @ResponseBody
    public BigDecimal getAvgDurationTrajet(@RequestParam(required = false) String driverId,@RequestParam(required = false) String trajetId, @RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
         if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getAvgdurationtrajet(driverId,trajetId, dateDepart, dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/durationtrajetvehicle")
    @ResponseBody
    public BigDecimal getAvgDurationTrajetVehicle(@RequestParam(required = false) String vehicleId,@RequestParam(required = false) String trajetId,@RequestParam(required = false) String categoryId, @RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
        if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getAvgdurationtrajetVehicle(vehicleId,trajetId,categoryId, dateDepart, dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/durationtrajetattent")
    @ResponseBody
    public BigDecimal getAvgDurationAttenteTrajet(@RequestParam(required = false) String driverId,@RequestParam String trajetId, @RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
         if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getAvgdurationtrajetAttent(driverId,trajetId, dateDepart, dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/durationtrajetattentvehicle")
    @ResponseBody
    public BigDecimal getAvgDurationAttenteTrajetVehicle(@RequestParam(required = false) String vehicleId,@RequestParam String trajetId,@RequestParam String categoryId, @RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
        if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getAvgdurationtrajetAttentVehicle(vehicleId,trajetId,categoryId, dateDepart, dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/numbertrajetsvehicle")
    @ResponseBody
    public BigDecimal getNumeberTrajetVehicle(@RequestParam(required = false) String vehicleId, @RequestParam(required = false) String trajetId,@RequestParam(required = false) String categoryId, @RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
        if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getVehicleNumberTrajets(vehicleId,trajetId,categoryId, dateDepart, dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/avgdurationoperationtrajet")
    @ResponseBody
    public BigDecimal getAvgDurationOperationTrajet(@RequestParam(required = false) String driverId, @RequestParam(required = false) String trajetId, @RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
        if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getAvgDurationOperationTrajet(driverId, trajetId,dateDepart,dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/avgdurationoperationtrajetvehicle")
    @ResponseBody
    public BigDecimal getAvgDurationOperationTrajetVehicle(@RequestParam(required = false) String vehicleId, @RequestParam(required = false) String trajetId, @RequestParam(required = false) String categoryId, @RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
        if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
    
        return tmsDashboardService.getAvgDurationOperationTrajetVehicle(vehicleId, trajetId,categoryId,dateDepart,dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/numbertrajetsdriver")
    @ResponseBody
    public BigDecimal getNumeberTrajetDriver(@RequestParam(required = false) String driverId,@RequestParam(required = false) String trajetId,  @RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
        if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getDriverNumberTrajets(driverId,trajetId, dateDepart, dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/transportrefused")
    @ResponseBody
    public BigDecimal getRefusedtransportplan(@RequestParam(required = false) String transportId,@RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {

        if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getrefusedtransportplan(transportId,dateDepart,dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/transportrejected")
    @ResponseBody
    public BigDecimal getRejectedtransportplan(@RequestParam(required = false) String transportId,@RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
         if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getrectedtransportplan(transportId,dateDepart,dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/transportvalider")
    @ResponseBody
    public BigDecimal getValidertransportplan(@RequestParam(required = false) String transportId,@RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
         if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

        return tmsDashboardService.getvalidertransportplan(transportId,dateDepart,dateFin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/transportcanceled")
    @ResponseBody
    public BigDecimal getCanceledtransportplan(@RequestParam(required = false) String transportId,@RequestParam(required = false) String dateDepart, @RequestParam(required = false) String dateFin) throws IdNotFound, ParseException, ParseException {
         if (dateDepart == null) {
            LocalDate oneYearAgo = LocalDate.now().minusYears(1);
            dateDepart = oneYearAgo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
        if (dateFin == null) {
            LocalDate currentDate = LocalDate.now();
            dateFin = currentDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

       // Date dateDepart = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        //Date dateFin = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getcanceledtransportplan(transportId,dateDepart,dateFin);
    }
}
