package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.FileManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/orderTransportDocuments")
public class OrderTransportDocumentController {

    private final OrderTransportDocumentService orderTransportDocumentService;
    private final SettingService settingService;
    private final OrderTransportInfoLineService orderTransportInfoLineService;
    private final OrderTransportInfoLineDocumentService orderTransportInfoLineDocumentService;

    private final OrderTransportInfoService orderTransportInfoService;
    private final OrderTransportService orderTransportService;

    public OrderTransportDocumentController(OrderTransportDocumentService orderTransportDocumentService,
                                            SettingService settingService,
                                            OrderTransportInfoLineService orderTransportInfoLineService,
                                            OrderTransportInfoService orderTransportInfoService,
                                            OrderTransportService orderTransportService,
                                            OrderTransportInfoLineDocumentService orderTransportInfoLineDocumentService) {

        this.orderTransportDocumentService = orderTransportDocumentService;
        this.settingService = settingService;
        this.orderTransportInfoLineService = orderTransportInfoLineService;
        this.orderTransportInfoService = orderTransportInfoService;
        this.orderTransportService = orderTransportService;
        this.orderTransportInfoLineDocumentService = orderTransportInfoLineDocumentService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<OrderTransportDocument> getAll() {
        return orderTransportDocumentService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OrderTransportDocument> getAll(@RequestParam int page, @RequestParam int size) {
        return orderTransportDocumentService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public OrderTransportDocument getOne(@PathVariable("id") Long id) throws IdNotFound {
        return orderTransportDocumentService.findById(id);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return orderTransportDocumentService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return orderTransportDocumentService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return orderTransportDocumentService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OrderTransportDocument> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderTransportDocumentService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OrderTransportDocument> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return orderTransportDocumentService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportDocument add(@RequestBody OrderTransportDocument orderTransportDocument) {
        return orderTransportDocumentService.save(orderTransportDocument);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportDocument set(@RequestBody OrderTransportDocument orderTransportDocument) {
        return orderTransportDocumentService.save(orderTransportDocument);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OrderTransportDocument orderTransportDocument) {
        orderTransportDocumentService.delete(orderTransportDocument);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) throws IOException {

        orderTransportDocumentService.delete(id);
    }

    @RequestMapping(value = "/saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<OrderTransportDocument> addAll(@RequestBody List<OrderTransportDocument> orderTransportDocuments) throws ErrorType, IdNotFound, AttributesNotFound {
        return orderTransportDocumentService.saveAll(orderTransportDocuments);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        orderTransportDocumentService.deleteAll(Arrays.asList(ids));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/imagepath")
    @ResponseBody
    public byte[] getImageByteFromPath(@RequestParam String path) throws IOException {

        return FileManagement.readFile(path);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/deleteimagebypath")
    @ResponseBody
    public void deleteImageByPath(@RequestParam String path) throws IOException {

        FileManagement.delete(Paths.get(path));
    }
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadPhoto(@RequestBody OrderTransportDocument orderTransportDocument) {

        try {
            OrderTransportInfoLineDocument orderTransportInfoLineDocument = orderTransportInfoLineDocumentService
                    .findById(orderTransportDocument.getOrderTransportInfoLineDocument().getId());
            OrderTransportInfoLine orderTransportInfoLine = orderTransportInfoLineService
                    .findById(orderTransportInfoLineDocument.getOrderTransportInfoLine().getId());
            OrderTransportInfo orderTransportInfo = orderTransportInfoService
                    .findById(orderTransportInfoLine.getOrderTransportInfo().getId());
            OrderTransport orderTransport = orderTransportService
                    .findById(orderTransportInfo.getOrderTransport().getId());

            OrderTransportDocument orderTransportDocument1 = set(orderTransportDocument);
            Setting setting = settingService.findById(1L);
            Path directory = FileManagement.createDirectory(orderTransport.getCode() + "/" + orderTransportInfoLineDocument.getNumero(), setting.getValue());
            String imagePath = directory.resolve(orderTransportDocument1.getFileName())+"."+orderTransportDocument1.getFileType();
            FileManagement.createFileFromByte(imagePath, orderTransportDocument1.getFile());
            imagePath = imagePath.replace("\\", "/");
            orderTransportDocument1.setOrderTransportInfoLineDocument(orderTransportInfoLineDocument);
            orderTransportDocument1.setFilePath(imagePath);
            orderTransportDocument1.setFile(null);

            set(orderTransportDocument1);

            return ResponseEntity.status(HttpStatus.CREATED).body("Photo uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload photo.");
        }

    }

}
