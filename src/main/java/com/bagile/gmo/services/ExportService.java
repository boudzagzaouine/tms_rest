package com.bagile.gmo.services;

import com.bagile.gmo.dto.Agent;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;


public interface ExportService {



     ResponseEntity<Resource> downloadFile( String search) throws IOException ;


}
