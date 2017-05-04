package com.sinno.ems.controller;

import com.sinno.ems.dto.PurshaseOrderLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.service.PurshaseOrderLineService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/purshaseOrderLines/")
public class PurshaseOrderLineController {

    @Autowired
    private PurshaseOrderLineService purshaseOrderLineService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<PurshaseOrderLine> getPurshaseOrderLines() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        return purshaseOrderLineService.find(userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PurshaseOrderLine> getPurshaseOrderLines(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        return purshaseOrderLineService.find(userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString(),page,size);
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        return purshaseOrderLineService.size(userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return purshaseOrderLineService.size(search + userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public PurshaseOrderLine getPurshaseOrderLine(@PathVariable("id") Long id) throws IdNotFound {
        return purshaseOrderLineService.findById(id);
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PurshaseOrderLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return purshaseOrderLineService.find(search + userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PurshaseOrderLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return purshaseOrderLineService.find(search + userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString(), page,size);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurshaseOrderLine add(@RequestBody PurshaseOrderLine purshaseOrderLine) throws ProductControls {
        return purshaseOrderLineService.save(purshaseOrderLine);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurshaseOrderLine set(@RequestBody PurshaseOrderLine purshaseOrderLine) throws ProductControls {
        return purshaseOrderLineService.save(purshaseOrderLine);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PurshaseOrderLine purshaseOrderLine) {

        purshaseOrderLineService.delete(purshaseOrderLine);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        purshaseOrderLineService.delete(id);
    }
}