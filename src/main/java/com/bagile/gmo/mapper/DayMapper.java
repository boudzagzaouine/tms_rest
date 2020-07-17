package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Day;
import com.bagile.gmo.entities.GmoDay;

import java.util.*;

public class DayMapper {
	public DayMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoDayId");
		map.put("code", "gmoDayType");
		map.put("description", "gmoMaintenanceState");
	


	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoDay toEntity(Day day, boolean lazy) {
		if (null == day) {
			return null;
		}
		GmoDay gmoDay = new GmoDay();
		gmoDay.setGmoDayId(day.getId());
		gmoDay.setGmoDayCode(day.getCode());
		gmoDay.setGmoDayDescription(day.getDescription());
		gmoDay.setGmoValue(day.getValue());


		return gmoDay;
	}

	public static Day toDto(GmoDay gmoDay, boolean lazy) {
		if (null == gmoDay) {
			return null;
		}
		Day day = new Day();
		day.setId((int) gmoDay.getGmoDayId());
		day.setCode(gmoDay.getGmoDayCode());
		day.setDescription(gmoDay.getGmoDayDescription());
		day.setValue(gmoDay.getGmoValue());

		return day;

	}

	public static List<Day> toDtos(Iterable<? extends GmoDay> gmoDays, boolean lazy) {
		if (null == gmoDays) {
			return null;
		}
		List<Day> days = new ArrayList<>();

		for (GmoDay gmoDay : gmoDays) {
			days.add(toDto(gmoDay, lazy));
		}
		return days;
	}

	public static Set<GmoDay> toEntities(List<Day> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoDay> gmoDays = new HashSet<>();
		for (Day day : list) {
			gmoDays.add(toEntity(day, lazy));
		}
		return gmoDays;
	}

	public static List<Day> toDtos(List<GmoDay> gmoDays, boolean lazy) {
		if (null == gmoDays) {
			return null;
		}
		List<Day> days = new ArrayList<>();
		for (GmoDay gmoDay : gmoDays) {
			days.add(toDto(gmoDay, lazy));
		}
		return days;
	}
}
