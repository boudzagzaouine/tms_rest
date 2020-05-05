package com.bagile.tms.controllers;

import com.bagile.gmo.dto.Uom;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.UomService;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/uoms/")
public class UomController {

    @Autowired
    private UomService uomService;
    @Autowired
    private UserDetailsServiceWarehouse userDetailsService;

   //  @PreAuthorize("hasAnyRole('UOM_VIEW','PRODUCT_VIEW','PRODUCT_PACK_VIEW','STOCK_VIEW','KIT_VIEW','STOCK_VIEW','DELIVERY_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_STOCK_VIEW','SALE_ODER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Uom> getUoms() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}

        return uomService.find(userDetailsService.getOwners().toString());
    }

   //  @PreAuthorize("hasAnyRole('UOM_VIEW','PRODUCT_VIEW','PRODUCT_PACK_VIEW','STOCK_VIEW','KIT_VIEW','STOCK_VIEW','DELIVERY_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_STOCK_VIEW','SALE_ODER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Uom> getUoms(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
       if (null == userDetailsService.getOwners())
        {return null;}
        return uomService.find(userDetailsService.getOwners().toString(),page,size);
    }
   //  @PreAuthorize("hasAnyRole('UOM_VIEW','PRODUCT_VIEW','PRODUCT_PACK_VIEW','STOCK_VIEW','KIT_VIEW','STOCK_VIEW','DELIVERY_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_STOCK_VIEW','SALE_ODER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/findOne")
    @ResponseBody
    public Uom findOne(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        return uomService.findOne(search+userDetailsService.getOwners().toString());

    }
   //  @PreAuthorize("hasAnyRole('UOM_VIEW','PRODUCT_VIEW','PRODUCT_PACK_VIEW','STOCK_VIEW','KIT_VIEW','STOCK_VIEW','DELIVERY_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_STOCK_VIEW','SALE_ODER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        return uomService.size(userDetailsService.getOwners().toString());
    }

   //  @PreAuthorize("hasAnyRole('UOM_VIEW','PRODUCT_VIEW','PRODUCT_PACK_VIEW','STOCK_VIEW','KIT_VIEW','STOCK_VIEW','DELIVERY_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_STOCK_VIEW','SALE_ODER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        if (!search.endsWith(",")) {
            search += ",";
        }
        return uomService.size(search+userDetailsService.getOwners().toString());
    }

   //  @PreAuthorize("hasAnyRole('UOM_VIEW','PRODUCT_VIEW','PRODUCT_PACK_VIEW','STOCK_VIEW','KIT_VIEW','STOCK_VIEW','DELIVERY_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_STOCK_VIEW','SALE_ODER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return uomService.isExist(id);
    }
   //  @PreAuthorize("hasAnyRole('UOM_VIEW','PRODUCT_VIEW','PRODUCT_PACK_VIEW','STOCK_VIEW','KIT_VIEW','STOCK_VIEW','DELIVERY_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_STOCK_VIEW','SALE_ODER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Uom getUom(@PathVariable("id") Long id) throws IdNotFound {
        return uomService.findById(id);
    }

   //  @PreAuthorize("hasAnyRole('UOM_VIEW','PRODUCT_VIEW','PRODUCT_PACK_VIEW','STOCK_VIEW','KIT_VIEW','STOCK_VIEW','DELIVERY_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_STOCK_VIEW','SALE_ODER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Uom> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        if (!search.endsWith(",")) {
            search += ",";
        }
        return uomService.find(search+userDetailsService.getOwners().toString());
    }

   //  @PreAuthorize("hasAnyRole('UOM_VIEW','PRODUCT','PRODUCT_PACK','STOCK','KIT','STOCK','DELIVERY_LINE','RECEPTION_LINE','SALE_ORDER_LINE','PURSHASE_ORDER_LINE','RECEPTION_STOCK','SALE_ODER_STOCK')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Uom> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        if (!search.endsWith(",")) {
            search += ",";
        }
        return uomService.find(search+userDetailsService.getOwners().toString(),page,size);
    }

   //  @PreAuthorize("hasRole('UOM_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Uom add(@RequestBody Uom uom) {
        return uomService.save(uom);
    }

   //  @PreAuthorize("hasRole('UOM_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Uom set(@RequestBody Uom uom) {
        return uomService.save(uom);
    }

   //  @PreAuthorize("hasRole('UOM_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Uom uom) {

        uomService.delete(uom);
    }

   //  @PreAuthorize("hasRole('UOM_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        uomService.delete(id);
    }
}