package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.OrderTransportInfo;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.OrderTransportInfoService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/orderTransportInfos")
public class OrderTransportInfoController {

    private final OrderTransportInfoService orderTransportInfoService;

    public OrderTransportInfoController(OrderTransportInfoService orderTransportInfoService) {
        this.orderTransportInfoService = orderTransportInfoService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<OrderTransportInfo> getAll() {
        return orderTransportInfoService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OrderTransportInfo> getAll(@RequestParam int page, @RequestParam int size) {
        return orderTransportInfoService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public OrderTransportInfo getOne(@PathVariable("id") Long id) throws IdNotFound {
        return orderTransportInfoService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return orderTransportInfoService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return orderTransportInfoService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return orderTransportInfoService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OrderTransportInfo> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderTransportInfoService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OrderTransportInfo> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return orderTransportInfoService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportInfo add(@RequestBody OrderTransportInfo orderDeliveryType) throws ErrorType, AttributesNotFound, IdNotFound, IOException {
        return orderTransportInfoService.save(orderDeliveryType);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportInfo set(@RequestBody OrderTransportInfo orderDeliveryType) throws ErrorType, AttributesNotFound, IdNotFound, IOException {
        return orderTransportInfoService.save(orderDeliveryType);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OrderTransportInfo orderDeliveryType) {
        orderTransportInfoService.delete(orderDeliveryType);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        orderTransportInfoService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        orderTransportInfoService.deleteAll (Arrays.asList(ids));
    }

}
