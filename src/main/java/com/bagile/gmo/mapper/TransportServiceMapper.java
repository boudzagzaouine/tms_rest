package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TransportService;
import com.bagile.gmo.entities.TmsTransportService;

import java.util.*;

public class TransportServiceMapper {
	public TransportServiceMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsTransportServiceId");
		map.put("code", "tmsTransportServiceCode");
		map.put("transport", "trpTransport");
		map.put("product", "pdtProduct");
		map.put("turnType", "tmsTurnType");
		map.put("vehicleCategory", "gmoVehicleCategory");
		map.put("vehicleTray", "tmsVehicleTray");
		map.put("villeSource", "tmsVilleSource");
		map.put("villeDestination", "tmsVilleDestination");


	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsTransportService toEntity(TransportService transportService, boolean lazy) {
		if (null == transportService) {
			return null;
		}
		TmsTransportService tmsTransportService = new TmsTransportService();
		tmsTransportService.setTmsTransportServiceId(transportService.getId());

		tmsTransportService.setTmsTransportServiceSaleAmountHt(transportService.getSaleAmountHt());
		tmsTransportService.setTmsTransportServiceSaleAmountTtc(transportService.getSaleAmountTtc());
		tmsTransportService.setTmsTransportServiceSaleAmountTva(transportService.getSaleAmountTva());

		if(!lazy){
			tmsTransportService.setTrpTransport(TransportMapper.toEntity(transportService.getTransport(),true));
			tmsTransportService.setPdtProduct(ProductMapper.toEntity(transportService.getProduct(),true));
			tmsTransportService.setPrmSaleVat(VatMapper.toEntity(transportService.getSaleVat(),true));
			tmsTransportService.setOwnOwner(OwnerMapper.toEntity(transportService.getOwner(),true));




		}
		return tmsTransportService;
	}

	public static TransportService toDto(TmsTransportService tmsTransportService, boolean lazy) {
		if (null == tmsTransportService) {
			return null;
		}
		TransportService transportService = new TransportService();
		transportService.setId(tmsTransportService.getTmsTransportServiceId());

		transportService.setSaleAmountHt(tmsTransportService.getTmsTransportServiceSaleAmountHt());
		transportService.setSaleAmountTtc(tmsTransportService.getTmsTransportServiceSaleAmountTtc());
		transportService.setSaleAmountTva(tmsTransportService.getTmsTransportServiceSaleAmountTva());


		if(!lazy){
			transportService.setTransport(TransportMapper.toDto(tmsTransportService.getTrpTransport(),true));
			transportService.setProduct(ProductMapper.toDto(tmsTransportService.getPdtProduct(),true));
				transportService.setSaleVat(VatMapper.toDto(tmsTransportService.getPrmSaleVat(),true));
			transportService.setOwner(OwnerMapper.toDto(tmsTransportService.getOwnOwner(),true));

		}
		return transportService;

	}



	public static List<TransportService> toDtos(Iterable<? extends TmsTransportService> tmsTransportServices, boolean lazy) {
		if (null == tmsTransportServices) {
			return null;
		}
		List<TransportService> transportServices = new ArrayList<>();

		for (TmsTransportService tmsTransportService : tmsTransportServices) {
			transportServices.add(toDto(tmsTransportService, lazy));
		}
		return transportServices;
	}

	public static Set<TmsTransportService> toEntities(List<TransportService> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsTransportService> tmsTransportServices = new HashSet<>();
		for (TransportService transportService : list) {
			tmsTransportServices.add(toEntity(transportService, lazy));
		}
		return tmsTransportServices;
	}

	public static List<TransportService> toDtos(List<TmsTransportService> tmsTransportServices, boolean lazy) {
		if (null == tmsTransportServices) {
			return null;
		}
		List<TransportService> transportServices = new ArrayList<>();
		for (TmsTransportService tmsTransportService : tmsTransportServices) {
			transportServices.add(toDto(tmsTransportService, lazy));
		}
		return transportServices;
	}
}
