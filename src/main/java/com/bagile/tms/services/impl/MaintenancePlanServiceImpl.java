package com.bagile.tms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.dto.MaintenanceState;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.repositories.MaintenancePlanRepository;
import com.bagile.tms.services.MaintenancePlanService;
import com.bagile.tms.services.ProductService;

public class MaintenancePlanServiceImpl implements MaintenancePlanService {

	@Autowired
	MaintenancePlanRepository maintenancePlanRepository;
	
	@Autowired
	ProductService productService;
	
	@Override
	public MaintenancePlan save(MaintenancePlan maintenancePlan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long size() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isExist(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaintenancePlan findById(Long id) throws IdNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MaintenancePlan> find(String search) throws AttributesNotFound, ErrorType {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MaintenancePlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long size(String search) throws AttributesNotFound, ErrorType {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MaintenancePlan maintenancePlan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MaintenancePlan> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MaintenancePlan> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
