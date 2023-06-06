package com.bagile.gmo.controllers;

import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.DashboardService;
import com.bagile.gmo.services.TmsDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/Tmsdashboard")
public class TmsDashboardController {
    private final TmsDashboardService tmsDashboardService;

    @Autowired
    public TmsDashboardController(TmsDashboardService tmsDashboardService) {
        this.tmsDashboardService = tmsDashboardService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mileagevehicle")
    @ResponseBody
    public BigDecimal getMileageVehicle(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam String dateDepart,
                                        @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getVehiclemileage(vehicleId,categoryId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mileagedriver")
    @ResponseBody
    public BigDecimal getMileageDriver(@RequestParam Long driverId,@RequestParam Long trajetId,  @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getdrivermileage(driverId,trajetId, date1, date2);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/durationtrajet")
    @ResponseBody
    public BigDecimal getAvgDurationTrajet(@RequestParam Long driverId,@RequestParam Long operationId,@RequestParam Long trajetId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getAvgdurationtrajet(driverId,operationId,trajetId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/durationtrajetattent")
    @ResponseBody
    public BigDecimal getAvgDurationAttenteTrajet(@RequestParam Long driverId,@RequestParam Long operationId,@RequestParam Long trajetId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getAvgdurationtrajetAttent(driverId,operationId,trajetId, date1, date2);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/numbertrajetsvehicle")
    @ResponseBody
    public BigDecimal getNumeberTrajetVehicle(@RequestParam Long vehicleId, @RequestParam Long categoryId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getVehicleNumberTrajets(vehicleId,categoryId, date1, date2);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/avgdurationoperationtrajet")
    @ResponseBody
    public BigDecimal getAvgDurationOperationTrajet(@RequestParam Long driverId,@RequestParam Long operationId,@RequestParam Long trajetId, @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getAvgDurationOperationTrajet(driverId,operationId,trajetId,date1,date2);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/numbertrajetsdriver")
    @ResponseBody
    public BigDecimal getNumeberTrajetDriver(@RequestParam Long driverId,  @RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getDriverNumberTrajets(driverId, date1, date2);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/transportrefused")
    @ResponseBody
    public BigDecimal getRefusedtransportplan(@RequestParam Long transportId,@RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getrefusedtransportplan(transportId,date1,date2);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/transportrejected")
    @ResponseBody
    public BigDecimal getRejectedtransportplan(@RequestParam Long transportId,@RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getrectedtransportplan(transportId,date1,date2);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/transportvalider")
    @ResponseBody
    public BigDecimal getValidertransportplan(@RequestParam Long transportId,@RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getvalidertransportplan(transportId,date1,date2);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/transportcanceled")
    @ResponseBody
    public BigDecimal getCanceledtransportplan(@RequestParam Long transportId,@RequestParam String dateDepart, @RequestParam String dateFin) throws IdNotFound, ParseException, ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateDepart);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateFin);
        return tmsDashboardService.getcanceledtransportplan(transportId,date1,date2);
    }
}
