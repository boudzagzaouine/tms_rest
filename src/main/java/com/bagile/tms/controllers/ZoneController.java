package com.bagile.tms.controllers;

import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(value="/zone")

public class ZoneController {
    @Autowired
    private ZoneService zoneService;
    //@PreAuthorize("hasAnyRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Zone> getZones() {return zoneService.findAll();}
    //@PreAuthorize("hasAnyRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Zone> getZone(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "prmColorUpdateDate");
        Pageable pageable = PageRequest.of(page, size,sort);
        return zoneService.findAll(pageable);

    }
    //@PreAuthorize("hasAnyRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return zoneService.size();
    }
    //@PreAuthorize("hasAnyRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return zoneService.size(search);
    }
    //@PreAuthorize("hasAnyRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return zoneService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Zone getZone(@PathVariable("id") Long id) throws IdNotFound {
        return zoneService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Zone> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return zoneService.find(search);
    }
    //@PreAuthorize("hasAnyRole('ZONE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Zone> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return zoneService.find(search, pageable);

    }
    //@PreAuthorize("hasRole('ZONE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Zone add(@RequestBody Zone zone ){return zoneService.save(zone);}
    //@PreAuthorize("hasRole('ZONE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Zone set(@RequestBody Zone zone) {
        return zoneService.save(zone);
    }
    //@PreAuthorize("hasRole('ZONE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Zone zone) {

        zoneService.delete(zone);
    }


    //@PreAuthorize("hasRole('ZONE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        zoneService.delete(id);
    }

}
