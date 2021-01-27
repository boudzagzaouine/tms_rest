package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Month;
import com.bagile.gmo.entities.GmoMonth;

import java.util.*;

public class MonthMapper {
	/*public MonthMapper() {
	}*/

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoMonthId");
		map.put("code", "gmoMonthCode");
		map.put("description", "gmoMaintenanceState");
	


	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoMonth toEntity(Month month, boolean lazy) {
		if (null == month) {
			return null;
		}
		GmoMonth gmoMonth = new GmoMonth();
		gmoMonth.setGmoMonthId(month.getId());
		gmoMonth.setGmoMonthCode(month.getCode());
		gmoMonth.setGmoMonthDescription(month.getDescription());
		gmoMonth.setGmoValue(month.getValue());


		return gmoMonth;
	}

	public static Month toDto(GmoMonth gmoMonth, boolean lazy) {
		if (null == gmoMonth) {
			return null;
		}
		Month month = new Month();
		month.setId(gmoMonth.getGmoMonthId());
		month.setCode(gmoMonth.getGmoMonthCode());
		month.setDescription(gmoMonth.getGmoMonthDescription());
		month.setValue(gmoMonth.getGmoValue());

		return month;

	}

	public static List<Month> toDtos(Iterable<? extends GmoMonth> gmoMonths, boolean lazy) {
		if (null == gmoMonths) {
			return null;
		}
		List<Month> months = new ArrayList<>();

		for (GmoMonth gmoMonth : gmoMonths) {
			months.add(toDto(gmoMonth, lazy));
		}
		return months;
	}

	public static Set<GmoMonth> toEntities(List<Month> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoMonth> gmoMonths = new HashSet<>();
		for (Month month : list) {
			gmoMonths.add(toEntity(month, lazy));
		}
		return gmoMonths;
	}

	public static List<Month> toDtos(List<GmoMonth> gmoMonths, boolean lazy) {
		if (null == gmoMonths) {
			return null;
		}
		List<Month> months = new ArrayList<>();
		for (GmoMonth gmoMonth : gmoMonths) {
			months.add(toDto(gmoMonth, lazy));
		}
		return months;
	}
}
