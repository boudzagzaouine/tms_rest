package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ContactFunction;
import com.bagile.gmo.entities.TmsContactFunction;


import java.util.*;

public class ContactFunctionMapper {
	public ContactFunctionMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsContactFunctionId");
		map.put("code", "tmsContactFunctionCode");
		map.put("description", "tmsContactFunctionDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsContactFunction toEntity(ContactFunction contactFunction, boolean lazy) {
		if (null == contactFunction) {
			return null;
		}
		TmsContactFunction tmsContactFunction = new TmsContactFunction();
		tmsContactFunction.setTmsContactFunctionId(contactFunction.getId());
		tmsContactFunction.setTmsContactFunctionCode(contactFunction.getCode() != null ? contactFunction.getCode().toUpperCase() : null);
		tmsContactFunction.setTmsContactFunctionDescription(contactFunction.getDescription());

		if(!lazy){
			tmsContactFunction.setOwnOwner(OwnerMapper.toEntity(contactFunction.getOwner(),true));


		}
		return tmsContactFunction;
	}

	public static ContactFunction toDto(TmsContactFunction tmsContactFunction, boolean lazy) {
		if (null == tmsContactFunction) {
			return null;
		}
		ContactFunction contactFunction = new ContactFunction();
		contactFunction.setId(tmsContactFunction.getTmsContactFunctionId());
		contactFunction.setCode(tmsContactFunction.getTmsContactFunctionCode() != null ? tmsContactFunction.getTmsContactFunctionCode().toUpperCase() : null);
		contactFunction.setDescription(tmsContactFunction.getTmsContactFunctionDescription());

		if(!lazy){

			contactFunction.setOwner(OwnerMapper.toDto(tmsContactFunction.getOwnOwner(),true));

		}
		return contactFunction;

	}




	public static List<ContactFunction> toDtos(Iterable<? extends TmsContactFunction> tmsContactFunctions, boolean lazy) {
		if (null == tmsContactFunctions) {
			return null;
		}
		List<ContactFunction> contactFunctions = new ArrayList<>();

		for (TmsContactFunction tmsContactFunction : tmsContactFunctions) {
			contactFunctions.add(toDto(tmsContactFunction, lazy));
		}
		return contactFunctions;
	}

	public static Set<TmsContactFunction> toEntities(List<ContactFunction> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsContactFunction> tmsContactFunctions = new HashSet<>();
		for (ContactFunction contactFunction : list) {
			tmsContactFunctions.add(toEntity(contactFunction, lazy));
		}
		return tmsContactFunctions;
	}

	public static List<ContactFunction> toDtos(List<TmsContactFunction> tmsContactFunctions, boolean lazy) {
		if (null == tmsContactFunctions) {
			return null;
		}
		List<ContactFunction> contactFunctions = new ArrayList<>();
		for (TmsContactFunction tmsContactFunction : tmsContactFunctions) {
			contactFunctions.add(toDto(tmsContactFunction, lazy));
		}
		return contactFunctions;
	}
}
