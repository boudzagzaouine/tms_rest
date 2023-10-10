package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderTransportDocument;
import com.bagile.gmo.entities.TmsOrderTransportDocument;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportDocumentMapper;
import com.bagile.gmo.repositories.OrderTransportDocumentRepository;
import com.bagile.gmo.services.OrderTransportDocumentService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class OrderTransportDocumentServiceImpl implements OrderTransportDocumentService {
    
    private final OrderTransportDocumentRepository orderTransportDocumentRepository;

    public OrderTransportDocumentServiceImpl(OrderTransportDocumentRepository orderTransportDocumentRepository) {
        this.orderTransportDocumentRepository = orderTransportDocumentRepository;
    }

    @Override
    public OrderTransportDocument save(OrderTransportDocument orderTransportDocument) {
        return OrderTransportDocumentMapper.toDto(orderTransportDocumentRepository.saveAndFlush(OrderTransportDocumentMapper.toEntity(orderTransportDocument, false)), false);
    }

    @Override
    public Long size() {
        return orderTransportDocumentRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportDocumentRepository.existsById(id);
    }

    @Override
    public OrderTransportDocument findById(Long id) throws IdNotFound {
        return OrderTransportDocumentMapper.toDto(orderTransportDocumentRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportDocument> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTransportDocumentMapper.toDtos(orderTransportDocumentRepository.findAll(Search.expression(search, TmsOrderTransportDocument.class)), false);
    }

    @Override
    public List<OrderTransportDocument> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportDocumentMapper.toDtos(orderTransportDocumentRepository.findAll(Search.expression(search, TmsOrderTransportDocument.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderTransportDocumentRepository.count(Search.expression(search, TmsOrderTransportDocument.class));
    }
    @Value("${image.upload.path}") // Configure the file upload path in application.properties
    private String uploadPath;
    @Override
    public String saveImage(OrderTransportDocument orderTransportDocument) {
        String fileName = orderTransportDocument.getFileName();
        String imagePath = Paths.get(uploadPath, fileName).toString();

        try {
            Files.write(Paths.get(imagePath), orderTransportDocument.getFile());
            return imagePath;
        } catch (IOException e) {
            // Handle the exception
            throw new RuntimeException("Failed to save image.");
        }
    }

    @Override
    public void delete(Long id) {
        orderTransportDocumentRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransportDocument orderTransportDocument) {
        orderTransportDocumentRepository.delete(OrderTransportDocumentMapper.toEntity(orderTransportDocument, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            orderTransportDocumentRepository.deleteById(id);        }
    }


    @Override
    public List<OrderTransportDocument> findAll() {
        return OrderTransportDocumentMapper.toDtos(orderTransportDocumentRepository.findAll(), false);
    }


    public List<OrderTransportDocument> saveAll(List<OrderTransportDocument> orderTransportDocuments) throws ErrorType, IdNotFound, AttributesNotFound {
        List<OrderTransportDocument> orderTransportDocumentsList = new ArrayList<>();
        for (OrderTransportDocument orderTransportDocument : orderTransportDocuments){
             OrderTransportDocumentMapper.toDto(orderTransportDocumentRepository.saveAndFlush(OrderTransportDocumentMapper.toEntity(orderTransportDocument, false)), false);
        }
        return orderTransportDocumentsList;
    }
    @Override
    public List<OrderTransportDocument> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportDocumentMapper.toDtos(orderTransportDocumentRepository.findAll(pageable), false);
    }


}

