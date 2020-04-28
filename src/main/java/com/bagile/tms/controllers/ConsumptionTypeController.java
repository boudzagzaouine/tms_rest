package com.bagile.tms.controllers;

import com.bagile.tms.dto.ConsumptionType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.ConsumptionTypeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/consumptiontypes")
public class ConsumptionTypeController {
    private final ConsumptionTypeService consumptionTypeService;

    public ConsumptionTypeController(ConsumptionTypeService consumptionTypeService) {
        this.consumptionTypeService = consumptionTypeService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<ConsumptionType> getConsumptionTypes() {
        return consumptionTypeService.findAll();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ConsumptionType> getConsumptionTypes(@RequestParam int page, @RequestParam int size) {
        return consumptionTypeService.findAll(page, size);

    }
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return consumptionTypeService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return consumptionTypeService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return consumptionTypeService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ConsumptionType getConsumptionType(@PathVariable("id") Long id) throws IdNotFound {
        return consumptionTypeService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ConsumptionType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return consumptionTypeService.find(search);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ConsumptionType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return consumptionTypeService.find(search, page, size);
    }

    //@PreAuthorize("hasRole('BADGE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConsumptionType add(@RequestBody ConsumptionType consumptionType) {
        return consumptionTypeService.save(consumptionType);
    }

    //@PreAuthorize("hasRole('BADGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConsumptionType set(@RequestBody ConsumptionType consumptionType) {
        return consumptionTypeService.save(consumptionType);
    }

    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ConsumptionType consumptionType) {
        consumptionTypeService.delete(consumptionType);
    }

    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        consumptionTypeService.delete(id);
    }

}
