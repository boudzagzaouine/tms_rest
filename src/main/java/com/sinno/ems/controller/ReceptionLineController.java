package com.sinno.ems.controller;

import com.sinno.ems.dto.ReceptionLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.service.ReceptionLineService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/receptionLines/")
public class ReceptionLineController {

    @Autowired
    private ReceptionLineService receptionLineService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<ReceptionLine> getReceptionLines() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        return receptionLineService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ReceptionLine> getReceptionLines(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        return receptionLineService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(), page, size);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        return receptionLineService.size(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return receptionLineService.size(search + userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return receptionLineService.isExist(id);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ReceptionLine getReceptionLine(@PathVariable("id") Long id) throws IdNotFound {
        return receptionLineService.findById(id);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ReceptionLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return receptionLineService.find(search + userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ReceptionLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        //Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return receptionLineService.find(search + userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(), page, size);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionLine add(@RequestBody ReceptionLine receptionLine) throws ProductControls {
        return receptionLineService.save(receptionLine);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionLine set(@RequestBody ReceptionLine receptionLine) throws ProductControls {
        return receptionLineService.save(receptionLine);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ReceptionLine receptionLine) {

        receptionLineService.delete(receptionLine);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        receptionLineService.delete(id);
    }
}