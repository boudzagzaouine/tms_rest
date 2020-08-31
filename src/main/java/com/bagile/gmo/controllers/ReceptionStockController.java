package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.ReceptionStock;
import com.bagile.gmo.exceptions.*;
import com.bagile.gmo.services.ReceptionStockService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/receptionStocks/")
public class ReceptionStockController {

    private final ReceptionStockService receptionStockService;


    public ReceptionStockController(ReceptionStockService receptionStockService) {
        this.receptionStockService = receptionStockService;
    }

    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<ReceptionStock> getReceptionStocks() throws AttributesNotFound, ErrorType {return receptionStockService.findAll();}
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ReceptionStock> getReceptionStock(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return receptionStockService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return receptionStockService.size();
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return receptionStockService.size(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return receptionStockService.isExist(id);
    }
    @RequestMapping(value = "/saveALL", method = RequestMethod.POST)
    @ResponseBody
    public List<ReceptionStock> saveAll(@RequestBody List<ReceptionStock> receptionStockList) {
        return receptionStockService.saveAll(receptionStockList, true);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ReceptionStock getReceptionStock(@PathVariable("id") Long id) throws IdNotFound {
        return receptionStockService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ReceptionStock> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return receptionStockService.find(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ReceptionStock> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return receptionStockService.find(search, page, size);

    }
    //@PreAuthorize("hasRole('BADGETYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionStock add(@RequestBody ReceptionStock receptionStock ) throws ContainerException, ProductControls, AttributesNotFound, ErrorType, IdNotFound, CustomException {return receptionStockService.save(receptionStock);}
    //@PreAuthorize("hasRole('BADGETYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionStock set(@RequestBody ReceptionStock receptionStock) throws ContainerException, ProductControls, AttributesNotFound, ErrorType, IdNotFound, CustomException {
        return receptionStockService.save(receptionStock);
    }
    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ReceptionStock receptionStock) {

        receptionStockService.delete(receptionStock);
    }

    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        receptionStockService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        receptionStockService.deleteAll(Arrays.asList(ids));
    }



}