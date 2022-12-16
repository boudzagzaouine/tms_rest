package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ServiceType;
import com.bagile.gmo.entities.TmsServiceType;

import java.util.*;

public class ServiceTypeMapper {
	public ServiceTypeMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsServiceTypeId");
		map.put("code", "tmsServiceTypeCode");
		map.put("description", "tmsServiceTypeDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsServiceType toEntity(ServiceType serviceType, boolean lazy) {
		if (null == serviceType) {
			return null;
		}
		TmsServiceType tmsServiceType = new TmsServiceType();
		tmsServiceType.setTmsServiceTypeId(serviceType.getId());
		tmsServiceType.setTmsServiceTypeCode(serviceType.getCode() != null ? serviceType.getCode().toUpperCase() : null);
		tmsServiceType.setTmsServiceTypeDescription(serviceType.getDescription());

		if(!lazy){
			tmsServiceType.setOwnOwner(OwnerMapper.toEntity(serviceType.getOwner(),true));


		}
		return tmsServiceType;
	}

	public static ServiceType toDto(TmsServiceType tmsServiceType, boolean lazy) {
		if (null == tmsServiceType) {
			return null;
		}
		ServiceType serviceType = new ServiceType();
		serviceType.setId(tmsServiceType.getTmsServiceTypeId());
		serviceType.setCode(tmsServiceType.getTmsServiceTypeCode() != null ? tmsServiceType.getTmsServiceTypeCode().toUpperCase() : null);
		serviceType.setDescription(tmsServiceType.getTmsServiceTypeDescription());

		if(!lazy){

			serviceType.setOwner(OwnerMapper.toDto(tmsServiceType.getOwnOwner(),true));

		}
		return serviceType;

	}



	public static List<ServiceType> toDtos(Iterable<? extends TmsServiceType> tmsServiceTypes, boolean lazy) {
		if (null == tmsServiceTypes) {
			return null;
		}
		List<ServiceType> serviceTypes = new ArrayList<>();

		for (TmsServiceType tmsServiceType : tmsServiceTypes) {
			serviceTypes.add(toDto(tmsServiceType, lazy));
		}
		return serviceTypes;
	}

	public static Set<TmsServiceType> toEntities(List<ServiceType> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsServiceType> tmsServiceTypes = new HashSet<>();
		for (ServiceType serviceType : list) {
			tmsServiceTypes.add(toEntity(serviceType, lazy));
		}
		return tmsServiceTypes;
	}

	public static List<ServiceType> toDtos(List<TmsServiceType> tmsServiceTypes, boolean lazy) {
		if (null == tmsServiceTypes) {
			return null;
		}
		List<ServiceType> serviceTypes = new ArrayList<>();
		for (TmsServiceType tmsServiceType : tmsServiceTypes) {
			serviceTypes.add(toDto(tmsServiceType, lazy));
		}
		return serviceTypes;
	}
}
