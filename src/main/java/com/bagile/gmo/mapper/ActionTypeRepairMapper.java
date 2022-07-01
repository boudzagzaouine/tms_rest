package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ActionTypeRepair;
import com.bagile.gmo.entities.GmoActionTypeRepair;

import java.util.*;

public class ActionTypeRepairMapper {
	public ActionTypeRepairMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoActionTypeRepairRepairId");
		map.put("repairType", "gmoActionTypeRepairRepairRepairType");
		map.put("city", "gmoActionTypeRepairRepairCity");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoActionTypeRepair toEntity(ActionTypeRepair actionTypeRepair, boolean lazy) {
		if (null == actionTypeRepair) {
			return null;
		}
		GmoActionTypeRepair gmoActionTypeRepair = new GmoActionTypeRepair();
		gmoActionTypeRepair.setGmoActionTypeRepairId(actionTypeRepair.getId());
		gmoActionTypeRepair.setGmoActionTypeRepaireRepairType(actionTypeRepair.getRepairType() );
		gmoActionTypeRepair.setGmoActionTypeRepaireWorkshop(actionTypeRepair.getWorkshop());
		gmoActionTypeRepair.setGmoActionTypeRepaireCity(actionTypeRepair.getCity());
		gmoActionTypeRepair.setGmoActionTypeRepairePrice(actionTypeRepair.getPrice());
		gmoActionTypeRepair.setGmoActionTypeRepaireDuration(actionTypeRepair.getDuration());


		if(!lazy){
			gmoActionTypeRepair.setRcpSupplier(SupplierMapper.toEntity(actionTypeRepair.getSupplier(),true));
			gmoActionTypeRepair.setGmoActionType(ActionTypeMapper.toEntity(actionTypeRepair.getActionType(),true));
			gmoActionTypeRepair.setOwnOwner(OwnerMapper.toEntity(actionTypeRepair.getOwner(),true));
		}
		return gmoActionTypeRepair;
	}

	public static ActionTypeRepair toDto(GmoActionTypeRepair gmoActionTypeRepair, boolean lazy) {
		if (null == gmoActionTypeRepair) {
			return null;
		}
		ActionTypeRepair actionTypeRepair = new ActionTypeRepair();
		actionTypeRepair.setId(gmoActionTypeRepair.getGmoActionTypeRepairId());
		actionTypeRepair.setRepairType(gmoActionTypeRepair.getGmoActionTypeRepaireRepairType() );
		actionTypeRepair.setWorkshop(gmoActionTypeRepair.getGmoActionTypeRepaireWorkshop());
		actionTypeRepair.setCity(gmoActionTypeRepair.getGmoActionTypeRepaireCity());
		actionTypeRepair.setPrice(gmoActionTypeRepair.getGmoActionTypeRepairePrice());
		actionTypeRepair.setDuration(gmoActionTypeRepair.getGmoActionTypeRepaireDuration());

		if(!lazy){
			actionTypeRepair.setSupplier(SupplierMapper.toDto(gmoActionTypeRepair.getRcpSupplier(),true));
			actionTypeRepair.setActionType(ActionTypeMapper.toDto(gmoActionTypeRepair.getGmoActionType(),true));

			actionTypeRepair.setOwner(OwnerMapper.toDto(gmoActionTypeRepair.getOwnOwner(),true));

		}
		return actionTypeRepair;

	}

	public static List<ActionTypeRepair> toDtos(Iterable<? extends GmoActionTypeRepair> gmoActionTypeRepairs, boolean lazy) {
		if (null == gmoActionTypeRepairs) {
			return null;
		}
		List<ActionTypeRepair> actionTypeRepairs = new ArrayList<>();

		for (GmoActionTypeRepair gmoActionTypeRepair : gmoActionTypeRepairs) {
			actionTypeRepairs.add(toDto(gmoActionTypeRepair, lazy));
		}
		return actionTypeRepairs;
	}

	public static Set<GmoActionTypeRepair> toEntities(List<ActionTypeRepair> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoActionTypeRepair> gmoActionTypeRepairs = new HashSet<>();
		for (ActionTypeRepair actionTypeRepair : list) {
			gmoActionTypeRepairs.add(toEntity(actionTypeRepair, lazy));
		}
		return gmoActionTypeRepairs;
	}

	public static List<ActionTypeRepair> toDtos(List<GmoActionTypeRepair> gmoActionTypeRepairs, boolean lazy) {
		if (null == gmoActionTypeRepairs) {
			return null;
		}
		List<ActionTypeRepair> actionTypeRepairs = new ArrayList<>();
		for (GmoActionTypeRepair gmoActionTypeRepair : gmoActionTypeRepairs) {
			actionTypeRepairs.add(toDto(gmoActionTypeRepair, lazy));
		}
		return actionTypeRepairs;
	}
}
