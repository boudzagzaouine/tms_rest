package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.OrderTransportRejectType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.OrderTransportRejectTypeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/orderTransportRejectTypes")
public class OrderTrasnportRejectTypeController {

    private final OrderTransportRejectTypeService orderTransportRejectTypeService;

    public OrderTrasnportRejectTypeController(OrderTransportRejectTypeService orderTransportRejectTypeService) {
        this.orderTransportRejectTypeService = orderTransportRejectTypeService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<OrderTransportRejectType> getAll() {
        return orderTransportRejectTypeService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OrderTransportRejectType> getAll(@RequestParam int page, @RequestParam int size) {
        return orderTransportRejectTypeService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public OrderTransportRejectType getOne(@PathVariable("id") Long id) throws IdNotFound {
        return orderTransportRejectTypeService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return orderTransportRejectTypeService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return orderTransportRejectTypeService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return orderTransportRejectTypeService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OrderTransportRejectType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderTransportRejectTypeService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OrderTransportRejectType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return orderTransportRejectTypeService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportRejectType add(@RequestBody OrderTransportRejectType orderTransportRejectType) {
        return orderTransportRejectTypeService.save(orderTransportRejectType);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportRejectType set(@RequestBody OrderTransportRejectType orderTransportRejectType) {
        return orderTransportRejectTypeService.save(orderTransportRejectType);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OrderTransportRejectType orderTransportRejectType) {
        orderTransportRejectTypeService.delete(orderTransportRejectType);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        orderTransportRejectTypeService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        orderTransportRejectTypeService.deleteAll (Arrays.asList(ids));
    }

}
