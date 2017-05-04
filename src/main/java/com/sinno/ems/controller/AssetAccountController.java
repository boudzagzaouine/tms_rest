package com.sinno.ems.controller;

import com.sinno.ems.dto.AssetAccount;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.AssetAccountService;
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
@RequestMapping(value = "/accountAssets/")
public class AssetAccountController {
    @Autowired
    private AssetAccountService assetAccountService;

    @PreAuthorize("hasRole('ACCOUNT_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<AssetAccount> getAssets() {
        return assetAccountService.findAll();
    }

    @PreAuthorize("hasRole('ACCOUNT_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<AssetAccount> getAssets(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return assetAccountService.findAll(pageable);
    }

    @PreAuthorize("hasRole('ACCOUNT_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return assetAccountService.size();
    }

    @PreAuthorize("hasRole('ACCOUNT_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return assetAccountService.size(search);
    }

    @PreAuthorize("hasRole('ACCOUNT_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return assetAccountService.isExist(id);
    }
    @PreAuthorize("hasRole('ACCOUNT_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public AssetAccount getAsset(@PathVariable("id") Long id) throws IdNotFound {
        return assetAccountService.findById(id);
    }

    @PreAuthorize("hasRole('ACCOUNT_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<AssetAccount> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return assetAccountService.find(search);
    }

    @PreAuthorize("hasRole('ACCOUNT_ASSET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<AssetAccount> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return assetAccountService.find(search, pageable);
    }

    @PreAuthorize("hasRole('ACCOUNT_ASSET_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AssetAccount add(@RequestBody AssetAccount assetAccount) {
        return assetAccountService.save(assetAccount);
    }

    @PreAuthorize("hasRole('ACCOUNT_ASSET_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AssetAccount set(@RequestBody AssetAccount assetAccount) {
        return assetAccountService.save(assetAccount);
    }

    @PreAuthorize("hasRole('ACCOUNT_ASSET_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody AssetAccount assetAccount) {

        assetAccountService.delete(assetAccount);
    }

    @PreAuthorize("hasRole('ACCOUNT_ASSET_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        assetAccountService.delete(id);
    }
}
