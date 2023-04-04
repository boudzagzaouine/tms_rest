package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.VehicleAccompaniment;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.VehicleAccompanimentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/vehicleAccompaniments")
public class VehicleAccompanimentController {

    private final VehicleAccompanimentService vehicleAccompanimentService;

    public VehicleAccompanimentController(VehicleAccompanimentService vehicleAccompanimentService) {
        this.vehicleAccompanimentService = vehicleAccompanimentService;
    }

    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<VehicleAccompaniment> getVehicleAccompaniments() {return vehicleAccompanimentService.findAll();}
   //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<VehicleAccompaniment> getVehicleAccompaniment(@RequestParam int page, @RequestParam int size) {
        return vehicleAccompanimentService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return vehicleAccompanimentService.size();
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return vehicleAccompanimentService.size(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return vehicleAccompanimentService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public VehicleAccompaniment getVehicleAccompaniment(@PathVariable("id") Long id) throws IdNotFound {
        return vehicleAccompanimentService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<VehicleAccompaniment> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return vehicleAccompanimentService.find(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<VehicleAccompaniment> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return vehicleAccompanimentService.find(search, page, size);

    }
    //@PreAuthorize("hasRole('BADGETYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public VehicleAccompaniment add(@RequestBody VehicleAccompaniment vehicleAccompaniment ){return vehicleAccompanimentService.save(vehicleAccompaniment);}
    //@PreAuthorize("hasRole('BADGETYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public VehicleAccompaniment set(@RequestBody VehicleAccompaniment vehicleAccompaniment) {
        return vehicleAccompanimentService.save(vehicleAccompaniment);
    }
    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody VehicleAccompaniment vehicleAccompaniment) {

        vehicleAccompanimentService.delete(vehicleAccompaniment);
    }

    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        vehicleAccompanimentService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        vehicleAccompanimentService.deleteAll (Arrays.asList(ids));
    }
}