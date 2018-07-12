package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PurshaseOrderService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/purshaseOrders/")
public class PurshaseOrderController {

    @Autowired
    private PurshaseOrderService purshaseOrderService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<PurshaseOrder> getPurshaseOrders() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }
        return purshaseOrderService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PurshaseOrder> getPurshaseOrders(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
          if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }

        return purshaseOrderService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(),page, size);
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }

        return purshaseOrderService.size(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return purshaseOrderService.size(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return purshaseOrderService.isExist(id);
    }        @PreAuthorize("hasAnyRole('PURSHASE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public PurshaseOrder getPurshaseOrder(@PathVariable("id") Long id) throws IdNotFound {
        return purshaseOrderService.findById(id);
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PurshaseOrder> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }

        return purshaseOrderService.find(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PURSHASE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PurshaseOrder> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        //Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return purshaseOrderService.find(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(), page, size);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurshaseOrder add(@RequestBody PurshaseOrder purshaseOrder) {
        return purshaseOrderService.save(purshaseOrder);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurshaseOrder set(@RequestBody PurshaseOrder purshaseOrder) {
        return purshaseOrderService.save(purshaseOrder);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PurshaseOrder purshaseOrder) {

        purshaseOrderService.delete(purshaseOrder);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        purshaseOrderService.delete(id);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  "PO"+purshaseOrderService.getNextVal().toString();
    }
}