package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Agent;
import com.bagile.gmo.entities.GmoAgent;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AgentMapper;
import com.bagile.gmo.repositories.AgentRepository;
import com.bagile.gmo.services.AgentService;
import com.bagile.gmo.services.ExportService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {

    private static final String FILE_DIRECTORY = "/export/";

    public ExportServiceImpl() {

    }


    @Override
    public ResponseEntity<Resource> downloadFile(@RequestParam String fileName) throws IOException {
//       Path filePath = Paths.get(FILE_DIRECTORY).resolve(fileName);
//        Resource resource = new org.springframework.core.io.FileUrlResource(filePath.toUri().toURL());

       String templatePath = "/export/"+fileName;
        final InputStream reportInputStream   = getClass().getResourceAsStream(templatePath);
        Resource resource = new InputStreamResource(reportInputStream);


//        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/excel-models/" + entity + ".xlsx");
//        modelFile = new DefaultStreamedContent(stream, "application/vnd.ms-excel", entity + ".xlsx");



        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
