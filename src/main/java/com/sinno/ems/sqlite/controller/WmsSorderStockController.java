package com.sinno.ems.sqlite.controller;

import com.sinno.ems.sqlite.service.WmsSorderStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Enissay on 18/11/2016.
 */
@Controller
@RequestMapping(value = "/wmsSorderStock/")
public class WmsSorderStockController {
    @Autowired
    private WmsSorderStockService wmsSorderStockService;

    @RequestMapping(method = RequestMethod.GET, value = "/getContainerCode")
    @ResponseBody
    public String getSorderContainerCode(@RequestParam(value = "lineNumber") String lineNumber, @RequestParam(value = "sorderCode") String sorderCode, @RequestParam(value = "containerTarget") String containerTarget) {
        return wmsSorderStockService.getContainerSourceCode(Long.valueOf(lineNumber), sorderCode, containerTarget);
    }

}
