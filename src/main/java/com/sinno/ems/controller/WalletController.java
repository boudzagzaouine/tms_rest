package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/wallets/")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PreAuthorize("hasAnyRole('WALLET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Wallet> getWallets() throws AttributesNotFound, ErrorType {
          return walletService.findAll();
    }

    @PreAuthorize("hasAnyRole('WALLET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Wallet> getWallets(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return walletService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('WALLET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

      return walletService.size();
    }

    @PreAuthorize("hasAnyRole('WALLET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return walletService.size(search);
    }

    @PreAuthorize("hasAnyRole('WALLET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return walletService.isExist(id);
    }


    @PreAuthorize("hasAnyRole('WALLET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Wallet getWallet(@PathVariable("id") Long id) throws IdNotFound {
        return walletService.findById(id);
    }

    @PreAuthorize("hasAnyRole('WALLET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Wallet> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return walletService.find(search);
    }


    @PreAuthorize("hasAnyRole('WALLET_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Wallet> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }
        return walletService.find(search, page,size);
    }


    @PreAuthorize("hasRole('WALLET_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Wallet add(@RequestBody Wallet wallet) {
        return walletService.save(wallet);
    }


    @PreAuthorize("hasRole('WALLET_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Wallet set(@RequestBody Wallet wallet) {
        return walletService.save(wallet);
    }


    @PreAuthorize("hasRole('WALLET_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Wallet wallet) {

        walletService.delete(wallet);
    }


    @PreAuthorize("hasRole('WALLET_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        walletService.delete(id);
    }

}