package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.MarchandiseType;
import com.bagile.gmo.entities.TmsMarchandiseType;

import java.util.*;

public class MarchandiseTypeMapper {
	public MarchandiseTypeMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsMarchandiseTypeId");
		map.put("code", "tmsMarchandiseTypeCode");
		map.put("description", "tmsMarchandiseTypeDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsMarchandiseType toEntity(MarchandiseType marchandiseType, boolean lazy) {
		if (null == marchandiseType) {
			return null;
		}
		TmsMarchandiseType tmsMarchandiseType = new TmsMarchandiseType();
		tmsMarchandiseType.setTmsMarchandiseTypeId(marchandiseType.getId());
		tmsMarchandiseType.setTmsMarchandiseTypeCode(marchandiseType.getCode() != null ? marchandiseType.getCode().toUpperCase() : null);
		tmsMarchandiseType.setTmsMarchandiseTypeDescription(marchandiseType.getDescription());

		if(!lazy){
			tmsMarchandiseType.setOwnOwner(OwnerMapper.toEntity(marchandiseType.getOwner(),true));


		}
		return tmsMarchandiseType;
	}

	public static MarchandiseType toDto(TmsMarchandiseType tmsMarchandiseType, boolean lazy) {
		if (null == tmsMarchandiseType) {
			return null;
		}
		MarchandiseType marchandiseType = new MarchandiseType();
		marchandiseType.setId(tmsMarchandiseType.getTmsMarchandiseTypeId());
		marchandiseType.setCode(tmsMarchandiseType.getTmsMarchandiseTypeCode() != null ? tmsMarchandiseType.getTmsMarchandiseTypeCode().toUpperCase() : null);
		marchandiseType.setDescription(tmsMarchandiseType.getTmsMarchandiseTypeDescription());

		if(!lazy){

			marchandiseType.setOwner(OwnerMapper.toDto(tmsMarchandiseType.getOwnOwner(),true));

		}
		return marchandiseType;

	}




	public static List<MarchandiseType> toDtos(Iterable<? extends TmsMarchandiseType> tmsMarchandiseTypes, boolean lazy) {
		if (null == tmsMarchandiseTypes) {
			return null;
		}
		List<MarchandiseType> marchandiseTypes = new ArrayList<>();

		for (TmsMarchandiseType tmsMarchandiseType : tmsMarchandiseTypes) {
			marchandiseTypes.add(toDto(tmsMarchandiseType, lazy));
		}
		return marchandiseTypes;
	}

	public static Set<TmsMarchandiseType> toEntities(List<MarchandiseType> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsMarchandiseType> tmsMarchandiseTypes = new HashSet<>();
		for (MarchandiseType marchandiseType : list) {
			tmsMarchandiseTypes.add(toEntity(marchandiseType, lazy));
		}
		return tmsMarchandiseTypes;
	}

	public static List<MarchandiseType> toDtos(List<TmsMarchandiseType> tmsMarchandiseTypes, boolean lazy) {
		if (null == tmsMarchandiseTypes) {
			return null;
		}
		List<MarchandiseType> marchandiseTypes = new ArrayList<>();
		for (TmsMarchandiseType tmsMarchandiseType : tmsMarchandiseTypes) {
			marchandiseTypes.add(toDto(tmsMarchandiseType, lazy));
		}
		return marchandiseTypes;
	}
}
