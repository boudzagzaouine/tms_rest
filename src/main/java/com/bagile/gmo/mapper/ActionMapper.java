package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.Action;
import com.bagile.gmo.entities.GmoAction;

public class ActionMapper {
	public ActionMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoActionId");
		map.put("code", "gmoActionCode");
		map.put("description", "gmoActionDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoAction toEntity(Action action, boolean lazy) {
		if (null == action) {
			return null;
		}
		GmoAction gmoAction = new GmoAction();
		gmoAction.setGmoActionId(action.getId());
		gmoAction.setGmoActionCode(action.getCode() != null ? action.getCode().toUpperCase() : null);
		gmoAction.setGmoActionDescription(action.getDescription());

		return gmoAction;
	}

	public static Action toDto(GmoAction gmoAction, boolean lazy) {
		if (null == gmoAction) {
			return null;
		}
		Action action = new Action();
		action.setId((int) gmoAction.getGmoActionId());
		action.setCode(gmoAction.getGmoActionCode() != null ? gmoAction.getGmoActionCode().toUpperCase() : null);
		action.setDescription(gmoAction.getGmoActionDescription());

		return action;

	}

	public static List<Action> toDtos(Iterable<? extends GmoAction> gmoActions, boolean lazy) {
		if (null == gmoActions) {
			return null;
		}
		List<Action> actions = new ArrayList<>();

		for (GmoAction gmoAction : gmoActions) {
			actions.add(toDto(gmoAction, lazy));
		}
		return actions;
	}

	public static Set<GmoAction> toEntities(List<Action> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoAction> gmoActions = new HashSet<>();
		for (Action action : list) {
			gmoActions.add(toEntity(action, lazy));
		}
		return gmoActions;
	}

	public static List<Action> toDtos(List<GmoAction> gmoActions, boolean lazy) {
		if (null == gmoActions) {
			return null;
		}
		List<Action> actions = new ArrayList<>();
		for (GmoAction gmoAction : gmoActions) {
			actions.add(toDto(gmoAction, lazy));
		}
		return actions;
	}
}
