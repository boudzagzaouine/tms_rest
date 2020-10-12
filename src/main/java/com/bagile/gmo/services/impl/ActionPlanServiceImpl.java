package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.dto.ActionPlan;
import com.bagile.gmo.entities.GmoActionPlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ActionPlanMapper;
import com.bagile.gmo.repositories.ActionPlanRepository;
import com.bagile.gmo.services.ActionPlanService;
import com.bagile.gmo.services.MaintenanceService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service

public class ActionPlanServiceImpl implements ActionPlanService {

    private final ActionPlanRepository actionPlanRepository;

    private final MaintenanceService maintenanceService;

    @Autowired
    private SettingService settingService;
    public ActionPlanServiceImpl(ActionPlanRepository maintenancePreventiveRepository,
                                 MaintenanceService maintenanceService) {
        this.actionPlanRepository = maintenancePreventiveRepository;
 this.maintenanceService=maintenanceService;
    }



    @Override
    public ActionPlan save(ActionPlan actionPlan) throws AttributesNotFound, ErrorType, IOException {

        actionPlan = ActionPlanMapper.toDto(actionPlanRepository.save(ActionPlanMapper.toEntity(actionPlan, false)), false);



        return actionPlan;
    }



    @Override
    public List<ActionPlan> saveAll(List<ActionPlan> maintenancePreventives) throws AttributesNotFound, ErrorType, IOException {

        List<ActionPlan> MaintenancePreventiveList = new ArrayList<>( );
        for (ActionPlan action : maintenancePreventives) {
            MaintenancePreventiveList.add (save (action));
        }
        return MaintenancePreventiveList;
    }

    @Override
    public Long size() {
        return actionPlanRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return actionPlanRepository.existsById(id);
    }

    @Override
    public ActionPlan findById(Long id) throws IdNotFound {
        return ActionPlanMapper.toDto(actionPlanRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<ActionPlan> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ActionPlanMapper.toDtos(actionPlanRepository.findAll(Search.expression(search, GmoActionPlan.class)), false);
    }

    @Override
    public List<ActionPlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionPlanMapper.toDtos(actionPlanRepository.findAll(Search.expression(search, GmoActionPlan.class), pageable), false);
    }

    @Override
    public ActionPlan findOne(String search) throws AttributesNotFound, ErrorType {
        return ActionPlanMapper.toDto (actionPlanRepository.findOne (Search.expression (search, GmoActionPlan.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return actionPlanRepository.count(Search.expression(search, GmoActionPlan.class));
    }

    @Override
    public void delete(Long id) {
        actionPlanRepository.deleteById(id);
    }

    @Override
    public void delete(ActionPlan maintenancePreventive) {
        actionPlanRepository.delete(ActionPlanMapper.toEntity(maintenancePreventive, false));
    }

    @Override
          public void deleteAll(List<Long> ids) throws AttributesNotFound, ErrorType {
            List<Maintenance> maintenanceList = new ArrayList<>( );

            for (Long id : ids) {
                maintenanceList = maintenanceService.find("actionPlan.id:"+id);
                if( maintenanceList != null || maintenanceList.size() >= 0) {
                    for (Maintenance m : maintenanceList) {
                        if (m.getMaintenanceState().getId() != 4) {
                            maintenanceService.delete(m.getId());
                        }

                    }
                }
                actionPlanRepository.deleteById(id);
            }

    }
    @Override
    public List<ActionPlan> findAll() {
        return ActionPlanMapper.toDtos(actionPlanRepository.findAll(), false);
    }

    @Override
    public List<ActionPlan> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionPlanMapper.toDtos(actionPlanRepository.findAll(pageable), false);
    }





}

