package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.OrderTransportDocumentType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.OrderTransportDocumentTypeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/orderTransportDocumentTypes")
public class OrderTransportDocumentTypeController {

    private final OrderTransportDocumentTypeService orderTransportDocumentTypeService;

    public OrderTransportDocumentTypeController(OrderTransportDocumentTypeService orderTransportDocumentTypeService) {
        this.orderTransportDocumentTypeService = orderTransportDocumentTypeService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<OrderTransportDocumentType> getAll() {
        return orderTransportDocumentTypeService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OrderTransportDocumentType> getAll(@RequestParam int page, @RequestParam int size) {
        return orderTransportDocumentTypeService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public OrderTransportDocumentType getOne(@PathVariable("id") Long id) throws IdNotFound {
        return orderTransportDocumentTypeService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return orderTransportDocumentTypeService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return orderTransportDocumentTypeService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return orderTransportDocumentTypeService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OrderTransportDocumentType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderTransportDocumentTypeService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OrderTransportDocumentType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return orderTransportDocumentTypeService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportDocumentType add(@RequestBody OrderTransportDocumentType orderTransportDocumentType) {
        return orderTransportDocumentTypeService.save(orderTransportDocumentType);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportDocumentType set(@RequestBody OrderTransportDocumentType orderTransportDocumentType) {
        return orderTransportDocumentTypeService.save(orderTransportDocumentType);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OrderTransportDocumentType orderTransportDocumentType) {
        orderTransportDocumentTypeService.delete(orderTransportDocumentType);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        orderTransportDocumentTypeService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        orderTransportDocumentTypeService.deleteAll (Arrays.asList(ids));
    }

}
