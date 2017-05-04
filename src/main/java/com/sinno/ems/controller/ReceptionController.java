package com.sinno.ems.controller;

import com.sinno.ems.dto.Reception;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.WarehouseException;
import com.sinno.ems.service.ReceptionService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/receptions/")
public class ReceptionController {

    @Autowired
    private ReceptionService receptionService;
    @Autowired
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Reception> getReceptions() throws AttributesNotFound, ErrorType {

        if (null == userDetailsService.getOwners()) {
            return null;
        }

        return receptionService.find(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Reception> getReceptions(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}

        return receptionService.find(userDetailsService.getOwners().toString(),page,size);
    }

    @PreAuthorize("hasRole('RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        return receptionService.size(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        if (!search.endsWith(",")) {
            search += ",";
        }
        return receptionService.size(search+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return receptionService.isExist(id);
    }    @PreAuthorize("hasRole('RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Reception getReception(@PathVariable("id") Long id) throws IdNotFound {
        return receptionService.findById(id);
    }

    @PreAuthorize("hasRole('RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Reception> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        if (!search.endsWith(",")) {
            search += ",";
        }
        return receptionService.find(search+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Reception> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        //Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getOwners())
        {return null;}
        if (!search.endsWith(",")) {
            search += ",";
        }
        return receptionService.find(search+userDetailsService.getOwners().toString(), page,size);
    }

    @PreAuthorize("hasRole('RECEPTION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Reception add(@RequestBody Reception reception) throws WarehouseException {
        return receptionService.save(reception);
    }

    @PreAuthorize("hasRole('RECEPTION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Reception set(@RequestBody Reception reception) throws WarehouseException {
        return receptionService.save(reception);
    }

    @PreAuthorize("hasRole('RECEPTION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Reception reception) {

        receptionService.delete(reception);
    }

    @PreAuthorize("hasRole('RECEPTION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        receptionService.delete(id);
    }

    @PreAuthorize("hasRole('RECEPTION_CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  "RCP"+receptionService.getNextVal().toString();
    }
}