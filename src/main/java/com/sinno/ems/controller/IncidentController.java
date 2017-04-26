package com.sinno.ems.controller;

import com.sinno.ems.dto.Incident;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by khalil on 04/04/2017.
 */
@Controller
@RequestMapping(value="/drivers")
public class IncidentController {
    @Autowired
    private IncidentService incidentService;
    @PreAuthorize("hasAnyRole('INCIDENT_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Incident> getIncidents() {return incidentService.findAll();}
    @PreAuthorize("hasAnyRole('INCIDENT_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Incident> getDrivers(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "prmColorUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
         return incidentService.findAll(pageable);

    }
    @PreAuthorize("hasAnyRole('INCIDENT_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return incidentService.size();
    }
    @PreAuthorize("hasAnyRole('INCIDENT_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return incidentService.size(search);
    }
    @PreAuthorize("hasAnyRole('INCIDENT_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return incidentService.isExist(id);
    }
    @PreAuthorize("hasAnyRole('INCIDENT_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Incident getDriver(@PathVariable("id") Long id) throws IdNotFound {
        return incidentService.findById(id);
    }
    @PreAuthorize("hasAnyRole('INCIDENT_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Incident> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return incidentService.find(search);
    }
    @PreAuthorize("hasAnyRole('INCIDENT_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Incident> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return incidentService.find(search, pageable);

    }
    @PreAuthorize("hasRole('INCIDENT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Incident add(@RequestBody Incident incident ){return incidentService.save(incident);}
    @PreAuthorize("hasRole('INCIDENT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Incident set(@RequestBody Incident incident) {
        return incidentService.save(incident);
    }
    @PreAuthorize("hasRole('INCIDENT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Incident driver) {

       incidentService.delete(driver);
    }


}

