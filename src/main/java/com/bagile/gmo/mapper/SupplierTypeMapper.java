package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.SupplierType;
import com.bagile.gmo.entities.GmoSupplierType;

import java.util.*;

public class SupplierTypeMapper {
	public SupplierTypeMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoSupplierTypeId");
		map.put("code", "gmoSupplierTypeCode");
		map.put("description", "gmoSupplierTypeDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoSupplierType toEntity(SupplierType supplierType, boolean lazy) {
		if (null == supplierType) {
			return null;
		}
		GmoSupplierType gmoSupplierType = new GmoSupplierType();
		gmoSupplierType.setGmoSupplierTypeId(supplierType.getId());
		gmoSupplierType.setGmoSupplierTypeCode(supplierType.getCode() != null ? supplierType.getCode().toUpperCase() : null);
		gmoSupplierType.setGmoSupplierTypeDescription(supplierType.getDescription());

		if(!lazy){
			gmoSupplierType.setOwnOwner(OwnerMapper.toEntity(supplierType.getOwner(),true));
		}
		return gmoSupplierType;
	}

	public static SupplierType toDto(GmoSupplierType gmoSupplierType, boolean lazy) {
		if (null == gmoSupplierType) {
			return null;
		}
		SupplierType supplierType = new SupplierType();
		supplierType.setId(gmoSupplierType.getGmoSupplierTypeId());
		supplierType.setCode(gmoSupplierType.getGmoSupplierTypeCode() != null ? gmoSupplierType.getGmoSupplierTypeCode().toUpperCase() : null);
		supplierType.setDescription(gmoSupplierType.getGmoSupplierTypeDescription());

		if(!lazy){

			supplierType.setOwner(OwnerMapper.toDto(gmoSupplierType.getOwnOwner(),true));

		}
		return supplierType;

	}

	public static List<SupplierType> toDtos(Iterable<? extends GmoSupplierType> gmoSupplierTypes, boolean lazy) {
		if (null == gmoSupplierTypes) {
			return null;
		}
		List<SupplierType> supplierTypes = new ArrayList<>();

		for (GmoSupplierType gmoSupplierType : gmoSupplierTypes) {
			supplierTypes.add(toDto(gmoSupplierType, lazy));
		}
		return supplierTypes;
	}

	public static Set<GmoSupplierType> toEntities(List<SupplierType> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoSupplierType> gmoSupplierTypes = new HashSet<>();
		for (SupplierType supplierType : list) {
			gmoSupplierTypes.add(toEntity(supplierType, lazy));
		}
		return gmoSupplierTypes;
	}

	public static List<SupplierType> toDtos(List<GmoSupplierType> gmoSupplierTypes, boolean lazy) {
		if (null == gmoSupplierTypes) {
			return null;
		}
		List<SupplierType> supplierTypes = new ArrayList<>();
		for (GmoSupplierType gmoSupplierType : gmoSupplierTypes) {
			supplierTypes.add(toDto(gmoSupplierType, lazy));
		}
		return supplierTypes;
	}
}
