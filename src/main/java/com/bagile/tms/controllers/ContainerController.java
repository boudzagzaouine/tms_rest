package com.bagile.tms.controllers;

import com.bagile.tms.dto.Container;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.ContainerService;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/containers/")
public class ContainerController {

    @Autowired
    private ContainerService containerService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;


    @PreAuthorize("hasAnyRole('CONTAINER_VIEW','SALE_ORDER_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Container> getContainers() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null ==userDetailsService.getOwners()){
            return null;
        }
        return containerService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('CONTAINER_VIEW','SALE_ORDER_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Container> getContainers(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "stkContainerCreationDate");

        Pageable pageable = PageRequest.of(page, size,sort);
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners() ){
            return null;
        }
        return containerService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(),pageable);
    }

    @PreAuthorize("hasAnyRole('CONTAINER_VIEW','SALE_ORDER_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null ==userDetailsService.getOwners()) {
            return null;
        }
        return containerService.size(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('CONTAINER_VIEW','SALE_ORDER_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return containerService.size(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('CONTAINER_VIEW','SALE_ORDER_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return containerService.isExist(id);
    }            @PreAuthorize("hasAnyRole('CONTAINER_VIEW','SALE_ORDER_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Container getContainer(@PathVariable("id") Long id) throws IdNotFound {
        return containerService.findById(id);
    }

    @PreAuthorize("hasAnyRole('CONTAINER_VIEW','SALE_ORDER_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Container> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners() ) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }

        return containerService.find(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('CONTAINER_VIEW','SALE_ORDER_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Container> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "stkContainerCreationDate");

        Pageable pageable = PageRequest.of(page, size,sort);
        if (null == userDetailsService.getWarehouses() || null ==userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return containerService.find(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(), pageable);
    }

    @PreAuthorize("hasRole('CONTAINER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Container add(@RequestBody Container container) {
        return containerService.save(container);
    }

    @PreAuthorize("hasRole('CONTAINER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Container set(@RequestBody Container container) {
        return containerService.save(container);
    }

    @PreAuthorize("hasRole('CONTAINER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Container container) {

        containerService.delete(container);
    }

    @PreAuthorize("hasRole('CONTAINER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        containerService.delete(id);
    }



}