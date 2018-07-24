package com.bagile.tms.controllers;

import com.sinno.ems.dto.Transport;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/transports/")
public class TransportController {

    @Autowired
    private TransportService transportService;


    @PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Transport> getTransports() {
        return transportService.findAll();
    }

    @PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Transport> getTransports(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return transportService.findAll(page, size);
    }

    @PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return transportService.size();
    }

    @PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return transportService.size(search);
    }

    @PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return transportService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Transport getTransport(@PathVariable("id") Long id) throws IdNotFound {
        return transportService.findById(id);
    }

    @PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Transport> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportService.find(search);
    }

    @PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Transport> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return transportService.find(search, page, size);
    }

    @PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Transport add(@RequestBody Transport transport) {
        return transportService.save(transport);
    }

    @PreAuthorize("hasRole('TRANSPORT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Transport set(@RequestBody Transport transport) {
        return transportService.save(transport);
    }

    @PreAuthorize("hasRole('TRANSPORT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Transport transport) {

        transportService.delete(transport);
    }

    @PreAuthorize("hasRole('TRANSPORT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        transportService.delete(id);
    }
}