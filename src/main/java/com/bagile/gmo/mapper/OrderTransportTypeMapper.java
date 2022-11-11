package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransportType;
import com.bagile.gmo.entities.TmsOrderTransportType;

import java.util.*;

public class OrderTransportTypeMapper {
	public OrderTransportTypeMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsOrderTransportTypeId");
		map.put("code", "tmsOrderTransportTypeCode");
		map.put("description", "tmsOrderTransportTypeDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsOrderTransportType toEntity(OrderTransportType orderTransportType, boolean lazy) {
		if (null == orderTransportType) {
			return null;
		}
		TmsOrderTransportType tmsOrderTransportType = new TmsOrderTransportType();
		tmsOrderTransportType.setTmsOrderTransportTypeId(orderTransportType.getId());
		tmsOrderTransportType.setTmsOrderTransportTypeCode(orderTransportType.getCode() != null ? orderTransportType.getCode().toUpperCase() : null);
		tmsOrderTransportType.setTmsOrderTransportTypeDescription(orderTransportType.getDescription());

		if(!lazy){
			tmsOrderTransportType.setOwnOwner(OwnerMapper.toEntity(orderTransportType.getOwner(),true));


		}
		return tmsOrderTransportType;
	}

	public static OrderTransportType toDto(TmsOrderTransportType tmsOrderTransportType, boolean lazy) {
		if (null == tmsOrderTransportType) {
			return null;
		}
		OrderTransportType orderTransportType = new OrderTransportType();
		orderTransportType.setId(tmsOrderTransportType.getTmsOrderTransportTypeId());
		orderTransportType.setCode(tmsOrderTransportType.getTmsOrderTransportTypeCode() != null ? tmsOrderTransportType.getTmsOrderTransportTypeCode().toUpperCase() : null);
		orderTransportType.setDescription(tmsOrderTransportType.getTmsOrderTransportTypeDescription());

		if(!lazy){

			orderTransportType.setOwner(OwnerMapper.toDto(tmsOrderTransportType.getOwnOwner(),true));

		}
		return orderTransportType;

	}




	public static List<OrderTransportType> toDtos(Iterable<? extends TmsOrderTransportType> tmsOrderTransportTypes, boolean lazy) {
		if (null == tmsOrderTransportTypes) {
			return null;
		}
		List<OrderTransportType> orderTransportTypes = new ArrayList<>();

		for (TmsOrderTransportType tmsOrderTransportType : tmsOrderTransportTypes) {
			orderTransportTypes.add(toDto(tmsOrderTransportType, lazy));
		}
		return orderTransportTypes;
	}

	public static Set<TmsOrderTransportType> toEntities(List<OrderTransportType> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsOrderTransportType> tmsOrderTransportTypes = new HashSet<>();
		for (OrderTransportType orderTransportType : list) {
			tmsOrderTransportTypes.add(toEntity(orderTransportType, lazy));
		}
		return tmsOrderTransportTypes;
	}

	public static List<OrderTransportType> toDtos(List<TmsOrderTransportType> tmsOrderTransportTypes, boolean lazy) {
		if (null == tmsOrderTransportTypes) {
			return null;
		}
		List<OrderTransportType> orderTransportTypes = new ArrayList<>();
		for (TmsOrderTransportType tmsOrderTransportType : tmsOrderTransportTypes) {
			orderTransportTypes.add(toDto(tmsOrderTransportType, lazy));
		}
		return orderTransportTypes;
	}
}
