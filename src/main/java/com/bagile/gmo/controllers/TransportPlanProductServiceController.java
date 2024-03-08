package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.TransportPlanProductService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.TransportPlanProductServiceService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/transportPlanProductServices")
public class TransportPlanProductServiceController {

    private final TransportPlanProductServiceService transportPlanProductServiceService;

    public TransportPlanProductServiceController(TransportPlanProductServiceService transportPlanProductServiceService) {
        this.transportPlanProductServiceService = transportPlanProductServiceService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<TransportPlanProductService> getTransportPlanServices() {return transportPlanProductServiceService.findAll();}
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<TransportPlanProductService> getTransportPlanService(@RequestParam int page, @RequestParam int size) {
        return transportPlanProductServiceService.findAll(page, size);

    }
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return transportPlanProductServiceService.size();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return transportPlanProductServiceService.size(search);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return transportPlanProductServiceService.isExist(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public TransportPlanProductService getTransportPlanService(@PathVariable("id") Long id) throws IdNotFound {
        return transportPlanProductServiceService.findById(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<TransportPlanProductService> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportPlanProductServiceService.find(search);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<TransportPlanProductService> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return transportPlanProductServiceService.find(search, page, size);

    }
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportPlanProductService add(@RequestBody TransportPlanProductService transportPlanService ){return transportPlanProductServiceService.save(transportPlanService);}
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportPlanProductService set(@RequestBody TransportPlanProductService transportPlanService) {
        return transportPlanProductServiceService.save(transportPlanService);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody TransportPlanProductService transportPlanService) {

        transportPlanProductServiceService.delete(transportPlanService);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        transportPlanProductServiceService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        transportPlanProductServiceService.deleteAll (Arrays.asList(ids));
    }
}