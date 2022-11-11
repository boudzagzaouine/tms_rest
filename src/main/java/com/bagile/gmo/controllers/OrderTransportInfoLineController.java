package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.OrderTransportInfoLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.OrderTransportInfoLineService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/orderTransportInfoLines")
public class OrderTransportInfoLineController {

    private final OrderTransportInfoLineService orderTransportInfoLineService;

    public OrderTransportInfoLineController(OrderTransportInfoLineService orderTransportInfoLineService) {
        this.orderTransportInfoLineService = orderTransportInfoLineService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<OrderTransportInfoLine> getAll() {
        return orderTransportInfoLineService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OrderTransportInfoLine> getAll(@RequestParam int page, @RequestParam int size) {
        return orderTransportInfoLineService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public OrderTransportInfoLine getOne(@PathVariable("id") Long id) throws IdNotFound {
        return orderTransportInfoLineService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return orderTransportInfoLineService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return orderTransportInfoLineService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return orderTransportInfoLineService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OrderTransportInfoLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderTransportInfoLineService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OrderTransportInfoLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return orderTransportInfoLineService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportInfoLine add(@RequestBody OrderTransportInfoLine orderDeliveryType) {
        return orderTransportInfoLineService.save(orderDeliveryType);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportInfoLine set(@RequestBody OrderTransportInfoLine orderDeliveryType) {
        return orderTransportInfoLineService.save(orderDeliveryType);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OrderTransportInfoLine orderDeliveryType) {
        orderTransportInfoLineService.delete(orderDeliveryType);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        orderTransportInfoLineService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        orderTransportInfoLineService.deleteAll (Arrays.asList(ids));
    }

}
