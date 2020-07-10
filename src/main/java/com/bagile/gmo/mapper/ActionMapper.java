package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Action;
import com.bagile.gmo.dto.MaintenanceState;
import com.bagile.gmo.entities.GmoAction;
import com.bagile.gmo.entities.GmoMaintenancePlan;

import java.util.*;

public class ActionMapper {
	public ActionMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoActionId");
		map.put("action", "gmoActionType");
		map.put("maintenanceState", "gmoMaintenanceState");
		map.put("maintenancePlan", "gmoMaintenancePlan");
		map.put("actionLines", "gmoActionLines");


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
		if (!lazy) {
			gmoAction.setGmoMaintenancePlan(MaintenancePlanMapper.toEntity(action.getMaintenancePlan(), true));
			gmoAction.setGmoMaintenanceState(MaintenanceStateMapper.toEntity(action.getMaintenanceState(),true));
			gmoAction.setGmoActionLines(ActionLineMapper.toEntities(action.getActionLines(),true));
			gmoAction.setGmoActionType(ActionTypeMapper.toEntity(action.getActionType(),false));
        oneToMany(gmoAction);
		}

		return gmoAction;
	}
	private static void oneToMany(GmoAction action) {
		action.getGmoActionLines().forEach(
				e -> {
					e.setCreationDate(new Date());
					e.setGmoAction(action);
				}
		);
	}
	public static Action toDto(GmoAction gmoAction, boolean lazy) {
		if (null == gmoAction) {
			return null;
		}
		Action action = new Action();
		action.setId((int) gmoAction.getGmoActionId());
		if (!lazy) {
			action.setMaintenancePlan(MaintenancePlanMapper.toDto(gmoAction.getGmoMaintenancePlan(), false));
			action.setMaintenanceState(MaintenanceStateMapper.toDto(gmoAction.getGmoMaintenanceState(), false));
			action.setActionLines(ActionLineMapper.toDtos(gmoAction.getGmoActionLines(),false));
			action.setActionType (ActionTypeMapper.toDto (gmoAction.getGmoActionType(), false));

		}
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
