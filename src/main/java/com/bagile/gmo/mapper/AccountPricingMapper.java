package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.AccountPricing;
import com.bagile.gmo.entities.TmsAccountPricing;

import java.util.*;

public class AccountPricingMapper {
	public AccountPricingMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsAccountPricingId");
		map.put("code", "tmsAccountPricingCode");
		map.put("account", "cmdAccount");
		map.put("catalogTransportType", "gmoCatalogTransportType");
		map.put("transport", "trpTransport");

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
		tmsAccountPricing.setTmsAccountPricingPrice(accountPricing.getPrice());

		if(!lazy){
			tmsAccountPricing.setOwnOwner(OwnerMapper.toEntity(accountPricing.getOwner(),true));
			tmsAccountPricing.setCmdAccount(AccountMapper.toEntity(accountPricing.getAccount(),false));
			tmsAccountPricing.setGmoCatalogTransportType(CatalogTransportTypeMapper.toEntity(accountPricing.getCatalogTransportType(),false));
			tmsAccountPricing.setTrpTransport(TransportMapper.toEntity(accountPricing.getTransport(),false));


		}
		return tmsAccountPricing;
	}

	public static AccountPricing toDto(TmsAccountPricing tmsAccountPricing, boolean lazy) {
		if (null == tmsAccountPricing) {
			return null;
		}
		AccountPricing accountPricing = new AccountPricing();
		accountPricing.setId(tmsAccountPricing.getTmsAccountPricingId());
		accountPricing.setPrice(tmsAccountPricing.getTmsAccountPricingPrice());

		if(!lazy){
			accountPricing.setAccount(AccountMapper.toDto(tmsAccountPricing.getCmdAccount(),false));
			accountPricing.setCatalogTransportType(CatalogTransportTypeMapper.toDto(tmsAccountPricing.getGmoCatalogTransportType(),false));
			accountPricing.setTransport(TransportMapper.toDto(tmsAccountPricing.getTrpTransport(),false));

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
