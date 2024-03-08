package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.AccountService;
import com.bagile.gmo.entities.TmsAccountService;

import java.util.*;

public class AccountServiceMapper {
	public AccountServiceMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsAccountServiceId");
		map.put("code", "tmsAccountServiceCode");
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

	public static TmsAccountService toEntity(AccountService accountService, boolean lazy) {
		if (null == accountService) {
			return null;
		}
		TmsAccountService tmsAccountService = new TmsAccountService();
		tmsAccountService.setTmsAccountServiceId(accountService.getId());

		tmsAccountService.setTmsAccountServiceSaleAmountHt(accountService.getSaleAmountHt());
		tmsAccountService.setTmsAccountServiceSaleAmountTtc(accountService.getSaleAmountTtc());
		tmsAccountService.setTmsAccountServiceSaleAmountTva(accountService.getSaleAmountTva());

		if(!lazy){
			tmsAccountService.setCmdCompany(CompanyMapper.toEntity(accountService.getCompany(),true));
			tmsAccountService.setAdrAddress(AddressMapper.toEntity(accountService.getAddress(),true));

			tmsAccountService.setPdtProduct(ProductMapper.toEntity(accountService.getProduct(),true));
			tmsAccountService.setPrmSaleVat(VatMapper.toEntity(accountService.getSaleVat(),true));
			tmsAccountService.setOwnOwner(OwnerMapper.toEntity(accountService.getOwner(),true));




		}
		return tmsAccountService;
	}

	public static AccountService toDto(TmsAccountService tmsAccountService, boolean lazy) {
		if (null == tmsAccountService) {
			return null;
		}
		AccountService accountService = new AccountService();
		accountService.setId(tmsAccountService.getTmsAccountServiceId());

		accountService.setSaleAmountHt(tmsAccountService.getTmsAccountServiceSaleAmountHt());
		accountService.setSaleAmountTtc(tmsAccountService.getTmsAccountServiceSaleAmountTtc());
		accountService.setSaleAmountTva(tmsAccountService.getTmsAccountServiceSaleAmountTva());


		if(!lazy){
			accountService.setCompany(CompanyMapper.toDto(tmsAccountService.getCmdCompany(),true));
			accountService.setAddress(AddressMapper.toDto(tmsAccountService.getAdrAddress(),true));

			accountService.setProduct(ProductMapper.toDto(tmsAccountService.getPdtProduct(),true));
				accountService.setSaleVat(VatMapper.toDto(tmsAccountService.getPrmSaleVat(),true));
			accountService.setOwner(OwnerMapper.toDto(tmsAccountService.getOwnOwner(),true));

		}
		return accountService;

	}



	public static List<AccountService> toDtos(Iterable<? extends TmsAccountService> tmsAccountServices, boolean lazy) {
		if (null == tmsAccountServices) {
			return null;
		}
		List<AccountService> accountServices = new ArrayList<>();

		for (TmsAccountService tmsAccountService : tmsAccountServices) {
			accountServices.add(toDto(tmsAccountService, lazy));
		}
		return accountServices;
	}

	public static Set<TmsAccountService> toEntities(List<AccountService> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsAccountService> tmsAccountServices = new HashSet<>();
		for (AccountService accountService : list) {
			tmsAccountServices.add(toEntity(accountService, lazy));
		}
		return tmsAccountServices;
	}

	public static List<AccountService> toDtos(List<TmsAccountService> tmsAccountServices, boolean lazy) {
		if (null == tmsAccountServices) {
			return null;
		}
		List<AccountService> accountServices = new ArrayList<>();
		for (TmsAccountService tmsAccountService : tmsAccountServices) {
			accountServices.add(toDto(tmsAccountService, lazy));
		}
		return accountServices;
	}
}
