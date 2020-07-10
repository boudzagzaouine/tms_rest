package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.ActionLine;
import com.bagile.gmo.entities.GmoActionLine;

public class ActionLineMapper {
	public ActionLineMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoMaintenanceLineId");
		map.put("product", "pdtProduct");
		map.put("action", "gmoAction");
		map.put("description", "gmoMaintenanceLineDescription");
		map.put("totalPriceHT", "gmoMaintenanceLineTotalPriceHT");
		map.put("totalPriceTTC", "gmoMaintenanceLineTotalPriceTTC");
		map.put("amountVat", "gmoAmountVat");
		map.put("quantity", "gmoQuantity");

	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoActionLine toEntity(ActionLine actionLine, boolean lazy) {
		if (null == actionLine) {
			return null;
		}
		
		GmoActionLine gmoActionLine = new GmoActionLine();
		gmoActionLine.setGmoActionLineId(actionLine.getId());
		gmoActionLine.setGmoActionLineDescription(actionLine.getDescription());
		gmoActionLine.setGmoActionLineTotalPriceHT(actionLine.getTotalPriceHT());
		gmoActionLine.setGmoActionLineTotalPriceTTC(actionLine.getTotalPriceTTC());
		gmoActionLine.setGmoAmountVat(actionLine.getAmountVat());
		gmoActionLine.setGmoActionLineQuantity(actionLine.getQuantity());

		if (!lazy) {
			gmoActionLine
			.setGmoAction(ActionMapper.toEntity(actionLine.getAction(), false));
				gmoActionLine
					.setPdtProduct(
							ProductMapper.toEntity(actionLine.getProduct(), false));



		}
		return gmoActionLine;
	}

	public static ActionLine toDto(GmoActionLine gmoActionLine, boolean lazy) {
		if (null == gmoActionLine) {
			return null;
		}
		ActionLine actionLine = new ActionLine();
		actionLine.setId((int) gmoActionLine.getGmoActionLineId());
		actionLine.setDescription(gmoActionLine.getGmoActionLineDescription());
		actionLine.setTotalPriceHT(gmoActionLine.getGmoActionLineTotalPriceHT());
		actionLine.setTotalPriceTTC(gmoActionLine.getGmoActionLineTotalPriceTTC());
		actionLine.setAmountVat(gmoActionLine.getGmoAmountVat());

		if (!lazy) {
			actionLine.setAction(ActionMapper.toDto(gmoActionLine.getGmoAction(), false));
			actionLine.setProduct(ProductMapper.toDto(gmoActionLine.getPdtProduct(), false));

		}
		return actionLine;
	}

	public static List<ActionLine> toDtos(Iterable<? extends GmoActionLine> gmoMaintenanceLines,
                                      boolean lazy) {
		if (null == gmoMaintenanceLines) {
			return null;
		}
		List<ActionLine> maintenanceLines = new ArrayList<>();

		for (GmoActionLine gmoActionLine : gmoMaintenanceLines) {
			maintenanceLines.add(toDto(gmoActionLine, lazy));
		}
		return maintenanceLines;
	}

	public static Set<GmoActionLine> toEntities(Iterable<? extends ActionLine> maintenanceLines,
											boolean lazy) {
		if (null == maintenanceLines) {
			return null;
		}
		Set<GmoActionLine> gmoMaintenanceLines = new HashSet<>();
		for (ActionLine actionLine : maintenanceLines) {
			gmoMaintenanceLines.add(toEntity(actionLine, lazy));
		}
		return gmoMaintenanceLines;
	}
}
