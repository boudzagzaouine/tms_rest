package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.AccountPricing;
import com.bagile.gmo.dto.LoadingType;
import com.bagile.gmo.entities.TmsAccountPricing;
import com.bagile.gmo.services.PaysService;

import java.util.*;

public class AccountPricingMapper {
	public AccountPricingMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsAccountPricingId");
		map.put("code", "tmsAccountPricingCode");
		map.put("company", "cmdCompany");
		map.put("loadingType", "tmsLoadingType");
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

	public static TmsAccountPricing toEntity(AccountPricing accountPricing, boolean lazy) {
		if (null == accountPricing) {
			return null;
		}
		TmsAccountPricing tmsAccountPricing = new TmsAccountPricing();
		tmsAccountPricing.setTmsAccountPricingId(accountPricing.getId());

		tmsAccountPricing.setTmsAccountPricingSaleAmountHt(accountPricing.getSaleAmountHt());
		tmsAccountPricing.setTmsAccountPricingSaleAmountTtc(accountPricing.getSaleAmountTtc());
		tmsAccountPricing.setTmsAccountPricingSaleAmountTva(accountPricing.getSaleAmountTva());

		if(!lazy){
			tmsAccountPricing.setCmdCompany(CompanyMapper.toEntity(accountPricing.getCompany(),true));
			tmsAccountPricing.setTmsTurnType(TurnTypeMapper.toEntity(accountPricing.getTurnType(),true));
			tmsAccountPricing.setPrmPaysSource(PaysMapper.toEntity(accountPricing.getPaysSource(),true));
			tmsAccountPricing.setTmsVilleSource(VilleMapper.toEntity(accountPricing.getVilleSource(),true));
			tmsAccountPricing.setPrmPaysDestination(PaysMapper.toEntity(accountPricing.getPaysDestination(),true));
			tmsAccountPricing.setTmsVilleDestination(VilleMapper.toEntity(accountPricing.getVilleDestination(),true));
			tmsAccountPricing.setGmoVehicleCategory(VehicleCategoryMapper.toEntity(accountPricing.getVehicleCategory(),true));
			tmsAccountPricing.setTmsVehicleTray(VehicleTrayMapper.toEntity(accountPricing.getVehicleTray(),true));
			tmsAccountPricing.setTmsLoadingType(LoadingTypeMapper.toEntity(accountPricing.getLoadingType(),true));
			tmsAccountPricing.setPrmSaleVat(VatMapper.toEntity(accountPricing.getSaleVat(),true));


			tmsAccountPricing.setOwnOwner(OwnerMapper.toEntity(accountPricing.getOwner(),true));




		}
		return tmsAccountPricing;
	}

	public static AccountPricing toDto(TmsAccountPricing tmsAccountPricing, boolean lazy) {
		if (null == tmsAccountPricing) {
			return null;
		}
		AccountPricing accountPricing = new AccountPricing();
		accountPricing.setId(tmsAccountPricing.getTmsAccountPricingId());

		accountPricing.setSaleAmountHt(tmsAccountPricing.getTmsAccountPricingSaleAmountHt());
		accountPricing.setSaleAmountTtc(tmsAccountPricing.getTmsAccountPricingSaleAmountTtc());
		accountPricing.setSaleAmountTva(tmsAccountPricing.getTmsAccountPricingSaleAmountTva());


		if(!lazy){
			accountPricing.setCompany(CompanyMapper.toDto(tmsAccountPricing.getCmdCompany(),true));
			accountPricing.setTurnType(TurnTypeMapper.toDto(tmsAccountPricing.getTmsTurnType(),true));
			accountPricing.setPaysSource(PaysMapper.toDto(tmsAccountPricing.getPrmPaysSource(),true));
			accountPricing.setVilleSource(VilleMapper.toDto(tmsAccountPricing.getTmsVilleSource(),true));
			accountPricing.setPaysDestination(PaysMapper.toDto(tmsAccountPricing.getPrmPaysDestination(),true));
			accountPricing.setVilleDestination(VilleMapper.toDto(tmsAccountPricing.getTmsVilleDestination(),true));
			accountPricing.setVehicleCategory(VehicleCategoryMapper.toDto(tmsAccountPricing.getGmoVehicleCategory(),true));
			accountPricing.setVehicleTray(VehicleTrayMapper.toDto(tmsAccountPricing.getTmsVehicleTray(),true));
			accountPricing.setLoadingType(LoadingTypeMapper.toDto(tmsAccountPricing.getTmsLoadingType(),true));
			accountPricing.setSaleVat(VatMapper.toDto(tmsAccountPricing.getPrmSaleVat(),true));


			accountPricing.setOwner(OwnerMapper.toDto(tmsAccountPricing.getOwnOwner(),true));

		}
		return accountPricing;

	}



	public static List<AccountPricing> toDtos(Iterable<? extends TmsAccountPricing> tmsAccountPricings, boolean lazy) {
		if (null == tmsAccountPricings) {
			return null;
		}
		List<AccountPricing> accountPricings = new ArrayList<>();

		for (TmsAccountPricing tmsAccountPricing : tmsAccountPricings) {
			accountPricings.add(toDto(tmsAccountPricing, lazy));
		}
		return accountPricings;
	}

	public static Set<TmsAccountPricing> toEntities(List<AccountPricing> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsAccountPricing> tmsAccountPricings = new HashSet<>();
		for (AccountPricing accountPricing : list) {
			tmsAccountPricings.add(toEntity(accountPricing, lazy));
		}
		return tmsAccountPricings;
	}

	public static List<AccountPricing> toDtos(List<TmsAccountPricing> tmsAccountPricings, boolean lazy) {
		if (null == tmsAccountPricings) {
			return null;
		}
		List<AccountPricing> accountPricings = new ArrayList<>();
		for (TmsAccountPricing tmsAccountPricing : tmsAccountPricings) {
			accountPricings.add(toDto(tmsAccountPricing, lazy));
		}
		return accountPricings;
	}
}
