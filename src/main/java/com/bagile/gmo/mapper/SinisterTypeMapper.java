package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.SinisterType;
import com.bagile.gmo.entities.GmoSinisterType;

import java.util.*;

public class SinisterTypeMapper {
	public SinisterTypeMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoSinisterTypeId");
		map.put("code", "gmoSinisterTypeCode");
		map.put("description", "gmoSinisterTypeDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoSinisterType toEntity(SinisterType sinisterType, boolean lazy) {
		if (null == sinisterType) {
			return null;
		}
		GmoSinisterType gmoSinisterType = new GmoSinisterType();
		gmoSinisterType.setGmoSinisterTypeId(sinisterType.getId());
		gmoSinisterType.setGmoSinisterTypeCode(sinisterType.getCode() != null ? sinisterType.getCode().toUpperCase() : null);
		gmoSinisterType.setGmoSinisterTypeDescription(sinisterType.getDescription());

		if(!lazy){
			gmoSinisterType.setOwnOwner(OwnerMapper.toEntity(sinisterType.getOwner(),true));


		}
		return gmoSinisterType;
	}

	public static SinisterType toDto(GmoSinisterType gmoSinisterType, boolean lazy) {
		if (null == gmoSinisterType) {
			return null;
		}
		SinisterType sinisterType = new SinisterType();
		sinisterType.setId(gmoSinisterType.getGmoSinisterTypeId());
		sinisterType.setCode(gmoSinisterType.getGmoSinisterTypeCode() != null ? gmoSinisterType.getGmoSinisterTypeCode().toUpperCase() : null);
		sinisterType.setDescription(gmoSinisterType.getGmoSinisterTypeDescription());

		if(!lazy){

			sinisterType.setOwner(OwnerMapper.toDto(gmoSinisterType.getOwnOwner(),true));

		}
		return sinisterType;

	}




	public static List<SinisterType> toDtos(Iterable<? extends GmoSinisterType> gmoSinisterTypes, boolean lazy) {
		if (null == gmoSinisterTypes) {
			return null;
		}
		List<SinisterType> sinisterTypes = new ArrayList<>();

		for (GmoSinisterType gmoSinisterType : gmoSinisterTypes) {
			sinisterTypes.add(toDto(gmoSinisterType, lazy));
		}
		return sinisterTypes;
	}

	public static Set<GmoSinisterType> toEntities(List<SinisterType> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoSinisterType> gmoSinisterTypes = new HashSet<>();
		for (SinisterType sinisterType : list) {
			gmoSinisterTypes.add(toEntity(sinisterType, lazy));
		}
		return gmoSinisterTypes;
	}

	public static List<SinisterType> toDtos(List<GmoSinisterType> gmoSinisterTypes, boolean lazy) {
		if (null == gmoSinisterTypes) {
			return null;
		}
		List<SinisterType> sinisterTypes = new ArrayList<>();
		for (GmoSinisterType gmoSinisterType : gmoSinisterTypes) {
			sinisterTypes.add(toDto(gmoSinisterType, lazy));
		}
		return sinisterTypes;
	}
}
