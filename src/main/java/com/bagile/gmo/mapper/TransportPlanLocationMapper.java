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
		tmsTransportPlanLocation.setTmsTransportPlanLocationtransportPlanId(transportPlanLocation.getTransportPlanId());
		tmsTransportPlanLocation.setTmsTransportPlanLocationvehicleId(transportPlanLocation.getVehicleId());
		tmsTransportPlanLocation.setTmsTransportPlanLocationdriverId(transportPlanLocation.getDriverId());
		tmsTransportPlanLocation.setTmsTransportPlanLocationlatitude(transportPlanLocation.getLatitude());
		tmsTransportPlanLocation.setTmsTransportPlanLocationlongitude(transportPlanLocation.getLongitude());
		tmsTransportPlanLocation.setTmsTransportPlanLocationdate(transportPlanLocation.getDate());
		tmsTransportPlanLocation.setTmsTransportPlanLocationType(transportPlanLocation.getType());

		if(!lazy){


		}
		return tmsTransportPlanLocation;
	}

	public static TransportPlanLocation toDto(TmsTransportPlanLocation tmsTransportPlanLocation, boolean lazy) {
		if (null == tmsTransportPlanLocation) {
			return null;
		}
		TransportPlanLocation transportPlanLocation = new TransportPlanLocation();
		transportPlanLocation.setId(tmsTransportPlanLocation.getTmsTransportPlanLocationId());
		transportPlanLocation.setTransportPlanId(tmsTransportPlanLocation.getTmsTransportPlanLocationtransportPlanId());
		transportPlanLocation.setVehicleId(tmsTransportPlanLocation.getTmsTransportPlanLocationvehicleId());
		transportPlanLocation.setDriverId(tmsTransportPlanLocation.getTmsTransportPlanLocationdriverId());
		transportPlanLocation.setLatitude(tmsTransportPlanLocation.getTmsTransportPlanLocationlatitude());
		transportPlanLocation.setLongitude(tmsTransportPlanLocation.getTmsTransportPlanLocationlongitude());
		transportPlanLocation.setDate(tmsTransportPlanLocation.getTmsTransportPlanLocationdate());
		transportPlanLocation.setType(tmsTransportPlanLocation.getTmsTransportPlanLocationType());

		if(!lazy){


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
