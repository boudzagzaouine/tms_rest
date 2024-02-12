package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TransportPlanLocation;
import com.bagile.gmo.entities.TmsTransportPlanLocation;
import java.util.*;

public class TransportPlanLocationMapper {
	public TransportPlanLocationMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsTransportPlanLocationId");
		map.put("vehicleId", "tmsTransportPlanLocationvehicleId");
		map.put("driverId", "tmsTransportPlanLocationdriverId");
		map.put("date", "tmsTransportPlanLocationdate");

	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsTransportPlanLocation toEntity(TransportPlanLocation transportPlanLocation, boolean lazy) {
		if (null == transportPlanLocation) {
			return null;
		}
		TmsTransportPlanLocation tmsTransportPlanLocation = new TmsTransportPlanLocation();
		tmsTransportPlanLocation.setTmsTransportPlanLocationId(transportPlanLocation.getId());

		tmsTransportPlanLocation.setTmsTransportPlanLocationlatitude(transportPlanLocation.getLatitude());
		tmsTransportPlanLocation.setTmsTransportPlanLocationlongitude(transportPlanLocation.getLongitude());
		tmsTransportPlanLocation.setTmsTransportPlanLocationdate(transportPlanLocation.getDate());
		tmsTransportPlanLocation.setTmsTransportPlanLocationType(transportPlanLocation.getType());
		tmsTransportPlanLocation.setAccountId(transportPlanLocation.getAccountId());
		tmsTransportPlanLocation.setAccountName(transportPlanLocation.getAccountName());

		if(!lazy){
			tmsTransportPlanLocation.setTmsTransportPlanLocationtransportPlanId (TransportPlanMapper.toEntity (transportPlanLocation.getTransportPlanId(), true));
			tmsTransportPlanLocation.setTmsTransportPlanLocationvehicleId (VehicleMapper.toEntity (transportPlanLocation.getVehicleId(), true));
			tmsTransportPlanLocation.setTmsTransportPlanLocationdriverId (DriverMapper.toEntity (transportPlanLocation.getDriverId(), true));

			tmsTransportPlanLocation.setTmsTransportPlanLocationOrderTransportId (OrderTransportMapper.toEntity (transportPlanLocation.getOrderTransportId(), true));
			tmsTransportPlanLocation.setTmsTransportPlanLocationOrderTransportInfoId (OrderTransportInfoMapper.toEntity (transportPlanLocation.getOrderTransportInfoId(), true));
			tmsTransportPlanLocation.setTmsTransportPlanLocationOrderTransportInfoLineID (OrderTransportInfoLineMapper.toEntity (transportPlanLocation.getOrderTransportInfoLineId(), true));


		}
		return tmsTransportPlanLocation;
	}

	public static TransportPlanLocation toDto(TmsTransportPlanLocation tmsTransportPlanLocation, boolean lazy) {
		if (null == tmsTransportPlanLocation) {
			return null;
		}
		TransportPlanLocation transportPlanLocation = new TransportPlanLocation();
		transportPlanLocation.setId(tmsTransportPlanLocation.getTmsTransportPlanLocationId());

		transportPlanLocation.setLatitude(tmsTransportPlanLocation.getTmsTransportPlanLocationlatitude());
		transportPlanLocation.setLongitude(tmsTransportPlanLocation.getTmsTransportPlanLocationlongitude());
		transportPlanLocation.setDate(tmsTransportPlanLocation.getTmsTransportPlanLocationdate());
		transportPlanLocation.setType(tmsTransportPlanLocation.getTmsTransportPlanLocationType());
		transportPlanLocation.setAccountId(tmsTransportPlanLocation.getAccountId());
		transportPlanLocation.setAccountName(tmsTransportPlanLocation.getAccountName());

		if(!lazy){
			transportPlanLocation.setTransportPlanId (TransportPlanMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationtransportPlanId(), false));
			transportPlanLocation.setVehicleId (VehicleMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationvehicleId(), false));
			transportPlanLocation.setDriverId (DriverMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationdriverId(), false));
			transportPlanLocation.setOrderTransportId (OrderTransportMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationOrderTransportId(), false));
			transportPlanLocation.setOrderTransportInfoLineId (OrderTransportInfoLineMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationOrderTransportInfoLineID(), false));
			transportPlanLocation.setOrderTransportInfoId (OrderTransportInfoMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationOrderTransportInfoId(), false));


		}
		return transportPlanLocation;

	}




	public static List<TransportPlanLocation> toDtos(Iterable<? extends TmsTransportPlanLocation> tmsTransportPlanLocations, boolean lazy) {
		if (null == tmsTransportPlanLocations) {
			return null;
		}
		List<TransportPlanLocation> transportPlanLocations = new ArrayList<>();

		for (TmsTransportPlanLocation tmsTransportPlanLocation : tmsTransportPlanLocations) {
			transportPlanLocations.add(toDto(tmsTransportPlanLocation, lazy));
		}
		return transportPlanLocations;
	}

	public static Set<TmsTransportPlanLocation> toEntities(List<TransportPlanLocation> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsTransportPlanLocation> tmsTransportPlanLocations = new HashSet<>();
		for (TransportPlanLocation transportPlanLocation : list) {
			tmsTransportPlanLocations.add(toEntity(transportPlanLocation, lazy));
		}
		return tmsTransportPlanLocations;
	}

	public static List<TransportPlanLocation> toDtos(List<TmsTransportPlanLocation> tmsTransportPlanLocations, boolean lazy) {
		if (null == tmsTransportPlanLocations) {
			return null;
		}
		List<TransportPlanLocation> transportPlanLocations = new ArrayList<>();
		for (TmsTransportPlanLocation tmsTransportPlanLocation : tmsTransportPlanLocations) {
			transportPlanLocations.add(toDto(tmsTransportPlanLocation, lazy));
		}
		return transportPlanLocations;
	}
}
