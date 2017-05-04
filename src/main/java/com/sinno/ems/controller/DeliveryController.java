package com.sinno.ems.controller;

import com.sinno.ems.dto.Delivery;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.WarehouseException;
import com.sinno.ems.service.DeliveryService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 21/04/2016.
 */
@Controller
@RequestMapping(value = "/deliveries/")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('DELIVERY_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Delivery> getDeliverys() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return deliveryService.find(userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());

        //  return deliveryService.findAll();
    }

    @PreAuthorize("hasAnyRole('DELIVERY_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Delivery> getDeliverys(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }

        return deliveryService.find(userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString(), page, size);
        // return deliveryService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('DELIVERY_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return deliveryService.size(userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());
        //return deliveryService.size();
    }

    @PreAuthorize("hasAnyRole('DELIVERY_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return deliveryService.size(search + userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());

        // return deliveryService.size(search);
    }

    @PreAuthorize("hasAnyRole('DELIVERY_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return deliveryService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('DELIVERY_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Delivery getDelivery(@PathVariable("id") Long id) throws IdNotFound {
        return deliveryService.findById(id);
    }

    @PreAuthorize("hasAnyRole('DELIVERY_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Delivery> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return deliveryService.find(search + userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());

        // return deliveryService.find(search);
    }

    @PreAuthorize("hasAnyRole('DELIVERY_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Delivery> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }

        return deliveryService.find(search + userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString(), page, size);

        //  return deliveryService.find(search, pageable);
    }

    @PreAuthorize("hasRole('DELIVERY_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Delivery add(@RequestBody Delivery delivery) throws WarehouseException {
        return deliveryService.save(delivery);
    }

    @PreAuthorize("hasRole('DELIVERY_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Delivery set(@RequestBody Delivery delivery) throws WarehouseException {
        return deliveryService.save(delivery);
    }

    @PreAuthorize("hasRole('DELIVERY_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Delivery delivery) {

        deliveryService.delete(delivery);
    }

    @PreAuthorize("hasRole('DELIVERY_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        deliveryService.delete(id);
    }

    @PreAuthorize("hasRole('DELIVERY_CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal() {
        return "EXP" + deliveryService.getNextVal().toString();
    }
}
