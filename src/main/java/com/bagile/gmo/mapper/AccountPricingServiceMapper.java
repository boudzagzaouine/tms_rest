package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.AccountPricingService;
import com.bagile.gmo.entities.TmsAccountPricingService;

import java.util.*;

public class AccountPricingServiceMapper {
	public AccountPricingServiceMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsAccountPricingServiceId");
		map.put("company", "cmdCompany");
		map.put("account", "cmdAccount");

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

	public static TmsAccountPricingService toEntity(AccountPricingService accountService, boolean lazy) {
		if (null == accountService) {
			return null;
		}
		TmsAccountPricingService tmsAccountService = new TmsAccountPricingService();
		tmsAccountService.setTmsAccountPricingServiceId(accountService.getId());

		tmsAccountService.setTmsAccountPricingServiceSaleAmountHt(accountService.getSaleAmountHt());
		tmsAccountService.setTmsAccountPricingServiceSaleAmountTtc(accountService.getSaleAmountTtc());
		tmsAccountService.setTmsAccountPricingServiceSaleAmountTva(accountService.getSaleAmountTva());

		if(!lazy){
			tmsAccountService.setCmdCompany(CompanyMapper.toEntity(accountService.getCompany(),true));
			tmsAccountService.setCmdAccount(AccountMapper.toEntity(accountService.getAccount(),true));

			tmsAccountService.setPdtProduct(ProductMapper.toEntity(accountService.getProduct(),true));
			tmsAccountService.setPrmSaleVat(VatMapper.toEntity(accountService.getSaleVat(),true));
			tmsAccountService.setOwnOwner(OwnerMapper.toEntity(accountService.getOwner(),true));




		}
		return tmsAccountService;
	}

	public static AccountPricingService toDto(TmsAccountPricingService tmsAccountService, boolean lazy) {
		if (null == tmsAccountService) {
			return null;
		}
		AccountPricingService accountService = new AccountPricingService();
		accountService.setId(tmsAccountService.getTmsAccountPricingServiceId());

		accountService.setSaleAmountHt(tmsAccountService.getTmsAccountPricingServiceSaleAmountHt());
		accountService.setSaleAmountTtc(tmsAccountService.getTmsAccountPricingServiceSaleAmountTtc());
		accountService.setSaleAmountTva(tmsAccountService.getTmsAccountPricingServiceSaleAmountTva());


		if(!lazy){
			accountService.setCompany(CompanyMapper.toDto(tmsAccountService.getCmdCompany(),true));
			accountService.setAccount(AccountMapper.toDto(tmsAccountService.getCmdAccount(),true));

			accountService.setProduct(ProductMapper.toDto(tmsAccountService.getPdtProduct(),true));
				accountService.setSaleVat(VatMapper.toDto(tmsAccountService.getPrmSaleVat(),true));
			accountService.setOwner(OwnerMapper.toDto(tmsAccountService.getOwnOwner(),true));

		}
		return accountService;

	}



	public static List<AccountPricingService> toDtos(Iterable<? extends TmsAccountPricingService> tmsAccountServices, boolean lazy) {
		if (null == tmsAccountServices) {
			return null;
		}
		List<AccountPricingService> accountServices = new ArrayList<>();

		for (TmsAccountPricingService tmsAccountService : tmsAccountServices) {
			accountServices.add(toDto(tmsAccountService, lazy));
		}
		return accountServices;
	}

	public static Set<TmsAccountPricingService> toEntities(List<AccountPricingService> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsAccountPricingService> tmsAccountServices = new HashSet<>();
		for (AccountPricingService accountService : list) {
			tmsAccountServices.add(toEntity(accountService, lazy));
		}
		return tmsAccountServices;
	}

	public static List<AccountPricingService> toDtos(List<TmsAccountPricingService> tmsAccountServices, boolean lazy) {
		if (null == tmsAccountServices) {
			return null;
		}
		List<AccountPricingService> accountServices = new ArrayList<>();
		for (TmsAccountPricingService tmsAccountService : tmsAccountServices) {
			accountServices.add(toDto(tmsAccountService, lazy));
		}
		return accountServices;
	}
}
