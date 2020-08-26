package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.PurshaseOrderLine;
import com.bagile.gmo.dto.PurshaseOrderLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.exceptions.ProductControls;
import com.bagile.gmo.services.PurshaseOrderLineService;
import com.bagile.gmo.services.PurshaseOrderLineService;
import com.bagile.gmo.services.UserDetailsServiceWarehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/purshaseOrderLines/")
public class PurshaseOrderLineController {

    private final PurshaseOrderLineService purshaseOrderLineService;

    public PurshaseOrderLineController(PurshaseOrderLineService purshaseOrderLineService) {
        this.purshaseOrderLineService = purshaseOrderLineService;
    }

    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<PurshaseOrderLine> getPurshaseOrderLines() throws AttributesNotFound, ErrorType {return purshaseOrderLineService.findAll();}
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PurshaseOrderLine> getPurshaseOrderLine(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return purshaseOrderLineService.size();
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineService.size(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public PurshaseOrderLine getPurshaseOrderLine(@PathVariable("id") Long id) throws IdNotFound {
        return purshaseOrderLineService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PurshaseOrderLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineService.find(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PurshaseOrderLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineService.find(search, page, size);

    }
    //@PreAuthorize("hasRole('BADGETYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurshaseOrderLine add(@RequestBody PurshaseOrderLine purshaseOrderLine ){return purshaseOrderLineService.save(purshaseOrderLine);}
    //@PreAuthorize("hasRole('BADGETYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurshaseOrderLine set(@RequestBody PurshaseOrderLine purshaseOrderLine) {
        return purshaseOrderLineService.save(purshaseOrderLine);
    }
    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PurshaseOrderLine purshaseOrderLine) {

        purshaseOrderLineService.delete(purshaseOrderLine);
    }

    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        purshaseOrderLineService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        purshaseOrderLineService.deleteAll (Arrays.asList(ids));
    }
}