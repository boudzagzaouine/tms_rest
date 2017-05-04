package com.sinno.ems.controller;

import com.sinno.ems.dto.AssetSupplier;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.AssetSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 16/12/2016.
 */
@Controller
@RequestMapping(value = "/supplierAssets/")
public class AssetSupplierController {
    @Autowired
    private AssetSupplierService assetSupplierService;

    @PreAuthorize("hasRole('SUPPLIER_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<AssetSupplier> getAssets() {
        return assetSupplierService.findAll();
    }

    @PreAuthorize("hasRole('SUPPLIER_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<AssetSupplier> getAssets(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return assetSupplierService.findAll(pageable);
    }

    @PreAuthorize("hasRole('SUPPLIER_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return assetSupplierService.size();
    }

    @PreAuthorize("hasRole('SUPPLIER_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return assetSupplierService.size(search);
    }

    @PreAuthorize("hasRole('SUPPLIER_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return assetSupplierService.isExist(id);
    }    @PreAuthorize("hasRole('SUPPLIER_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public AssetSupplier getAsset(@PathVariable("id") Long id) throws IdNotFound {
        return assetSupplierService.findById(id);
    }

    @PreAuthorize("hasRole('SUPPLIER_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<AssetSupplier> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return assetSupplierService.find(search);
    }

    @PreAuthorize("hasRole('SUPPLIER_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<AssetSupplier> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return assetSupplierService.find(search, pageable);
    }

    @PreAuthorize("hasRole('SUPPLIER_ASSET_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AssetSupplier add(@RequestBody AssetSupplier assetSupplier) {
        return assetSupplierService.save(assetSupplier);
    }

    @PreAuthorize("hasRole('SUPPLIER_ASSET_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AssetSupplier set(@RequestBody AssetSupplier assetSupplier) {
        return assetSupplierService.save(assetSupplier);
    }

    @PreAuthorize("hasRole('SUPPLIER_ASSET_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody AssetSupplier assetSupplier) {

        assetSupplierService.delete(assetSupplier);
    }

    @PreAuthorize("hasRole('SUPPLIER_ASSET_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        assetSupplierService.delete(id);
    }
}
