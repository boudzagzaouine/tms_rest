package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.CatalogTransportPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.CatalogTransportPricingService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/CatalogTransportPricings")
public class CatalogTransportPricingController {
    private final CatalogTransportPricingService catalogTransportPricingService;

    public CatalogTransportPricingController(CatalogTransportPricingService catalogTransportPricingService) {
        this.catalogTransportPricingService = catalogTransportPricingService;
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<CatalogTransportPricing> getCatalogTransportPricing() {
        return catalogTransportPricingService.findAll();
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<CatalogTransportPricing> getCatalogTransportPricing(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return catalogTransportPricingService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return catalogTransportPricingService.size();
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        Long size = catalogTransportPricingService.size(search);
        return size;
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return catalogTransportPricingService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public CatalogTransportPricing getCatalogTransportPricing(@PathVariable("id") Long id) throws IdNotFound {
        return catalogTransportPricingService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<CatalogTransportPricing> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return catalogTransportPricingService.find(search);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<CatalogTransportPricing> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return catalogTransportPricingService.find(search, page, size);
    }

    //@PreAuthorize("hasRole('BADGE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CatalogTransportPricing add(@RequestBody CatalogTransportPricing catalogTransport) {
        return catalogTransportPricingService.save(catalogTransport);
    }

    @RequestMapping(value = "/saveALL", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CatalogTransportPricing> addAll(@RequestBody List<CatalogTransportPricing> catalogTransports) throws AttributesNotFound, ErrorType {
        return  catalogTransportPricingService.saveAll(catalogTransports);
    }

    //@PreAuthorize("hasRole('BADGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CatalogTransportPricing set(@RequestBody CatalogTransportPricing catalogTransport) {
        return catalogTransportPricingService.save(catalogTransport);
    }

    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody CatalogTransportPricing catalogTransport) {
        catalogTransportPricingService.delete(catalogTransport);
    }
    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        catalogTransportPricingService.delete(id);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        catalogTransportPricingService.deleteAll (Arrays.asList(ids));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  catalogTransportPricingService.getNextVal();
    }

}
