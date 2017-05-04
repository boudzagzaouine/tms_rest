package com.sinno.ems.controller;

import com.sinno.ems.dto.ZoneWarehouse;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import com.sinno.ems.service.ZoneWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 21/06/2016.
 */
@Controller
@RequestMapping(value = "/zoneWarehouses/")
public class ZoneWarehouseController {
    @Autowired
    private ZoneWarehouseService zoneWarehouseService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ZoneWarehouse> getZoneWarehouses() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        return zoneWarehouseService.find(userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ZoneWarehouse> getZoneWarehouses(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        return zoneWarehouseService.find(userDetailsService.getWarehouses().toString(),pageable);    }

    @PreAuthorize("hasRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        return zoneWarehouseService.size(userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }

        return zoneWarehouseService.size(search+userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return zoneWarehouseService.isExist(id);
    }    @PreAuthorize("hasRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public ZoneWarehouse getZoneWarehouse(@PathVariable("id") Long id) throws IdNotFound {
        return zoneWarehouseService.findById(id);
    }

    @PreAuthorize("hasRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ZoneWarehouse> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return zoneWarehouseService.find(search+userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ZoneWarehouse> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getWarehouses()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return zoneWarehouseService.find(search+userDetailsService.getWarehouses().toString(), pageable);
    }

    @PreAuthorize("hasRole('ZONE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ZoneWarehouse add(@RequestBody ZoneWarehouse zoneWarehouse) {
        return zoneWarehouseService.save(zoneWarehouse);
    }

    @PreAuthorize("hasRole('ZONE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ZoneWarehouse set(@RequestBody ZoneWarehouse zoneWarehouse) {
        return zoneWarehouseService.save(zoneWarehouse);
    }

    @PreAuthorize("hasRole('ZONE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ZoneWarehouse zoneWarehouse) {

        zoneWarehouseService.delete(zoneWarehouse);
    }

    @PreAuthorize("hasRole('ZONE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        zoneWarehouseService.delete(id);
    }
    
    
}
