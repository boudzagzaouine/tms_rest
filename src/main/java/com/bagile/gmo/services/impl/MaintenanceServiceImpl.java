package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.GmoMaintenance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.CustomException;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MaintenanceMapper;
import com.bagile.gmo.repositories.MaintenanceRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.Search;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;


@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    @Autowired
    private SettingService settingService;

    @Autowired
    private ActionLineMaintenanceService actionLineMaintenanceService;

    @Autowired
    private MaintenanceStockService maintenanceStockService;

    @Autowired
    private StockService stockService;

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private MaintenancePlanService maintenancePlanService;

    @Autowired
    private MaintenanceStateService maintenanceStateService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(MaintenanceService.class);

    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance save(Maintenance maintenance) throws AttributesNotFound, ErrorType {
     /*   if(maintenance.getId()>0){
            if (maintenance.getMaintenanceState().getId() == 4)//fermer
            {
                Notification notification = notificationService.findOne("maintenanceId:" + maintenance.getId());
                if (notification != null) {

                    notificationService.delete(notification.getId());
                }
            }
          }*/



        return MaintenanceMapper.toDto(maintenanceRepository.save(MaintenanceMapper.toEntity(maintenance, false)), false);

    }

    @Override
    public List<Maintenance> saveAll(List<Maintenance> maintenances) throws AttributesNotFound, ErrorType {

        List<Maintenance> maintenanceList = new ArrayList<>();

        for (Maintenance action : maintenances) {
            maintenanceList.add(save(action));
        }

        return maintenanceList;

    }


    @Override
    public List<Maintenance> generateMaintenance(Patrimony patrimony) throws IOException, AttributesNotFound, ErrorType, IdNotFound {
        List<Maintenance> maintenanceList = new ArrayList<>();
        MaintenancePlan maintenancePlan = maintenancePlanService.findById(patrimony.getMaintenancePlan().getId());

        for (ActionPlan itemActionPlan: maintenancePlan.getActionPlans()) {

            if(itemActionPlan.getProgramType().getId()==1L){ //systematique
            if (itemActionPlan.getPeriodicityType().getId() == 3) { //Fixer une date
                maintenanceList.add(loadMaintenance(itemActionPlan,patrimony));
            } else if (itemActionPlan.getPeriodicityType().getId() == 2) {//Mensuel

                Date dtS = itemActionPlan.getStartDate();
                Date dtE = itemActionPlan.getEndDate();
                int nbr = dtE.getYear() - dtS.getYear();
                List<Integer> years = new ArrayList<>();
                Collections.sort(itemActionPlan.getMonths(), (o1, o2) ->
                        ((Long) o1.getValue()).compareTo(o2.getValue()));

                for (int i = 0; i <= nbr; i++) {
                    years.add(dtS.getYear() + i);
                }
                for (int i = 0; i <= nbr; i++) {
                    for (int j = 0; j < itemActionPlan.getMonths().size(); j++) {
                        Date dat = new Date();
                        int day = (int) itemActionPlan.getDayOfMonth();
                        int month = (int) itemActionPlan.getMonths().get(j).getValue();
                        //TODO TEST NULL POINTER EXCEPTION
                        dat.setDate(day);
                        dat.setMonth(month);
                        dat.setYear(dtS.getYear() + i);
                        //after
                        if (dat.after(dtS) && dat.before(dtE)) {
                            itemActionPlan.setInterventionDate(dat);

                            maintenanceList.add(loadMaintenance(itemActionPlan,patrimony));
                            //before
                        } else if (dat.before(dtE) && dat.after(dtS)) {
                            itemActionPlan.setInterventionDate(dat);
                            maintenanceList.add(loadMaintenance(itemActionPlan,patrimony));
                        }
                    }
                }

            }
            else if (itemActionPlan.getPeriodicityType().getId() == 1) { //Hebdomadaire


                for (int i = 0; i < itemActionPlan.getDays().size(); i++) {
                    DateTime startDate = new DateTime(itemActionPlan.getStartDate());
                    DateTime endDate = new DateTime(itemActionPlan.getEndDate());
                    int day = (int) itemActionPlan.getDays().get(i).getValue();

                    DateTime thisDay = startDate.withDayOfWeek(day).toDateTime();

                    if (startDate.isAfter(thisDay)) {
                        startDate = thisDay.plusWeeks(1);
                    } else {
                        startDate = thisDay;
                    }
                    while (startDate.isBefore(endDate)) {

                        itemActionPlan.setInterventionDate(startDate.toDate());
                        maintenanceList.add(loadMaintenance(itemActionPlan, patrimony));
                        startDate = startDate.plusWeeks(1);
                    }
                }

            }
            }



            if(itemActionPlan.getProgramType().getId()==2L) { //conditionnel

                Maintenance maintenance =getMaintenanceByActionType(itemActionPlan.getActionType().getId(),patrimony.getId()) ;
                double kmlastMaintenance;
                double Kmcondition;
                double kmNext;
                 if(maintenance !=null) {
                      kmlastMaintenance=maintenance.getMileage();
                      Kmcondition =itemActionPlan.getValueconditionalType().doubleValue();
                      kmNext=kmlastMaintenance+Kmcondition ;

                           itemActionPlan.setMileage(kmNext);
                     maintenanceList.add(loadMaintenance(itemActionPlan, patrimony));
                 }
                 else if(patrimony instanceof  Vehicle)  {
                     kmlastMaintenance=   ((Vehicle) patrimony).getInitialMileage().doubleValue();
                     Kmcondition =itemActionPlan.getValueconditionalType().doubleValue();
                     kmNext=kmlastMaintenance+Kmcondition ;
                     itemActionPlan.setMileage(kmNext);
                     maintenanceList.add(loadMaintenance(itemActionPlan, patrimony));

                 }

            }



            }


        return saveAll(maintenanceList);

    }

    public Maintenance loadMaintenance(ActionPlan actionPlan,Patrimony patrimony) throws IOException, IdNotFound {
        Maintenance maintenance = new Maintenance();

         MaintenanceState maintenanceState =maintenanceStateService.findById(1L);

             if(actionPlan.getProgramType().getId()==1){//systematique
                 DateTime dt = new DateTime(actionPlan.getInterventionDate());
                 int day = actionPlan.getTriggerDay().intValue();
                 maintenance.setTriggerDate(dt.minusDays(day).toDate());
                 maintenance.setInterventionDate(actionPlan.getInterventionDate());
                 maintenance.setTriggerDay(actionPlan.getTriggerDay());
             }

        if(actionPlan.getProgramType().getId()==2){//conditionnelle
            maintenance.setConditionalType(actionPlan.getConditionalType());
            maintenance.setValueconditionalType(actionPlan.getValueconditionalType());
            maintenance.setMileageNext(actionPlan.getMileage());
        }
            maintenance.setCode(getNextVal());
            maintenance.setProgramType(actionPlan.getProgramType());
            maintenance.setMaintenanceState(maintenanceState);
            maintenance.setMaintenancePlan(actionPlan.getMaintenancePlan());
            maintenance.setAgent(actionPlan.getAgent());
            maintenance.setDeclaredDate(actionPlan.getDeclaredDate());
            maintenance.setMaintenanceType(actionPlan.getMaintenanceType());
            maintenance.setServiceProvider(actionPlan.getServiceProvider());
            maintenance.setResponsability(actionPlan.getResponsability());
            //maintenance.setCode(actionPlan.getMaintenancePlan().getCode());

            maintenance.setPatrimony(patrimony);
                maintenance.setActionType(actionPlan.getActionType());

           /* List<ActionLineMaintenance> actionLineMaintenanaces = new ArrayList<>();

            maintenance.setActionLineMaintenances(actionLineMaintenanaces);*/



        return maintenance;
    }

    @Override
    public Long size() {
        return maintenanceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenanceRepository.existsById(id);
    }

    @Override
    public Maintenance findById(Long id) throws IdNotFound {
        return MaintenanceMapper.toDto(maintenanceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<Maintenance> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll();
        }
        return MaintenanceMapper.toDtos(maintenanceRepository.findAll(Search.expression(search, GmoMaintenance.class)), false);
    }

    @Override
    public List<Maintenance> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll(page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceMapper.toDtos(maintenanceRepository.findAll(Search.expression(search, GmoMaintenance.class), pageable), false);
    }

    @Override
    public Maintenance findOne(String search) throws AttributesNotFound, ErrorType {
        return MaintenanceMapper.toDto(maintenanceRepository.findOne(Search.expression(search, GmoMaintenance.class)).orElseThrow(() -> new AttributesNotFound(search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return size();
        }
        return maintenanceRepository.count(Search.expression(search, GmoMaintenance.class));
    }

    @Override
    public void delete(Long id) throws AttributesNotFound, ErrorType {

        maintenanceRepository.deleteById(id);
        Notification notification = notificationService.findOne("maintenanceId:" + id);
        if (notification != null) {

            notificationService.delete(notification.getId());
        }
    }

    @Override
    public void delete(Maintenance maintenancePlan) throws AttributesNotFound, ErrorType {
        maintenanceRepository.delete(MaintenanceMapper.toEntity(maintenancePlan, false));

        Notification notification = notificationService.findOne("maintenanceId:" + maintenancePlan.getId());
        if (notification != null) {

            notificationService.delete(notification.getId());
        }
    }

    @Override
    public void deleteAll(List<Long> ids) throws AttributesNotFound, ErrorType {

        for (Long id : ids) {
            maintenanceRepository.deleteById(id);
            Notification notification = notificationService.findOne("maintenanceId:" + id);
            if (notification != null) {

                notificationService.delete(notification.getId());
            }
        }
    }

    @Override
    public List<Maintenance> findAll() {
        return MaintenanceMapper.toDtos(maintenanceRepository.findAll(), false);
    }

    @Override
    public List<Maintenance> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceMapper.toDtos(maintenanceRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        String value=settingService.generateCodeMaintenance() + maintenanceRepository.getNextVal().get(0);
        return value;
    }

    @Override
    public void updateMaintenance(Maintenance maintenance) {
        try {
            maintenance = findById(maintenance.getId());
            maintenance.setActionLineMaintenances(new ArrayList<>(actionLineMaintenanceService.find("maintenance.id:"+ maintenance.getId())));
            List<MaintenanceStock> maintenanceStocks = maintenanceStockService.find("maintenance.id:" + maintenance.getId());
            for (MaintenanceStock maintenanceStock : maintenanceStocks) {
                if (null != maintenanceStock.getStock()) {
                    Stock stock = stockService.findById(maintenanceStock.getStock().getId());
                    stock.setActive(false);
                    stockService.save(stock);
                }
            }
            save(maintenance);

        } catch (AttributesNotFound | ErrorType | IdNotFound | CustomException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public Maintenance getMaintenanceByActionType(long actionTypeId, long patrimonyId) {
        return maintenanceRepository.getMaintenanceByActionType(actionTypeId, patrimonyId);
    }


    @Override
    public Maintenance closeMaintenance(Maintenance maintenance) throws IdNotFound, AttributesNotFound, ErrorType {
        MaintenanceState stateF = maintenanceStateService.findById(4L);
        maintenance.setMaintenanceState(stateF);
        Maintenance maintenance1= save(maintenance);
      //  updateMaintenance(maintenance1);
  // programetype = conditionnelle
       if(maintenance.getProgramType().getId()==2L) {
            loadMaintenanceByM(maintenance);

        }

        Notification notification = notificationService.findOne("maintenanceId:" + maintenance.getId());
        if (notification != null) {

            notificationService.delete(notification.getId());
        }

            return maintenance1;
    }


    private void loadMaintenanceByM (Maintenance maintenance) throws IdNotFound, AttributesNotFound, ErrorType {
        Maintenance maintenance2 = new Maintenance();
        MaintenanceState stateE = maintenanceStateService.findById(1L);//En Attente

        double kmlastMaintenance;
        double Kmcondition;
        double kmNext;

        kmlastMaintenance=maintenance.getMileage();
        Kmcondition =maintenance.getValueconditionalType().doubleValue();
        kmNext=kmlastMaintenance+Kmcondition ;
        maintenance2.setMileageNext(kmNext);

        maintenance.setCode(getNextVal());

        maintenance2.setCode(getNextVal());

        maintenance2.setConditionalType(maintenance.getConditionalType());
        maintenance2.setValueconditionalType(maintenance.getValueconditionalType());
        maintenance2.setConditionalType(maintenance.getConditionalType());
        maintenance2.setValueconditionalType(maintenance.getValueconditionalType());
        maintenance2.setProgramType(maintenance.getProgramType());
        maintenance2.setMaintenanceState(stateE);
        maintenance2.setMaintenancePlan(maintenance.getMaintenancePlan());
        maintenance2.setAgent(maintenance.getAgent());
      //  maintenance2.setDeclaredDate(maintenance.getDeclaredDate());
        maintenance2.setMaintenanceType(maintenance.getMaintenanceType());
        maintenance2.setServiceProvider(maintenance.getServiceProvider());
        maintenance2.setResponsability(maintenance.getResponsability());
        maintenance2.setPatrimony(maintenance.getPatrimony());
        maintenance2.setActionType(maintenance.getActionType());

        save(maintenance2);

    }

}

