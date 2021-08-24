package com.bagile.gmo.services.impl;

import com.bagile.gmo.config.mail.EmailService;
import com.bagile.gmo.config.mail.MailConfig;
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

    @Autowired
    private NotificationTypeService notificationTypeService;

    @Autowired
    private  EmailService emailService;

    @Autowired
    private  TemplateService templateService;
    @Autowired
    private  MailConfigService mailConfigService;



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

        //////if statut == cree et date intevention < dateNow
        List<Maintenance> maintenanceListStateCree = maintenanceService.find("interventionDate<" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())+",programType.id:"+1L+",maintenanceState.id :"+1L);//1=cree
        addMaintenanceToNotification(maintenanceListStateCree, 1L, 2L); // maintenanceState =>2=>retard

        //////if statut == en attente et date intevention < dateNow
        List<Maintenance> maintenanceListStateEnAttente = maintenanceService.find("interventionDate<" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())+",programType.id:"+1L+",maintenanceState.id :"+3L);// 3=en attente
        addMaintenanceToNotification(maintenanceListStateEnAttente, 1L, 2L); // maintenanceState =>2=>retard

        ////////if statut == cree et date declanchement < dateNow
        List<Maintenance> maintenanceDeclareList = maintenanceService.find("triggerDate<" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())+",programType.id:"+1L+",maintenanceState.id :"+1L );// 3=cree
        addMaintenanceToNotification(maintenanceDeclareList, 2L, 3L); //maintenanceState =>3= en attente

        //
        List<Maintenance> maintenanceConditionelList = maintenanceService.find("programType.id:"+2+",maintenanceState.id:"+ 1L); //1 =cree

        for(Maintenance m: maintenanceConditionelList){
            if(m.getConditionalType().getId()==1L) {
                if ((((Vehicle) (m.getPatrimony())).getCurrentMileage()) != null) {
                    if (m.getMileageNext().compareTo(((Vehicle) (m.getPatrimony())).getCurrentMileage().doubleValue()) <= 0) {

                        addMaintenanceToNotification(maintenanceConditionelList, 1L, 2L); //2= en retard

                    }
                }
            }
        }






    }

    private void addMaintenanceToNotification(List<Maintenance> maintenanceList, long notificationStateID, long maintenanceStateID ) throws IdNotFound, AttributesNotFound, ErrorType {

       // Notification notificationSearchMaintenance ;

        //List<Notification> notifications = new ArrayList<>();
        MaintenanceState maintenanceStateRetard = maintenanceStateService.findById(maintenanceStateID);//retard
        NotificationState notificationStateRetard = notificationStateService.findById(notificationStateID); // RETARD
        NotificationType notificationTypeM = notificationTypeService.findById(1L); // Maintenance

        if (maintenanceList.size() > 0) {
            for (Maintenance maintenanace : maintenanceList) {
                Notification notification = new Notification();
                Notification notificationSearchMaintenance= findOne("maintenanceId:"+maintenanace.getId());

                if(notificationSearchMaintenance == null) {
                    maintenanace.setMaintenanceState(maintenanceStateRetard);
                    maintenanceService.save(maintenanace);
                    notification.setCode(maintenanace.getCode());
                    notification.setNotificationType(notificationTypeM);
                    notification.setNotificationState(notificationStateRetard);
                    notification.setMaintenanceId(maintenanace.getId());
                    notification.setProgrameType(maintenanace.getProgramType().getCode());
                    notification.setServiceProvider(maintenanace.getServiceProvider());

                    notification.setResponsability(maintenanace.getResponsability());
                    notification.setAgent(maintenanace.getAgent());
                    if(maintenanace.getProgramType().getId()==1L) {
                        notification.setIntervention(maintenanace.getInterventionDate().toString());


                    }else if(maintenanace.getProgramType().getId()==2L){
                        notification.setIntervention(maintenanace.getMileageNext().toString());
                    }

                    notification.setProductId(0L);

                    if(maintenanace.getPatrimony() instanceof Vehicle){
                        notification.setPatrimonyType("vehicule");
                        notification.setPatimonyCode(((Vehicle) maintenanace.getPatrimony()).getRegistrationNumber());
                    }
                    else if(maintenanace.getPatrimony() instanceof Machine){
                        notification.setPatrimonyType("machine");
                        notification.setPatimonyCode(((Machine) maintenanace.getPatrimony()).getName());

                    }
                    notification.setAction(maintenanace.getActionType().getCode());
                    //notifications.add(notification);
                    save(notification);
                    MailConfig mail=mailConfigService.findById(1L);
                    Template template=templateService.findById(1L);
                    emailService.sendEmail(notification,mail,template);
                }
                else if (notificationSearchMaintenance.getNotificationState().getId()==2)//notificationStat =>2 => en attente
                {
                    notificationSearchMaintenance.setNotificationState(notificationStateRetard);
                    save(notificationSearchMaintenance);
                    MailConfig mail=mailConfigService.findById(1L);
                    Template template=templateService.findById(1L);
                    emailService.sendEmail(notification,mail,template);
                }

            }


           // saveAll(notifications);
        }
    }



    private void verifyStockProduct() throws AttributesNotFound, ErrorType, IdNotFound {

        Notification notificationSearchProduct ;
        List<Notification> notifications = new ArrayList<>();
        NotificationState notificationStatee = notificationStateService.findById(3L);//epuise
        List<Product> productList = productService.find("");
        NotificationType notificationTypeP = notificationTypeService.findById(2L); // Maintenance

        if (productList.size()>0) {

            for (Product product : productList) {
                Notification notification = new Notification();
                if (product.getMinStock() !=null){
                    if (product.getStockQuantity() == null) {
                        product.setStockQuantity(BigDecimal.ZERO);
                    }
                      notificationSearchProduct= findOne("productId:"+product.getId());


                        if (product.getStockQuantity().compareTo(product.getMinStock()) <= 0) {
                            if(notificationSearchProduct == null) {
                                notification.setCode(product.getCode());
                                notification.setNotificationType(notificationTypeP);
                                notification.setNotificationState(notificationStatee);
                                notification.setProductId(product.getId());
                                notification.setPatrimonyType(product.getProductType().getCode());
                                notification.setIntervention(product.getStockQuantity().toString());
                                notification.setMaintenanceId(0L);
                                notifications.add(notification);
                                MailConfig mail=mailConfigService.findById(1L);
                                Template template=templateService.findById(2L);
                                emailService.sendEmail(notification,mail,template);
                        }
                    }
                }
            }
            saveAll(notifications);
        }

    }


   /* private void verifyCOnditional() throws AttributesNotFound, ErrorType, IdNotFound {

        double latestKmMaintenance =0;
        double initialKm =0;
        double  actuelKm=0;
        BigDecimal conditionalKm;
        List<Maintenance> maintenanceList = maintenanceService.find("programType.id:" +2L+"maintenanceState.id:"+3L); //2L =corrective * /4L statut En Attante




        for(Maintenance maintenance :maintenanceList){
            List<Maintenance> maintenanceActionList = maintenanceService.find
                    ("actionType.id:"+maintenance.getActionType().getId()+
                            "patrimony.id:"+maintenance.getPatrimony().getId()) ;







            conditionalKm=maintenance.getValueconditionalType();
            conditionalKm =maintenance

            latestKmMaintenance=

           if(maintenance.getPatrimony() instanceof Vehicle) {
                latestKmMaintenance=  maintenance.getPatrimony().getm
            }
         double km = (maintenance.getPatrimony())
             if( maintenance.getPatrimony()){


             }
        }

       // addMaintenanceToNotification(maintenanceList, 1L, 2L); 2=retard




    }*/


}

