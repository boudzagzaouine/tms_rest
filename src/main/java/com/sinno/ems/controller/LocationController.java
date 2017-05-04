package com.sinno.ems.controller;

import com.sinno.ems.dto.Location;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.LocationService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/locations/")
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('LOCATION_VIEW','CONTAINER_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Location> getLocations() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()){
            return null;
    }
        return locationService.find(userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasAnyRole('LOCATION_VIEW','CONTAINER_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Location> getLocations(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        return locationService.find(userDetailsService.getWarehouses().toString(), page, size);
    }

    @PreAuthorize("hasAnyRole('LOCATION_VIEW','CONTAINER_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()) {
            return null;
        }
        return locationService.size(userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasAnyRole('LOCATION_VIEW','CONTAINER_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return locationService.size(search+userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasAnyRole('LOCATION_VIEW','CONTAINER_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return locationService.isExist(id);
    }


    @PreAuthorize("hasAnyRole('LOCATION_VIEW','CONTAINER_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Location getLocation(@PathVariable("id") Long id) throws IdNotFound {
        return locationService.findById(id);
    }

    @PreAuthorize("hasAnyRole('LOCATION_VIEW','CONTAINER_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Location> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return locationService.find(search+userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasAnyRole('LOCATION_VIEW','CONTAINER_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Location> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        //Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getWarehouses()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return locationService.find(search+userDetailsService.getWarehouses().toString(),page, size);
    }


    @PreAuthorize("hasRole('LOCATION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Location add(@RequestBody Location location) {
        return locationService.save(location);
    }

    @PreAuthorize("hasRole('LOCATION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Location set(@RequestBody Location location) {
        return locationService.save(location);
    }

    @PreAuthorize("hasRole('LOCATION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Location location) {

        locationService.delete(location);
    }

    @PreAuthorize("hasRole('LOCATION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        locationService.delete(id);
    }


    @PreAuthorize("hasRole('LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/findEmptyLocation")
    @ResponseBody
    public List<Location> findEmtyLocation() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        return locationService.findEmtyLocation(userDetailsService.getWarehouses().toString());

    }
}