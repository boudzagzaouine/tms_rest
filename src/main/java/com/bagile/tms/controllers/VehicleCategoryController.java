package com.bagile.tms.controllers;

import com.bagile.gmo.dto.VehicleCategory;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.VehicleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by khalil on 04/04/2017.
 */
@Controller
@RequestMapping(value = "/vehicleCategories")

public class VehicleCategoryController {
    private final VehicleCategoryService vehicleCategoryService;

    public VehicleCategoryController(VehicleCategoryService vehicleCategoryService) {
        this.vehicleCategoryService = vehicleCategoryService;
    }

    //@PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<VehicleCategory> getAll() {
        return vehicleCategoryService.findAll();
    }

    //@PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<VehicleCategory> getAll(@RequestParam int page, @RequestParam int size) {

        return vehicleCategoryService.findAll(page, size);
    }

    //@PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public VehicleCategory getOne(@PathVariable("id") Long id) throws IdNotFound {
        return vehicleCategoryService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return vehicleCategoryService.size();
    }

    //@PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return vehicleCategoryService.size(search);
    }

    //@PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return vehicleCategoryService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<VehicleCategory> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return vehicleCategoryService.find(search);
    }

    //@PreAuthorize("hasAnyRole('INCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<VehicleCategory> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return vehicleCategoryService.find(search, page, size);

    }

    //@PreAuthorize("hasRole('CATEGORY_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public VehicleCategory add(@RequestBody VehicleCategory vehicleCategory) {
        return vehicleCategoryService.save(vehicleCategory);
    }

    //@PreAuthorize("hasRole('CATEGORY_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public VehicleCategory set(@RequestBody VehicleCategory vehicleCategory) {
        return vehicleCategoryService.save(vehicleCategory);
    }

    //@PreAuthorize("hasRole('CATEGORY_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody VehicleCategory vehicleCategory) {
        vehicleCategoryService.delete(vehicleCategory);
    }


    //@PreAuthorize("hasRole('CATEGORY_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        vehicleCategoryService.delete(id);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        vehicleCategoryService.deleteAll (Arrays.asList(ids));
    }
}
