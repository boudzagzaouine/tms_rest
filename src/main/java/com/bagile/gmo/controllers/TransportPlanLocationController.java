package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.TransportPlanLocation;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.TransportPlanLocationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/transportPlanLocations")
public class TransportPlanLocationController {

    private final TransportPlanLocationService transportPlanLocaltionService;

    public TransportPlanLocationController(TransportPlanLocationService transportPlanLocaltionService) {
        this.transportPlanLocaltionService = transportPlanLocaltionService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<TransportPlanLocation> getAll() {
        return transportPlanLocaltionService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<TransportPlanLocation> getAll(@RequestParam int page, @RequestParam int size) {
        return transportPlanLocaltionService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public TransportPlanLocation getOne(@PathVariable("id") Long id) throws IdNotFound {
        return transportPlanLocaltionService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return transportPlanLocaltionService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return transportPlanLocaltionService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return transportPlanLocaltionService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<TransportPlanLocation> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportPlanLocaltionService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<TransportPlanLocation> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return transportPlanLocaltionService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportPlanLocation add(@RequestBody TransportPlanLocation transportPlanLocaltion) throws IdNotFound {
        return transportPlanLocaltionService.save(transportPlanLocaltion);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportPlanLocation set(@RequestBody TransportPlanLocation transportPlanLocaltion) throws IdNotFound {
        return transportPlanLocaltionService.save(transportPlanLocaltion);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody TransportPlanLocation transportPlanLocaltion) {
        transportPlanLocaltionService.delete(transportPlanLocaltion);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        transportPlanLocaltionService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        transportPlanLocaltionService.deleteAll (Arrays.asList(ids));
    }

}
