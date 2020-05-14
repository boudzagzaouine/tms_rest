package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.MaintenanceLine;
import com.bagile.gmo.entities.GmoMaintenanceLine;

public class MaintenanceLineMapper {
	public MaintenanceLineMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoMaintenanceLineId");
		map.put("maintenanceLineRef", "gmoMaintenanceLineRef");
		map.put("maintenanceLineProducts", "gmoMaintenanceLineProducts");
		map.put("description", "gmoMaintenanceLineDescription");
		map.put("totalPriceHT", "gmoMaintenanceLineTotalPriceHT");
		map.put("totalPriceTTC", "gmoMaintenanceLineTotalPriceTTC");
		map.put("updateDate", "gmoAmountVat");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoMaintenanceLine toEntity(MaintenanceLine maintenanceLine, boolean lazy) {
		if (null == maintenanceLine) {
			return null;
		}
		GmoMaintenanceLine gmoMaintenanceLine = new GmoMaintenanceLine();
		gmoMaintenanceLine.setGmoMaintenanceLineId(maintenanceLine.getId());
		gmoMaintenanceLine.setGmoMaintenanceLineDescription(maintenanceLine.getDescription());
		gmoMaintenanceLine.setGmoAmountVat(maintenanceLine.getAmountVat());
		if (!lazy) {
			gmoMaintenanceLine
			.setGmoMaintenanceLineRef(MaintenanceLineRefMapper.toEntity(maintenanceLine.getMaintenanceLineRef(), false));
			gmoMaintenanceLine
					.setGmoMaintenanceLineProducts(MaintenanceProductMapper.toEntities(maintenanceLine.getMaintenanceProducts(), false));
		}
		return gmoMaintenanceLine;
	}

	public static MaintenanceLine toDto(GmoMaintenanceLine gmoMaintenanceLine, boolean lazy) {
		if (null == gmoMaintenanceLine) {
			return null;
		}
		MaintenanceLine maintenanceLine = new MaintenanceLine();
		maintenanceLine.setId((int) gmoMaintenanceLine.getGmoMaintenanceLineId());
		maintenanceLine.setDescription(gmoMaintenanceLine.getGmoMaintenanceLineDescription());
		maintenanceLine.setTotalPriceHT(gmoMaintenanceLine.getGmoMaintenanceLineTotalPriceHT());
		maintenanceLine.setTotalPriceTTC(gmoMaintenanceLine.getGmoMaintenanceLineTotalPriceTTC());
		maintenanceLine.setAmountVat(gmoMaintenanceLine.getGmoAmountVat());

		if (!lazy) {
			maintenanceLine.setMaintenanceProducts(MaintenanceProductMapper.toDtos(gmoMaintenanceLine.getGmoMaintenanceLineProducts(), lazy));
			maintenanceLine.setMaintenanceLineRef(MaintenanceLineRefMapper.toDto(gmoMaintenanceLine.getGmoMaintenanceLineRef(), lazy));
		}
		return maintenanceLine;
	}

	public static List<MaintenanceLine> toDtos(Iterable<? extends GmoMaintenanceLine> gmoMaintenanceLines,
			boolean lazy) {
		if (null == gmoMaintenanceLines) {
			return null;
		}
		List<MaintenanceLine> maintenanceLines = new ArrayList<>();

		for (GmoMaintenanceLine gmoMaintenanceLine : gmoMaintenanceLines) {
			maintenanceLines.add(toDto(gmoMaintenanceLine, lazy));
		}
		return maintenanceLines;
	}

	public static Set<GmoMaintenanceLine> toEntities(Iterable<? extends MaintenanceLine> maintenanceLines,
			boolean lazy) {
		if (null == maintenanceLines) {
			return null;
		}
		Set<GmoMaintenanceLine> gmoMaintenanceLines = new HashSet<>();
		for (MaintenanceLine maintenanceLine : maintenanceLines) {
			gmoMaintenanceLines.add(toEntity(maintenanceLine, lazy));
		}
		return gmoMaintenanceLines;
	}
}
