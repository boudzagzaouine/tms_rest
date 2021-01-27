package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ActionType;
import com.bagile.gmo.entities.GmoActionType;

import java.util.*;

public class ActionTypeMapper {
	public ActionTypeMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoActionTypeId");
		map.put("code", "gmoActionTypeCode");
		map.put("description", "gmoActionTypeDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoActionType toEntity(ActionType actionType, boolean lazy) {
		if (null == actionType) {
			return null;
		}
		GmoActionType gmoActionType = new GmoActionType();
		gmoActionType.setGmoActionTypeId(actionType.getId());
		gmoActionType.setGmoActionTypeCode(actionType.getCode() != null ? actionType.getCode().toUpperCase() : null);
		gmoActionType.setGmoActionTypeDescription(actionType.getDescription());

		if(!lazy){
			gmoActionType.setOwnOwner(OwnerMapper.toEntity(actionType.getOwner(),true));
		}
		return gmoActionType;
	}

	public static ActionType toDto(GmoActionType gmoActionType, boolean lazy) {
		if (null == gmoActionType) {
			return null;
		}
		ActionType actionType = new ActionType();
		actionType.setId(gmoActionType.getGmoActionTypeId());
		actionType.setCode(gmoActionType.getGmoActionTypeCode() != null ? gmoActionType.getGmoActionTypeCode().toUpperCase() : null);
		actionType.setDescription(gmoActionType.getGmoActionTypeDescription());

		if(!lazy){

			actionType.setOwner(OwnerMapper.toDto(gmoActionType.getOwnOwner(),true));

		}
		return actionType;

	}

	public static List<ActionType> toDtos(Iterable<? extends GmoActionType> gmoActionTypes, boolean lazy) {
		if (null == gmoActionTypes) {
			return null;
		}
		List<ActionType> actionTypes = new ArrayList<>();

		for (GmoActionType gmoActionType : gmoActionTypes) {
			actionTypes.add(toDto(gmoActionType, lazy));
		}
		return actionTypes;
	}

	public static Set<GmoActionType> toEntities(List<ActionType> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoActionType> gmoActionTypes = new HashSet<>();
		for (ActionType actionType : list) {
			gmoActionTypes.add(toEntity(actionType, lazy));
		}
		return gmoActionTypes;
	}

	public static List<ActionType> toDtos(List<GmoActionType> gmoActionTypes, boolean lazy) {
		if (null == gmoActionTypes) {
			return null;
		}
		List<ActionType> actionTypes = new ArrayList<>();
		for (GmoActionType gmoActionType : gmoActionTypes) {
			actionTypes.add(toDto(gmoActionType, lazy));
		}
		return actionTypes;
	}
}
