package com.sinno.ems.controller;

import com.sinno.ems.dto.DeliveryLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.service.DeliveryLineService;
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
@RequestMapping(value = "/deliverylines/")
public class DeliveryLineController {
    @Autowired
    private DeliveryLineService deliveryLineService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<DeliveryLine> getDeliveryLines() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return deliveryLineService.find(userDetailsService.getOwners().toString());

        //  return deliveryLineService.findAll();
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<DeliveryLine> getDeliveryLines(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return deliveryLineService.find(userDetailsService.getOwners().toString(), page, size);
        // return deliveryLineService.findAll(pageable);
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return deliveryLineService.size(userDetailsService.getOwners().toString());
        //return deliveryLineService.size();
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return deliveryLineService.size(search + userDetailsService.getOwners().toString());

        // return deliveryLineService.size(search);
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return deliveryLineService.isExist(id);
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public DeliveryLine getDeliveryLine(@PathVariable("id") Long id) throws IdNotFound {
        return deliveryLineService.findById(id);
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<DeliveryLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return deliveryLineService.find(search + userDetailsService.getOwners().toString());

        // return deliveryLineService.find(search);
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<DeliveryLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return deliveryLineService.find(search + userDetailsService.getOwners().toString(), page, size);

        //  return deliveryLineService.find(search, pageable);
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DeliveryLine add(@RequestBody DeliveryLine deliveryLine) throws ProductControls {
        return deliveryLineService.save(deliveryLine);
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DeliveryLine set(@RequestBody DeliveryLine deliveryLine) throws ProductControls {
        return deliveryLineService.save(deliveryLine);
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody DeliveryLine deliveryLine) {

        deliveryLineService.delete(deliveryLine);
    }

    @PreAuthorize("hasRole('DELIVERY_LINE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        deliveryLineService.delete(id);
    }
}
