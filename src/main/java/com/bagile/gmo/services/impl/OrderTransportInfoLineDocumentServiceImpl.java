package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.TmsOrderTransportInfoLineDocument;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportInfoLineDocumentMapper;
import com.bagile.gmo.repositories.OrderTransportInfoLineDocumentRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.FileManagement;
import com.bagile.gmo.util.Search;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderTransportInfoLineDocumentServiceImpl implements OrderTransportInfoLineDocumentService {

    private final OrderTransportInfoLineDocumentRepository orderTransportInfoLineDocumentRepository;
    private final SettingService settingService;
    private final OrderTransportInfoLineService orderTransportInfoLineService;
    private final OrderTransportInfoService orderTransportInfoService;
    private final OrderTransportService orderTransportService;
    private final OrderTransportDocumentService orderTransportDocumentService;

    public OrderTransportInfoLineDocumentServiceImpl(OrderTransportInfoLineDocumentRepository orderTransportInfoLineDocumentRepository,
                                                     @Lazy SettingService settingService, OrderTransportInfoLineService orderTransportInfoLineService,
                                                     @Lazy OrderTransportInfoService orderTransportInfoService,
                                                     @Lazy OrderTransportService orderTransportService,
                                                     @Lazy OrderTransportDocumentService orderTransportDocumentService) {
        this.orderTransportInfoLineDocumentRepository = orderTransportInfoLineDocumentRepository;
        this.settingService = settingService;
        this.orderTransportInfoLineService = orderTransportInfoLineService;
        this.orderTransportInfoService = orderTransportInfoService;
        this.orderTransportService = orderTransportService;
        this.orderTransportDocumentService = orderTransportDocumentService;
    }

    @Override
    public OrderTransportInfoLineDocument save(OrderTransportInfoLineDocument orderTransportInfoLineDocument) {
        OrderTransportInfoLineDocument infoLineDocument = OrderTransportInfoLineDocumentMapper.toDto(orderTransportInfoLineDocumentRepository.saveAndFlush(OrderTransportInfoLineDocumentMapper.toEntity(orderTransportInfoLineDocument, false)), false);
        List<OrderTransportDocument> orderTransportDocumentList = orderTransportInfoLineDocument.getOrderTransportDocumentList();
        if (!orderTransportDocumentList.isEmpty()) {
            infoLineDocument.setDocumentStatus(2L);
            OrderTransportInfoLineDocumentMapper.toDto(orderTransportInfoLineDocumentRepository.saveAndFlush(OrderTransportInfoLineDocumentMapper.toEntity(orderTransportInfoLineDocument, false)), false);
            try {
                for (OrderTransportDocument orderTransportDocument : orderTransportInfoLineDocument.getOrderTransportDocumentList()) {
                    orderTransportDocument.setOrderTransportInfoLineDocument(infoLineDocument);
                    OrderTransportInfoLine orderTransportInfoLine = orderTransportInfoLineService
                            .findById(orderTransportInfoLineDocument.getOrderTransportInfoLine().getId());
                    OrderTransportInfo orderTransportInfo = orderTransportInfoService
                            .findById(orderTransportInfoLine.getOrderTransportInfo().getId());
                    OrderTransport orderTransport = orderTransportService
                            .findById(orderTransportInfo.getOrderTransport().getId());

                    //  OrderTransportDocument orderTransportDocument1 = orderTransportDocumentService.save(orderTransportDocument);
                    Setting setting = settingService.findById(1L);
                    Path directory = FileManagement.createDirectory(orderTransport.getCode() + "/" + orderTransportInfoLineDocument.getNumero(), setting.getValue());
                    //   String name = String.valueOf(orderTransportDocument1.getId()) + "." + orderTransportDocument1.getFileType();
                    //  orderTransportDocument1.setFileName(name);
                    String imagePath = directory.resolve(orderTransportDocument.getFileName()).toString();

                    if (orderTransportDocument.getFile() != null)
                        FileManagement.createFileFromByte(imagePath, orderTransportDocument.getFile());
                    imagePath = imagePath.replace("\\", "/");
                    orderTransportDocument.setFilePath(imagePath);
                    orderTransportDocument.setFile(null);

                    orderTransportDocumentService.save(orderTransportDocument);
                }
                //  this.orderTransportDocumentService.saveAll(orderTransportInfoLineDocument.getOrderTransportDocumentList());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        return infoLineDocument;
    }

    @Override
    public List<OrderTransportInfoLineDocument> saveAll(List<OrderTransportInfoLineDocument> orderTransportInfoLineDocuments) throws AttributesNotFound, ErrorType {

        List<OrderTransportInfoLineDocument> orderTransportInfoLineDocumentList = new ArrayList<>();

        for (OrderTransportInfoLineDocument orderTransportInfoLineDocument : orderTransportInfoLineDocuments) {
            orderTransportInfoLineDocumentList.add(save(orderTransportInfoLineDocument));
        }

        return orderTransportInfoLineDocumentList;

    }

    @Override
    public Long size() {
        return orderTransportInfoLineDocumentRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportInfoLineDocumentRepository.existsById(id);
    }

    @Override
    public OrderTransportInfoLineDocument findById(Long id) throws IdNotFound {
        return OrderTransportInfoLineDocumentMapper.toDto(orderTransportInfoLineDocumentRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportInfoLineDocument> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll();
        }
        return OrderTransportInfoLineDocumentMapper.toDtos(orderTransportInfoLineDocumentRepository.findAll(Search.expression(search, TmsOrderTransportInfoLineDocument.class)), false);
    }

    @Override
    public List<OrderTransportInfoLineDocument> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll(page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportInfoLineDocumentMapper.toDtos(orderTransportInfoLineDocumentRepository.findAll(Search.expression(search, TmsOrderTransportInfoLineDocument.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return size();
        }
        return orderTransportInfoLineDocumentRepository.count(Search.expression(search, TmsOrderTransportInfoLineDocument.class));
    }

    @Override
    public void delete(Long id) {
        orderTransportInfoLineDocumentRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransportInfoLineDocument orderTransportInfoLineDocument) {
        orderTransportInfoLineDocumentRepository.delete(OrderTransportInfoLineDocumentMapper.toEntity(orderTransportInfoLineDocument, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            orderTransportInfoLineDocumentRepository.deleteById(id);
        }
    }


    @Override
    public List<OrderTransportInfoLineDocument> findAll() {
        return OrderTransportInfoLineDocumentMapper.toDtos(orderTransportInfoLineDocumentRepository.findAll(), false);
    }

    @Override
    public List<OrderTransportInfoLineDocument> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportInfoLineDocumentMapper.toDtos(orderTransportInfoLineDocumentRepository.findAll(pageable), false);
    }


}

