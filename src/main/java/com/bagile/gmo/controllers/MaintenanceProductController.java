package com.bagile.gmo.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bagile.gmo.dto.MaintenanceProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.MaintenanceProductService;

@Controller
@RequestMapping(value = "/maintenanceProducts")
public class MaintenanceProductController {
    private final MaintenanceProductService maintenanceProductService;

    public MaintenanceProductController(MaintenanceProductService maintenanceService) {
        this.maintenanceProductService = maintenanceService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<MaintenanceProduct> getAll() throws AttributesNotFound, ErrorType {
        return maintenanceProductService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<MaintenanceProduct> getAll(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return maintenanceProductService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public MaintenanceProduct getOne(@PathVariable("id") Long id) throws IdNotFound {
        return maintenanceProductService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return maintenanceProductService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return maintenanceProductService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return maintenanceProductService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<MaintenanceProduct> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return maintenanceProductService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<MaintenanceProduct> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return maintenanceProductService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MaintenanceProduct add(@RequestBody MaintenanceProduct maintenanceProduct) throws IdNotFound {
        return maintenanceProductService.save(maintenanceProduct);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MaintenanceProduct set(@RequestBody MaintenanceProduct maintenanceProduct) throws IdNotFound {
        return maintenanceProductService.save(maintenanceProduct);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody MaintenanceProduct maintenanceProduct) {
        maintenanceProductService.delete(maintenanceProduct);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        maintenanceProductService.delete(id);
    }
}
