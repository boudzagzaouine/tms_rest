package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.entities.GmoMaintenancePlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MaintenancePlanMapper;
import com.bagile.gmo.repositories.MaintenancePlanRepository;
import com.bagile.gmo.services.MaintenancePlanService;
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

public class MaintenancePlanServiceImpl implements MaintenancePlanService {

    private final MaintenancePlanRepository maintenancePlanRepository;

    private final MaintenanceService maintenanceService;

    @Autowired
    private SettingService settingService;
    public MaintenancePlanServiceImpl(MaintenancePlanRepository maintenancePreventiveRepository,
                                      MaintenanceService maintenanceService) {
        this.maintenancePlanRepository = maintenancePreventiveRepository;
 this.maintenanceService=maintenanceService;
    }



    @Override
    public MaintenancePlan save(MaintenancePlan maintenancePlan) throws AttributesNotFound, ErrorType, IOException {

        maintenancePlan = MaintenancePlanMapper.toDto(maintenancePlanRepository.save(MaintenancePlanMapper.toEntity(maintenancePlan, false)), false);

          if (maintenancePlan.getId() != 0) {
              List<Maintenance> maintenanceList = new ArrayList<>( );
              maintenanceList=  maintenanceService.find("maintenancePlan.id:"+maintenancePlan.getId());
              if( maintenanceList == null || maintenanceList.size() <= 0) {
                  this.maintenanceService.generateMaintenance(maintenancePlan);
              }else{
                  for(Maintenance m : maintenanceList){
                      if(m.getMaintenanceState().getId()!=4){
                          maintenanceService.delete(m);
                      }
                      else{
                          this.maintenanceService.generateMaintenance(maintenancePlan);
                      }
                  }
              }
          } else {
              this.maintenanceService.generateMaintenance(maintenancePlan);
          }

        return maintenancePlan;
    }



    @Override
    public List<MaintenancePlan> saveAll(List<MaintenancePlan> maintenancePreventives) throws AttributesNotFound, ErrorType, IOException {

        List<MaintenancePlan> MaintenancePreventiveList = new ArrayList<>( );
        for (MaintenancePlan action : maintenancePreventives) {
            MaintenancePreventiveList.add (save (action));
        }
        return MaintenancePreventiveList;
    }

    @Override
    public Long size() {
        return maintenancePlanRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenancePlanRepository.existsById(id);
    }

    @Override
    public MaintenancePlan findById(Long id) throws IdNotFound {
        return MaintenancePlanMapper.toDto(maintenancePlanRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<MaintenancePlan> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(Search.expression(search, GmoMaintenancePlan.class)), false);
    }

    @Override
    public List<MaintenancePlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(Search.expression(search, GmoMaintenancePlan.class), pageable), false);
    }

    @Override
    public MaintenancePlan findOne(String search) throws AttributesNotFound, ErrorType {
        return MaintenancePlanMapper.toDto (maintenancePlanRepository.findOne (Search.expression (search, GmoMaintenancePlan.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return maintenancePlanRepository.count(Search.expression(search, GmoMaintenancePlan.class));
    }

    @Override
    public void delete(Long id) {
        maintenancePlanRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenancePlan maintenancePreventive) {
        maintenancePlanRepository.delete(MaintenancePlanMapper.toEntity(maintenancePreventive, false));
    }

    @Override
          public void deleteAll(List<Long> ids) throws AttributesNotFound, ErrorType {
            List<Maintenance> maintenanceList = new ArrayList<>( );

            for (Long id : ids) {
                maintenanceList = maintenanceService.find("maintenancePlan.id:"+id);
                if( maintenanceList != null || maintenanceList.size() >= 0) {
                    for (Maintenance m : maintenanceList) {
                        if (m.getMaintenanceState().getId() != 4) {
                            maintenanceService.delete(m.getId());
                        }

                    }
                }
                maintenancePlanRepository.deleteById(id);
            }

    }
    @Override
    public List<MaintenancePlan> findAll() {
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(), false);
    }

    @Override
    public List<MaintenancePlan> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(pageable), false);
    }


    @Override
    public String getNextVal() {
        String value=settingService.generateCodeMaintenancePlan() + maintenancePlanRepository.getNextVal().get(0);
        return value;


    }


}

