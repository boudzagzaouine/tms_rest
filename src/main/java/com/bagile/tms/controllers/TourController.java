package com.bagile.tms.controllers;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 18/04/2017.
 */

@Controller
@RequestMapping(value = "/tours/")
public class TourController {

    @Autowired
    private TourService tourService;


    ////@PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Tour> getTours() {
        return tourService.findAll();
    }

    //@PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Tour> getTours(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return tourService.findAll(page, size);
    }

    //@PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return tourService.size();
    }

    //@PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return tourService.size(search);
    }

    //@PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return tourService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Tour getTour(@PathVariable("id") Long id) throws IdNotFound {
        return tourService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Tour> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return tourService.find(search);
    }

    //@PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Tour> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return tourService.find(search, page, size);
    }

    //@PreAuthorize("hasAnyRole('TRANSPORT_VIEW','SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Tour add(@RequestBody Tour tour) {
        return tourService.save(tour);
    }

    //@PreAuthorize("hasRole('TRANSPORT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Tour set(@RequestBody Tour tour) {
        return tourService.save(tour);
    }

    //@PreAuthorize("hasRole('TRANSPORT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Tour tour) {

        tourService.delete(tour);
    }

    //@PreAuthorize("hasRole('TRANSPORT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        tourService.delete(id);
    }
}
