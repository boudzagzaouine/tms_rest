package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.GmoNotification;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.NotificationMapper;
import com.bagile.gmo.repositories.NotificationRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private MaintenanceStateService maintenanceStateService;

    @Autowired
    private NotificationStateService notificationStateService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductService.class);

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification save(Notification notification) {
        return NotificationMapper.toDto(notificationRepository.saveAndFlush(NotificationMapper.toEntity(notification, false)), false);
    }

    @Override
    public List<Notification> saveAll(List<Notification> notifications) {

        List<Notification> notificationList = new ArrayList<>();

        for (Notification noti : notifications) {
            notificationList.add(save(noti));
        }

        return notificationList;

    }

    @Override
    public Long size() {
        return notificationRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return notificationRepository.existsById(id);
    }

    @Override
    public Notification findById(Long id) throws IdNotFound {
        return NotificationMapper.toDto(notificationRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Notification> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll();
        }
        return NotificationMapper.toDtos(notificationRepository.findAll(Search.expression(search, GmoNotification.class)), false);
    }

    @Override
    public List<Notification> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll(page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return NotificationMapper.toDtos(notificationRepository.findAll(Search.expression(search, GmoNotification.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return size();
        }
        return notificationRepository.count(Search.expression(search, GmoNotification.class));
    }

    @Override
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public void delete(Notification notification) {
        notificationRepository.delete(NotificationMapper.toEntity(notification, false));
    }

    @Override
    public List<Notification> findAll() {
        return NotificationMapper.toDtos(notificationRepository.findAll(), false);
    }

    @Override
    public List<Notification> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return NotificationMapper.toDtos(notificationRepository.findAll(pageable), false);
    }

    @Override
    public Notification findOne(String search) throws AttributesNotFound, ErrorType {

               Notification notif =NotificationMapper.toDto(notificationRepository.findOne(Search
                       .expression(search, GmoNotification.class)).orElse(null), false);
            return notif;





    }
    @Override
    @Scheduled(fixedDelay = 60000L)
    public void verify() throws AttributesNotFound, ErrorType, IdNotFound {

        try {
        verifyTriggerDateMaintenance();
        verifyStockProduct();
            LOGGER.info("execute Scheduled ");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());

        }

    }

    private void verifyTriggerDateMaintenance() throws IdNotFound, AttributesNotFound, ErrorType {

        ////// retard
        List<Maintenance> maintenanceList = maintenanceService.find("interventionDate<" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) );//+ ",maintenanceState.id:" + 1
        addMaintenanceToNotification(maintenanceList, 1L, 2L); // 2=retard

        //
        List<Maintenance> maintenanceDeclareList = maintenanceService.find("triggerDate<" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) );//+ ",maintenanceState.id:" + 1
        addMaintenanceToNotification(maintenanceDeclareList, 2L, 3L); //3= en attente

    }

    private void addMaintenanceToNotification(List<Maintenance> maintenanceList, long notificationStateID, long maintenanceStateID ) throws IdNotFound, AttributesNotFound, ErrorType {

        Notification notificationSearchMaintenance = new Notification();

        List<Notification> notifications = new ArrayList<>();
        MaintenanceState maintenanceState = maintenanceStateService.findById(maintenanceStateID);
        NotificationState notificationState = notificationStateService.findById(notificationStateID); // RETARD
        if (maintenanceList.size() > 0) {
            for (Maintenance maintenanace : maintenanceList) {
                Notification notification = new Notification();
                 notificationSearchMaintenance= findOne("maintenanceId:"+maintenanace.getId());
                if(notificationSearchMaintenance == null) {
                    maintenanace.setMaintenanceState(maintenanceState);
                    maintenanceService.save(maintenanace);
                    notification.setCode(maintenanace.getCode());
                    notification.setType("Maintenance");
                    notification.setNotificationState(notificationState);
                    notification.setMaintenanceId(maintenanace.getId());
                    notification.setPatimonyCode(maintenanace.getPatrimony().getCode());
                    notification.setAction(maintenanace.getActionType().getCode());
                    notifications.add(notification);

                }
            }


            saveAll(notifications);
        }
    }


    private void verifyStockProduct() throws AttributesNotFound, ErrorType, IdNotFound {

        Notification notificationSearchProduct = new Notification();
        List<Notification> notifications = new ArrayList<>();
        NotificationState notificationStatee = notificationStateService.findById(3L);//epuise
        List<Product> productList = productService.findAll();
        if (productList.size()>0) {

            for (Product product : productList) {
                Notification notification = new Notification();
                if (product.getMinStock() !=null){
                    if (product.getStockQuantity() == null) {
                        product.setStockQuantity(BigDecimal.ZERO);
                    }
                      notificationSearchProduct= findOne("productId:"+product.getId());

                    if(notificationSearchProduct== null) {
                        if (product.getStockQuantity().compareTo(product.getMinStock()) <= 0) {
                            notification.setCode(product.getCode());
                            notification.setType("Produit");
                            notification.setNotificationState(notificationStatee);
                            notification.setProductId(product.getId());
                            notifications.add(notification);
                        }
                    }
                }
            }
            saveAll(notifications);
        }

    }


}

