package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.PackagingType;
import com.bagile.gmo.entities.TmsPackagingType;

import java.util.*;

public class PackagingTypeMapper {
	public PackagingTypeMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsPackagingTypeId");
		map.put("code", "tmsPackagingTypeCode");
		map.put("description", "tmsPackagingTypeDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsPackagingType toEntity(PackagingType packagingType, boolean lazy) {
		if (null == packagingType) {
			return null;
		}
		TmsPackagingType tmsPackagingType = new TmsPackagingType();
		tmsPackagingType.setTmsPackagingTypeId(packagingType.getId());
		tmsPackagingType.setTmsPackagingTypeCode(packagingType.getCode() != null ? packagingType.getCode().toUpperCase() : null);
		tmsPackagingType.setTmsPackagingTypeDescription(packagingType.getDescription());

		if(!lazy){
			tmsPackagingType.setOwnOwner(OwnerMapper.toEntity(packagingType.getOwner(),true));
			

		}
		return tmsPackagingType;
	}

	public static PackagingType toDto(TmsPackagingType tmsPackagingType, boolean lazy) {
		if (null == tmsPackagingType) {
			return null;
		}
		PackagingType packagingType = new PackagingType();
		packagingType.setId(tmsPackagingType.getTmsPackagingTypeId());
		packagingType.setCode(tmsPackagingType.getTmsPackagingTypeCode() != null ? tmsPackagingType.getTmsPackagingTypeCode().toUpperCase() : null);
		packagingType.setDescription(tmsPackagingType.getTmsPackagingTypeDescription());

		if(!lazy){

			packagingType.setOwner(OwnerMapper.toDto(tmsPackagingType.getOwnOwner(),true));

		}
		return packagingType;

	}

	


	public static List<PackagingType> toDtos(Iterable<? extends TmsPackagingType> tmsPackagingTypes, boolean lazy) {
		if (null == tmsPackagingTypes) {
			return null;
		}
		List<PackagingType> packagingTypes = new ArrayList<>();

		for (TmsPackagingType tmsPackagingType : tmsPackagingTypes) {
			packagingTypes.add(toDto(tmsPackagingType, lazy));
		}
		return packagingTypes;
	}

	public static Set<TmsPackagingType> toEntities(List<PackagingType> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsPackagingType> tmsPackagingTypes = new HashSet<>();
		for (PackagingType packagingType : list) {
			tmsPackagingTypes.add(toEntity(packagingType, lazy));
		}
		return tmsPackagingTypes;
	}

	public static List<PackagingType> toDtos(List<TmsPackagingType> tmsPackagingTypes, boolean lazy) {
		if (null == tmsPackagingTypes) {
			return null;
		}
		List<PackagingType> packagingTypes = new ArrayList<>();
		for (TmsPackagingType tmsPackagingType : tmsPackagingTypes) {
			packagingTypes.add(toDto(tmsPackagingType, lazy));
		}
		return packagingTypes;
	}
}
