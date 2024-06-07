package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.TransportPlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.TransportPlanService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/transportPlans")
public class TransportPlanController {

    private final TransportPlanService transportPlanService;

    public TransportPlanController(TransportPlanService transportPlanService) {
        this.transportPlanService = transportPlanService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<TransportPlan> getAll() {
        return transportPlanService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<TransportPlan> getAll(@RequestParam int page, @RequestParam int size) {
        return transportPlanService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public TransportPlan getOne(@PathVariable("id") Long id) throws IdNotFound {
        return transportPlanService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return transportPlanService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return transportPlanService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return transportPlanService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<TransportPlan> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportPlanService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<TransportPlan> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return transportPlanService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportPlan add(@RequestBody TransportPlan transportPlan) throws IdNotFound, ErrorType, IOException, AttributesNotFound {
        return transportPlanService.save(transportPlan);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportPlan set(@RequestBody TransportPlan transportPlan) throws IdNotFound, ErrorType, IOException, AttributesNotFound {
        return transportPlanService.save(transportPlan);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody TransportPlan transportPlan) {
        transportPlanService.delete(transportPlan);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        transportPlanService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        transportPlanService.deleteAll (Arrays.asList(ids));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  transportPlanService.getNextVal();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getLastPriceTransport")
    @ResponseBody
    public TransportPlan getLastPriceTransport(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportPlanService.getLastPriceTransport(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getLastPriceTransports")
    @ResponseBody
    public List<TransportPlan> getLastPriceTransports(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportPlanService.getLastPriceTransports(search);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/exportInvoiceState")
//    @ResponseBody
//    public ResponseEntity<byte[]> exportInvoiceState(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
//        return transportPlanService.exportInvoiceState(search);
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/exportInvoiceState")
    @ResponseBody
    public ResponseEntity<Resource> exportInvoiceState(@RequestParam(value = "search")String search) throws ErrorType, AttributesNotFound {
        byte[] responseEntity = transportPlanService.exportInvoiceState(search);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(new ByteArrayResource(responseEntity));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getItineraries")
    @ResponseBody
    public List<TransportPlan> getItineraries(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return transportPlanService.getItineraries(search, page,  size);
    }
}
