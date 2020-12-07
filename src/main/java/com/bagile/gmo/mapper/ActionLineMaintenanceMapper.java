package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ActionLineMaintenance;
import com.bagile.gmo.entities.GmoActionLineMaintenance;

import java.util.*;

public class ActionLineMaintenanceMapper {
	public ActionLineMaintenanceMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoMaintenanceLineId");
		map.put("product", "pdtProduct");
		map.put("description", "gmoMaintenanceLineDescription");
		map.put("totalPriceHT", "gmoMaintenanceLineTotalPriceHT");
		map.put("totalPriceTTC", "gmoMaintenanceLineTotalPriceTTC");
		map.put("amountVat", "gmoAmountVat");
		map.put("quantity", "gmoActionLineQuantity");
		map.put("unitPrice", "gmoActionLineunitPrice");
		map.put("maintenanceState", "gmoMaintenanceState");
		map.put("maintenance", "gmoMaintenance");


	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoActionLineMaintenance toEntity(ActionLineMaintenance actionLineMaintenance, boolean lazy) {
		if (null == actionLineMaintenance) {
			return null;
		}
		
		GmoActionLineMaintenance gmoActionLineMaintenance = new GmoActionLineMaintenance();
		gmoActionLineMaintenance.setGmoActionLineId(actionLineMaintenance.getId());
		gmoActionLineMaintenance.setGmoActionLineDescription(actionLineMaintenance.getDescription());
		gmoActionLineMaintenance.setGmoActionLineTotalPriceHT(actionLineMaintenance.getTotalPriceHT());
		gmoActionLineMaintenance.setGmoActionLineTotalPriceTTC(actionLineMaintenance.getTotalPriceTTC());
		gmoActionLineMaintenance.setGmoAmountVat(actionLineMaintenance.getAmountVat());
		gmoActionLineMaintenance.setGmoActionLineQuantity(actionLineMaintenance.getQuantity());
		gmoActionLineMaintenance.setGmoActionLineunitPrice(actionLineMaintenance.getUnitPrice());

		if (!lazy) {
					gmoActionLineMaintenance
					.setGmoMaintenance(MaintenanceMapper.toEntity(actionLineMaintenance.getMaintenance(), true));

			gmoActionLineMaintenance
					.setPdtProduct(ProductMapper.toEntity(actionLineMaintenance.getProduct(), true));

			gmoActionLineMaintenance
					.setOwnOwner(OwnerMapper.toEntity(actionLineMaintenance.getOwner(), true));

		}
		return gmoActionLineMaintenance;
	}

	public static ActionLineMaintenance toDto(GmoActionLineMaintenance gmoActionLineMaintenance, boolean lazy) {
		if (null == gmoActionLineMaintenance) {
			return null;
		}
		ActionLineMaintenance actionLineMaintenance = new ActionLineMaintenance();
		actionLineMaintenance.setId((int) gmoActionLineMaintenance.getGmoActionLineId());
		actionLineMaintenance.setDescription(gmoActionLineMaintenance.getGmoActionLineDescription());
		actionLineMaintenance.setTotalPriceHT(gmoActionLineMaintenance.getGmoActionLineTotalPriceHT());
		actionLineMaintenance.setTotalPriceTTC(gmoActionLineMaintenance.getGmoActionLineTotalPriceTTC());
		actionLineMaintenance.setAmountVat(gmoActionLineMaintenance.getGmoAmountVat());
		actionLineMaintenance.setQuantity(gmoActionLineMaintenance.getGmoActionLineQuantity());
		actionLineMaintenance.setUnitPrice(gmoActionLineMaintenance.getGmoActionLineunitPrice());

		if (!lazy) {
			actionLineMaintenance.setMaintenance(MaintenanceMapper.toDto(gmoActionLineMaintenance.getGmoMaintenance(), true));
			actionLineMaintenance.setProduct(ProductMapper.toDto(gmoActionLineMaintenance.getPdtProduct(), false));
			actionLineMaintenance.setOwner(OwnerMapper.toDto(gmoActionLineMaintenance.getOwnOwner(), false));

		}
		return actionLineMaintenance;
	}

	public static List<ActionLineMaintenance> toDtos(Iterable<? extends GmoActionLineMaintenance> gmoMaintenanceLines,
                                      boolean lazy) {
		if (null == gmoMaintenanceLines) {
			return null;
		}
		List<ActionLineMaintenance> maintenanceLines = new ArrayList<>();

		for (GmoActionLineMaintenance gmoActionLineMaintenance : gmoMaintenanceLines) {
			maintenanceLines.add(toDto(gmoActionLineMaintenance, lazy));
		}
		return maintenanceLines;
	}

	public static Set<GmoActionLineMaintenance> toEntities(Iterable<? extends ActionLineMaintenance> maintenanceLines,
											boolean lazy) {
		if (null == maintenanceLines) {
			return null;
		}
		Set<GmoActionLineMaintenance> gmoMaintenanceLines = new HashSet<>();
		for (ActionLineMaintenance actionLineMaintenance : maintenanceLines) {
			gmoMaintenanceLines.add(toEntity(actionLineMaintenance, lazy));
		}
		return gmoMaintenanceLines;
	}
}
