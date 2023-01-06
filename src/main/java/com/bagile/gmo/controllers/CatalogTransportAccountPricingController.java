package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.CatalogTransportAccountPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.CatalogTransportAccountPricingService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/CatalogTransportAccountPricings")
public class CatalogTransportAccountPricingController {
    private final CatalogTransportAccountPricingService catalogTransportAccountPricingService;

    public CatalogTransportAccountPricingController(CatalogTransportAccountPricingService catalogTransportAccountPricingService) {
        this.catalogTransportAccountPricingService = catalogTransportAccountPricingService;
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<CatalogTransportAccountPricing> getCatalogTransportAccountPricing() {
        return catalogTransportAccountPricingService.findAll();
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<CatalogTransportAccountPricing> getCatalogTransportAccountPricing(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return catalogTransportAccountPricingService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return catalogTransportAccountPricingService.size();
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        Long size = catalogTransportAccountPricingService.size(search);
        return size;
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return catalogTransportAccountPricingService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public CatalogTransportAccountPricing getCatalogTransportAccountPricing(@PathVariable("id") Long id) throws IdNotFound {
        return catalogTransportAccountPricingService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<CatalogTransportAccountPricing> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return catalogTransportAccountPricingService.find(search);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<CatalogTransportAccountPricing> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return catalogTransportAccountPricingService.find(search, page, size);
    }

    //@PreAuthorize("hasRole('BADGE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CatalogTransportAccountPricing add(@RequestBody CatalogTransportAccountPricing catalogTransport) {
        return catalogTransportAccountPricingService.save(catalogTransport);
    }

    @RequestMapping(value = "/saveALL", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CatalogTransportAccountPricing> addAll(@RequestBody List<CatalogTransportAccountPricing> catalogTransports) throws AttributesNotFound, ErrorType {
        return  catalogTransportAccountPricingService.saveAll(catalogTransports);
    }

    //@PreAuthorize("hasRole('BADGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CatalogTransportAccountPricing set(@RequestBody CatalogTransportAccountPricing catalogTransport) {
        return catalogTransportAccountPricingService.save(catalogTransport);
    }

    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody CatalogTransportAccountPricing catalogTransport) {
        catalogTransportAccountPricingService.delete(catalogTransport);
    }
    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        catalogTransportAccountPricingService.delete(id);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        catalogTransportAccountPricingService.deleteAll (Arrays.asList(ids));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  catalogTransportAccountPricingService.getNextVal();
    }

}
