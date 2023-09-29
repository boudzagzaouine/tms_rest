package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.OrderTransport;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.OrderTransportService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/orderTransports")
public class OrderTransportController {

    private final OrderTransportService orderDeliveryService;

    public OrderTransportController(OrderTransportService orderDeliveryService) {
        this.orderDeliveryService = orderDeliveryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<OrderTransport> getAll() {
        return orderDeliveryService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OrderTransport> getAll(@RequestParam int page, @RequestParam int size) {
        return orderDeliveryService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public OrderTransport getOne(@PathVariable("id") Long id) throws IdNotFound {
        return orderDeliveryService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return orderDeliveryService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return orderDeliveryService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return orderDeliveryService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OrderTransport> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderDeliveryService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getOrderTransport")
    @ResponseBody
    public OrderTransport getOrderTransport(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderDeliveryService.getOrderTransport(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OrderTransport> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return orderDeliveryService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransport add(@RequestBody OrderTransport orderDelivery) {
        return orderDeliveryService.save(orderDelivery);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransport set(@RequestBody OrderTransport orderDelivery) {
        return orderDeliveryService.save(orderDelivery);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OrderTransport orderDelivery) {
        orderDeliveryService.delete(orderDelivery);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        orderDeliveryService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        orderDeliveryService.deleteAll (Arrays.asList(ids));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  orderDeliveryService.getNextVal();
    }

}
