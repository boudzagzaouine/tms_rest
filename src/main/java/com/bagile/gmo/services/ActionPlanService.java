package com.bagile.gmo.services;

import com.bagile.gmo.dto.ActionPlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.io.IOException;
import java.util.List;

public interface ActionPlanService {

    ActionPlan save(ActionPlan actionPlan) throws AttributesNotFound, ErrorType, IOException;

    List<ActionPlan> saveAll(List<ActionPlan> actionPlans) throws AttributesNotFound, ErrorType, IOException;

    Long size();

    Boolean isExist(Long id);

    ActionPlan findById(Long id) throws IdNotFound;

    List<ActionPlan> find(String search) throws AttributesNotFound, ErrorType;

    List<ActionPlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ActionPlan actionPlan);

    void deleteAll(List<Long> ids) throws AttributesNotFound, ErrorType;

    List<ActionPlan> findAll();

    List<ActionPlan> findAll(int page, int size);

	ActionPlan findOne(String search) throws AttributesNotFound, ErrorType;




}
