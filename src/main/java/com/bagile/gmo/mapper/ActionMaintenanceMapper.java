package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ActionMaintenance;
import com.bagile.gmo.entities.GmoActionMaintenance;

import java.util.*;

public class ActionMaintenanceMapper {
	public ActionMaintenanceMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoActionMaintenanceId");
		map.put("actionType", "gmoActionType");
		map.put("maintenanceState", "gmoMaintenanceState");
		map.put("maintenance", "gmoMaintenance");
		map.put("actionLines", "gmoActionLines");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoActionMaintenance toEntity(ActionMaintenance actionMaintenance, boolean lazy) {
		if (null == actionMaintenance) {
			return null;
		}
		GmoActionMaintenance gmoActionMaintenance = new GmoActionMaintenance();
		gmoActionMaintenance.setGmoActionMaintenanceId(actionMaintenance.getId());
		if (!lazy) {
			gmoActionMaintenance.setGmoMaintenance(MaintenanceMapper.toEntity(actionMaintenance.getMaintenance(), true));
			gmoActionMaintenance.setGmoMaintenanceState(MaintenanceStateMapper.toEntity(actionMaintenance.getMaintenanceState(),true));
			gmoActionMaintenance.setGmoActionLineMaintenances(ActionLineMaintenanceMapper.toEntities(actionMaintenance.getActionLineMaintenances(),false));
			gmoActionMaintenance.setGmoActionType(ActionTypeMapper.toEntity(actionMaintenance.getActionType(),false));
            oneToMany(gmoActionMaintenance);
		}

		return gmoActionMaintenance;
	}
	private static void oneToMany(GmoActionMaintenance actionMaintenance) {
		actionMaintenance.getGmoActionLineMaintenances().forEach(
				e -> {
					//if(0>=actionMaintenance.getGmoActionMaintenanceId()) {
						e.setGmoActionLineId(0);
						e.setCreationDate(new Date());
						e.setGmoActionMaintenance(actionMaintenance);
					//}
				}
		);
	}
	public static ActionMaintenance toDto(GmoActionMaintenance gmoActionMaintenance, boolean lazy) {
		if (null == gmoActionMaintenance) {
			return null;
		}
		ActionMaintenance actionMaintenance = new ActionMaintenance();
		actionMaintenance.setId((int) gmoActionMaintenance.getGmoActionMaintenanceId());
		if (!lazy) {
			actionMaintenance.setMaintenance(MaintenanceMapper.toDto(gmoActionMaintenance.getGmoMaintenance(), true));
			actionMaintenance.setMaintenanceState(MaintenanceStateMapper.toDto(gmoActionMaintenance.getGmoMaintenanceState(), true));
			actionMaintenance.setActionLineMaintenances(ActionLineMaintenanceMapper.toDtos(gmoActionMaintenance.getGmoActionLineMaintenances(),false));
			actionMaintenance.setActionType(ActionTypeMapper.toDto (gmoActionMaintenance.getGmoActionType(), true));

		}
		return actionMaintenance;

	}

	public static List<ActionMaintenance> toDtos(Iterable<? extends GmoActionMaintenance> gmoActionMaintenances, boolean lazy) {
		if (null == gmoActionMaintenances) {
			return null;
		}
		List<ActionMaintenance> actionMaintenances = new ArrayList<>();

		for (GmoActionMaintenance gmoActionMaintenance : gmoActionMaintenances) {
			actionMaintenances.add(toDto(gmoActionMaintenance, lazy));
		}
		return actionMaintenances;
	}

	public static Set<GmoActionMaintenance> toEntities(List<ActionMaintenance> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoActionMaintenance> gmoActionMaintenances = new HashSet<>();
		for (ActionMaintenance actionMaintenance : list) {
			gmoActionMaintenances.add(toEntity(actionMaintenance, lazy));
		}
		return gmoActionMaintenances;
	}

	public static List<ActionMaintenance> toDtos(List<GmoActionMaintenance> gmoActionMaintenances, boolean lazy) {
		if (null == gmoActionMaintenances) {
			return null;
		}
		List<ActionMaintenance> actionMaintenances = new ArrayList<>();
		for (GmoActionMaintenance gmoActionMaintenance : gmoActionMaintenances) {
			actionMaintenances.add(toDto(gmoActionMaintenance, lazy));
		}
		return actionMaintenances;
	}
}
