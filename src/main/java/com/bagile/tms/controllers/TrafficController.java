package com.bagile.tms.controllers;

import com.bagile.tms.dto.Traffic;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TrafficController {

    @Autowired
    private TrafficService trafficService;
    //@PreAuthorize("hasAnyRole('TRAFFIC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Traffic> getTraffic() {return trafficService.findAll();}
    //@PreAuthorize("hasAnyRole('TRAFFIC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Traffic> getTraffic(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "prmColorUpdateDate");
        Pageable pageable = PageRequest.of(page, size,sort);
        return trafficService.findAll(pageable);

    }
    //@PreAuthorize("hasAnyRole('TRAFFIC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return trafficService.size();
    }
    //@PreAuthorize("hasAnyRole('TRAFFIC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return trafficService.size(search);
    }
    //@PreAuthorize("hasAnyRole('TRAFFIC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return trafficService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('TRAFFIC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Traffic getTraffic(@PathVariable("id") Long id) throws IdNotFound {
        return trafficService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('TRAFFIC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Traffic> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return trafficService.find(search);
    }
    //@PreAuthorize("hasAnyRole('TRAFFIC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Traffic> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return trafficService.find(search, pageable);

    }
    //@PreAuthorize("hasRole('TRAFFIC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Traffic add(@RequestBody Traffic traffic ){return trafficService.save(traffic);}
    //@PreAuthorize("hasRole('TRAFFIC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Traffic set(@RequestBody Traffic traffic) {
        return trafficService.save(traffic);
    }
    //@PreAuthorize("hasRole('TRAFFIC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Traffic traffic) {

        trafficService.delete(traffic);
    }

    //@PreAuthorize("hasRole('TRAFFIC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        trafficService.delete(id);
    }

}
