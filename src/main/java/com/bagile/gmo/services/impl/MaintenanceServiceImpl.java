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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


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
    private OrderStatusService orderStatusService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(MaintenanceService.class);

    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance save(Maintenance maintenance) throws AttributesNotFound, ErrorType {
        if(maintenance.getId()>0){
            if (maintenance.getMaintenanceState().getId() == 4)//fermer
            {
                Notification notification = notificationService.findOne("maintenanceId:" + maintenance.getId());
                if (notification != null) {

                    notificationService.delete(notification.getId());
                }
            }
          }




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
            else if (itemActionPlan.getPeriodicityType().getId() == 1){ //Hebdomadaire


                for(int i=0;i<itemActionPlan.getDays().size();i++) {
                    DateTime startDate =new DateTime(itemActionPlan.getStartDate());
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
                        maintenanceList.add(loadMaintenance(itemActionPlan,patrimony));
                        startDate = startDate.plusWeeks(1);
                    }
                }


            }



        }


        return saveAll(maintenanceList);

    }

    public Maintenance loadMaintenance(ActionPlan actionPlan,Patrimony patrimony) throws IOException {
        Maintenance maintenance = new Maintenance();


            DateTime dt = new DateTime(actionPlan.getInterventionDate());
            int day = actionPlan.getTriggerDay().intValue();
            maintenance.setTriggerDate(dt.minusDays(day).toDate());
            maintenance.setMaintenancePlan(actionPlan.getMaintenancePlan());
            maintenance.setInterventionDate(actionPlan.getInterventionDate());
            maintenance.setDuration(actionPlan.getDuration());
            maintenance.setAgent(actionPlan.getAgent());
            maintenance.setDeclaredDate(actionPlan.getDeclaredDate());
            maintenance.setProgramType(actionPlan.getProgramType());
            maintenance.setMaintenanceType(actionPlan.getMaintenanceType());
            maintenance.setServiceProvider(actionPlan.getServiceProvider());
            maintenance.setResponsability(actionPlan.getResponsability());
            maintenance.setCode(actionPlan.getMaintenancePlan().getCode());
            maintenance.setTriggerDay(actionPlan.getTriggerDay());
            maintenance.setTotalPrice(actionPlan.getTotalPrice());
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
    public void delete(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public void delete(Maintenance maintenancePlan) {
        maintenanceRepository.delete(MaintenanceMapper.toEntity(maintenancePlan, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            maintenanceRepository.deleteById(id);
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

}

