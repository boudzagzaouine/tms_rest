package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TransportAccountService;
import com.bagile.gmo.entities.TmsTransportAccountService;

import java.util.*;

public class TransportAccountServiceMapper {
	public TransportAccountServiceMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsTransportAccountServiceId");
		map.put("code", "tmsTransportAccountServiceCode");
		map.put("transport", "trpTransport");
		map.put("company", "cmdCompany");
		map.put("address", "adrAddress");

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

	public static TmsTransportAccountService toEntity(TransportAccountService transportAccountService, boolean lazy) {
		if (null == transportAccountService) {
			return null;
		}
		TmsTransportAccountService tmsTransportAccountService = new TmsTransportAccountService();
		tmsTransportAccountService.setTmsTransportAccountServiceId(transportAccountService.getId());

		tmsTransportAccountService.setTmsTransportAccountServiceSaleAmountHt(transportAccountService.getSaleAmountHt());
		tmsTransportAccountService.setTmsTransportAccountServiceSaleAmountTtc(transportAccountService.getSaleAmountTtc());
		tmsTransportAccountService.setTmsTransportAccountServiceSaleAmountTva(transportAccountService.getSaleAmountTva());

		if(!lazy){
			tmsTransportAccountService.setCmdCompany(CompanyMapper.toEntity(transportAccountService.getCompany(),true));
			tmsTransportAccountService.setAdrAddress(AddressMapper.toEntity(transportAccountService.getAddress(),true));

			tmsTransportAccountService.setTrpTransport(TransportMapper.toEntity(transportAccountService.getTransport(),true));
			tmsTransportAccountService.setPdtProduct(ProductMapper.toEntity(transportAccountService.getProduct(),true));
			tmsTransportAccountService.setPrmSaleVat(VatMapper.toEntity(transportAccountService.getSaleVat(),true));
			tmsTransportAccountService.setOwnOwner(OwnerMapper.toEntity(transportAccountService.getOwner(),true));




		}
		return tmsTransportAccountService;
	}

	public static TransportAccountService toDto(TmsTransportAccountService tmsTransportAccountService, boolean lazy) {
		if (null == tmsTransportAccountService) {
			return null;
		}
		TransportAccountService transportAccountService = new TransportAccountService();
		transportAccountService.setId(tmsTransportAccountService.getTmsTransportAccountServiceId());

		transportAccountService.setSaleAmountHt(tmsTransportAccountService.getTmsTransportAccountServiceSaleAmountHt());
		transportAccountService.setSaleAmountTtc(tmsTransportAccountService.getTmsTransportAccountServiceSaleAmountTtc());
		transportAccountService.setSaleAmountTva(tmsTransportAccountService.getTmsTransportAccountServiceSaleAmountTva());


		if(!lazy){
			transportAccountService.setCompany(CompanyMapper.toDto(tmsTransportAccountService.getCmdCompany(),true));
			transportAccountService.setAddress(AddressMapper.toDto(tmsTransportAccountService.getAdrAddress(),true));

			transportAccountService.setTransport(TransportMapper.toDto(tmsTransportAccountService.getTrpTransport(),true));
			transportAccountService.setProduct(ProductMapper.toDto(tmsTransportAccountService.getPdtProduct(),true));
				transportAccountService.setSaleVat(VatMapper.toDto(tmsTransportAccountService.getPrmSaleVat(),true));
			transportAccountService.setOwner(OwnerMapper.toDto(tmsTransportAccountService.getOwnOwner(),true));

		}
		return transportAccountService;

	}



	public static List<TransportAccountService> toDtos(Iterable<? extends TmsTransportAccountService> tmsTransportAccountServices, boolean lazy) {
		if (null == tmsTransportAccountServices) {
			return null;
		}
		List<TransportAccountService> transportAccountServices = new ArrayList<>();

		for (TmsTransportAccountService tmsTransportAccountService : tmsTransportAccountServices) {
			transportAccountServices.add(toDto(tmsTransportAccountService, lazy));
		}
		return transportAccountServices;
	}

	public static Set<TmsTransportAccountService> toEntities(List<TransportAccountService> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsTransportAccountService> tmsTransportAccountServices = new HashSet<>();
		for (TransportAccountService transportAccountService : list) {
			tmsTransportAccountServices.add(toEntity(transportAccountService, lazy));
		}
		return tmsTransportAccountServices;
	}

	public static List<TransportAccountService> toDtos(List<TmsTransportAccountService> tmsTransportAccountServices, boolean lazy) {
		if (null == tmsTransportAccountServices) {
			return null;
		}
		List<TransportAccountService> transportAccountServices = new ArrayList<>();
		for (TmsTransportAccountService tmsTransportAccountService : tmsTransportAccountServices) {
			transportAccountServices.add(toDto(tmsTransportAccountService, lazy));
		}
		return transportAccountServices;
	}
}
