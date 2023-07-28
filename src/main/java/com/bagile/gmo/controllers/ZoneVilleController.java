package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.CatalogTransportAccountPricing;
import com.bagile.gmo.dto.ProductPack;
import com.bagile.gmo.dto.ZoneVille;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.ZoneVilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/zoneVilles/")
public class ZoneVilleController {
    @Autowired
    private ZoneVilleService zoneVilleService;

    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ZoneVille> getZoneVilles() throws AttributesNotFound, ErrorType {
        return zoneVilleService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ZoneVille> getZoneVille(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return zoneVilleService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return zoneVilleService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        Long size = zoneVilleService.size(search);
        return size;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return zoneVilleService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ZoneVille getZoneVille(@PathVariable("id") Long id) throws IdNotFound {
        return zoneVilleService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ZoneVille> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return zoneVilleService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ZoneVille> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return zoneVilleService.find(search, page, size);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ZoneVille add(@RequestBody ZoneVille zoneVille) {
        return zoneVilleService.save(zoneVille);
    }

    @RequestMapping(value = "/saveALL", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ZoneVille> addAll(@RequestBody List<ZoneVille> zoneVilles) throws AttributesNotFound, ErrorType {
        return  zoneVilleService.saveAll(zoneVilles);
    }

    //@PreAuthorize("hasRole('BADGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ZoneVille set(@RequestBody ZoneVille zoneVille) {
        return zoneVilleService.save(zoneVille);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ZoneVille zoneVille) {
        zoneVilleService.delete(zoneVille);
    }
    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        zoneVilleService.delete(id);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        zoneVilleService.deleteAll (Arrays.asList(ids));
    }

}
