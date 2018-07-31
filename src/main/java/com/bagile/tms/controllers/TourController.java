package com.bagile.tms.controllers;

import com.bagile.tms.dto.Tour;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.TourService;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tours/")
public class TourController {

    @Autowired
    private TourService tourService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    //@PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Tour> getTours() throws AttributesNotFound, ErrorType {
     
        return tourService.findAll();

        //  return tourService.findAll();
    }

    //@PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Tour> getTours(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType { if (null == userDetailsService.getOwners()) {
            return null;
        }

        return tourService.findAll(page,size);
        // return tourService.findAll(pageable);
    }

    //@PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return tourService.size();
        //return tourService.size();
    }

    //@PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return tourService.size(search  );

        // return tourService.size(search);
    }

    //@PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return tourService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Tour getTour(@PathVariable("id") Long id) throws IdNotFound {
        return tourService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Tour> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return tourService.find(search );

        // return tourService.find(search);
    }

    //@PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Tour> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return tourService.find(search , page, size);

        //  return tourService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('ACCOUNT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Tour add(@RequestBody Tour tour) {
        return tourService.save(tour);
    }

    //@PreAuthorize("hasRole('ACCOUNT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Tour set(@RequestBody Tour tour) {
        return tourService.save(tour);
    }

    //@PreAuthorize("hasRole('ACCOUNT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Tour tour) {

        tourService.delete(tour);
    }

    //@PreAuthorize("hasRole('ACCOUNT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        tourService.delete(id);
    }



}