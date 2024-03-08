package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Agent;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
;
import com.bagile.gmo.services.ExportService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
@RequestMapping(value="/exports")
public class ExportController {
    private final ExportService exportService;

    public ExportController(ExportService exportService) {
        this.exportService = exportService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/exportCanevas")
    @ResponseBody
        public ResponseEntity<Resource> downloadFile(@RequestParam String search) throws IOException {

        return exportService.downloadFile(search);
        }

}
