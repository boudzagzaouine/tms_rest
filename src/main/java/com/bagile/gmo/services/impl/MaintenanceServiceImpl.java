package com.bagile.gmo.services.impl;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.ZoneId;
import java.util.*;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.GmoMaintenance;
import com.bagile.gmo.util.EmsClone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MaintenanceMapper;
import com.bagile.gmo.repositories.MaintenanceRepository;
import com.bagile.gmo.services.MaintenanceService;
import com.bagile.gmo.util.Search;


@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        return MaintenanceMapper.toDto(maintenanceRepository.save(MaintenanceMapper.toEntity(maintenance, false)), false);
    }

    @Override
    public List<Maintenance> saveAll(List<Maintenance> maintenances) {

        List<Maintenance> maintenanceList = new ArrayList<>();

        for (Maintenance action : maintenances) {
            maintenanceList.add(save(action));
        }

        return maintenanceList;

    }

    @Override
    public List<Maintenance> generateMaintenance(MaintenancePlan maintenancePlan) throws IOException {
        List<Maintenance> maintenanceList = new ArrayList<>();

        if (maintenancePlan.getPeriodicityType().getId() == 3) {
            maintenanceList.add(loadMaintenance(maintenancePlan));
        } else if (maintenancePlan.getPeriodicityType().getId() == 2) {

                Date dtS = maintenancePlan.getStartDate();
                Date dtE = maintenancePlan.getEndDate();
                int nbr = dtE.getYear() - dtS.getYear();
                List<Integer> years = new ArrayList<>();
                Collections.sort(maintenancePlan.getMonths(), (o1, o2) ->
                        ((Long) o1.getValue()).compareTo(o2.getValue()));

                for (int i = 0; i <= nbr; i++) {
                    years.add(dtS.getYear() + i);
                }
                for (int i = 0; i <= nbr; i++) {
                for (int j = 0; j < maintenancePlan.getMonths().size(); j++) {
                    Date dat = new Date();
                    int day = (int) maintenancePlan.getDayOfMonth();
                    int month = (int) maintenancePlan.getMonths().get(j).getValue();
                    //TODO TEST NULL POINTER EXCEPTION
                    dat.setDate(day);
                    dat.setMonth(month);
                    dat.setYear(dtS.getYear() + i);
                    //after
                    if (dat.after(dtS) && dat.before(dtE)) {
                        maintenancePlan.setInterventionDate(dat);

                        maintenanceList.add(loadMaintenance(maintenancePlan));
                        //before
                    } else if (dat.before(dtE) && dat.after(dtS)) {
                        maintenancePlan.setInterventionDate(dat);
                        maintenanceList.add(loadMaintenance(maintenancePlan));
                    }
                }
            }

        }
        else if (maintenancePlan.getPeriodicityType().getId() == 1){


            for(int i=0;i<maintenancePlan.getDays().size();i++) {
                DateTime startDate =new DateTime(maintenancePlan.getStartDate());
                DateTime endDate = new DateTime(maintenancePlan.getEndDate());
                int day = (int) maintenancePlan.getDays().get(i).getValue();

                DateTime thisDay = startDate.withDayOfWeek(day).toDateTime();

                if (startDate.isAfter(thisDay)) {
                    startDate = thisDay.plusWeeks(1);
                } else {
                    startDate = thisDay;
                }
                while (startDate.isBefore(endDate)) {

                    maintenancePlan.setInterventionDate(startDate.toDate());
                    maintenanceList.add(loadMaintenance(maintenancePlan));
                    startDate = startDate.plusWeeks(1);
                }
            }


        }

        return saveAll(maintenanceList);

    }

    public Maintenance loadMaintenance(MaintenancePlan maintenancePlan) throws IOException {
        Maintenance maintenance = new Maintenance();
        DateTime dt = new DateTime(maintenancePlan.getInterventionDate());
        int day = maintenancePlan.getTriggerDay().intValue();
        maintenance.setTriggerDate(dt.minusDays(day).toDate());
        maintenance.setMaintenancePlan(maintenancePlan);
        maintenance.setInterventionDate(maintenancePlan.getInterventionDate());
        maintenance.setDuration(maintenancePlan.getDuration());
        maintenance.setAgent(maintenancePlan.getAgent());
        maintenance.setDeclaredDate(maintenancePlan.getDeclaredDate());
        maintenance.setProgramType(maintenancePlan.getProgramType());
        maintenance.setMaintenanceType(maintenancePlan.getMaintenanceType());
        maintenance.setMaintenanceState(maintenancePlan.getMaintenanceState());
        maintenance.setServiceProvider(maintenancePlan.getServiceProvider());
        maintenance.setResponsability(maintenancePlan.getResponsability());
        maintenance.setCode(maintenancePlan.getCode());
        maintenance.setTriggerDay(maintenancePlan.getTriggerDay());
        maintenance.setTotalPrice(maintenancePlan.getTotalPrice());
        maintenance.setPatrimony(maintenancePlan.getPatrimony());

        List<ActionMaintenance> actionMaintenanaces = new ArrayList<>();
        List<ActionLineMaintenance> actionLineMaintenanaces = new ArrayList<>();

        for (Action action : maintenancePlan.getActions()) {
               ActionMaintenance newActionMaintenance =new ActionMaintenance() ;
               newActionMaintenance.setId(0);
               newActionMaintenance.setActionType(action.getActionType());
               newActionMaintenance.setMaintenanceState(action.getMaintenanceState());

               maintenancePlan.getActions().forEach(
                    e->{
                        ActionLineMaintenance newActionLineMaintenance=new ActionLineMaintenance();
                        e.getActionLines().forEach(
                                a->{
                                    newActionLineMaintenance.setId(0);
                                    newActionLineMaintenance.setProduct(a.getProduct());
                                    newActionLineMaintenance.setAmountVat(a.getAmountVat());
                                    newActionLineMaintenance.setDescription(a.getDescription());
                                    newActionLineMaintenance.setQuantity(a.getQuantity());
                                    newActionLineMaintenance.setTotalPriceTTC(a.getTotalPriceTTC());
                                    newActionLineMaintenance.setTotalPriceHT(a.getTotalPriceHT());
                                    actionLineMaintenanaces.add(newActionLineMaintenance);
                                }
                        );

                        newActionMaintenance.setActionLineMaintenances(actionLineMaintenanaces);

                    }


            );
                actionMaintenanaces.add(newActionMaintenance);

        }
        maintenance.setActionMaintenances(actionMaintenanaces);

            return maintenance;
    }

    private List<ActionLine> generateActionLines(List<ActionLine> actionLines) throws IOException {
        List<ActionLine> newActionLines = new ArrayList<>();
      /*  actionLines.forEach(actionLine -> {
            try {
                ActionLine newActionLine = EmsClone.clone(actionLine, ActionLine.class);
                newActionLine.setId(0 - newActionLines.size());
                newActionLines.add(newActionLine);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });*/
        return newActionLines;
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


}

