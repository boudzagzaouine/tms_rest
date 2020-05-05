package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.OrderStatus;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.OrderStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/orderStatuss/")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @PreAuthorize("hasAnyRole('ORDER_STATUS_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<OrderStatus> getOrderStatuss() {
        return orderStatusService.findAll();
    }

    @PreAuthorize("hasAnyRole('ORDER_STATUS_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OrderStatus> getOrderStatuss(@RequestParam int page, @RequestParam int size) {

        return orderStatusService.findAll(page,size);
    }

    @PreAuthorize("hasAnyRole('ORDER_STATUS_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return orderStatusService.size();
    }

    @PreAuthorize("hasAnyRole('ORDER_STATUS_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return orderStatusService.size(search);
    }

    @PreAuthorize("hasAnyRole('ORDER_STATUS_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return orderStatusService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('ORDER_STATUS_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public OrderStatus getOrderStatus(@PathVariable("id") Long id) throws IdNotFound {
        return orderStatusService.findById(id);
    }

    @PreAuthorize("hasAnyRole('ORDER_STATUS_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OrderStatus> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderStatusService.find(search);
    }

    @PreAuthorize("hasAnyRole('ORDER_STATUS_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OrderStatus> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        return orderStatusService.find(search, page,size);
    }

    @PreAuthorize("hasRole('ORDER_STATUS_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderStatus add(@RequestBody OrderStatus orderStatus) {
        return orderStatusService.save(orderStatus);
    }

    @PreAuthorize("hasRole('ORDER_STATUS_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderStatus set(@RequestBody OrderStatus orderStatus) {
        return orderStatusService.save(orderStatus);
    }

    @PreAuthorize("hasRole('ORDER_STATUS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OrderStatus orderStatus) {

        orderStatusService.delete(orderStatus);
    }

    @PreAuthorize("hasRole('ORDER_STATUS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        orderStatusService.delete(id);
    }
}