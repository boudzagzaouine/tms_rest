package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ContractAccount;
import com.bagile.gmo.entities.TmsContractAccount;

import java.util.*;

public class ContractAccountMapper {
	public ContractAccountMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsContractAccountId");
		map.put("code", "tmsContractAccountCode");
		map.put("account", "cmdAccount");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsContractAccount toEntity(ContractAccount contractAccount, boolean lazy) {
		if (null == contractAccount) {
			return null;
		}
		TmsContractAccount tmsContractAccount = new TmsContractAccount();
		tmsContractAccount.setTmsContractAccountId(contractAccount.getId());
		tmsContractAccount.setTmsContractAccountCode(contractAccount.getCode() != null ? contractAccount.getCode().toUpperCase() : null);
		tmsContractAccount.setTmsContractAccountDate(contractAccount.getDate());
		tmsContractAccount.setTmsContractAccountContractType(contractAccount.getContractType());
		tmsContractAccount.setTmsContractAccountQuantity(contractAccount.getQuantity());
		tmsContractAccount.setTmsContractAccountStartDate(contractAccount.getStartDate());
		tmsContractAccount.setTmsContractAccountEndDate(contractAccount.getEndDate());
		tmsContractAccount.setTmsContractAccountPrice(contractAccount.getPrice());
		tmsContractAccount.setTmsContractAccountPackageType(contractAccount.getPackageType());


		if(!lazy){
			tmsContractAccount.setGmoVehicleCategory(VehicleCategoryMapper.toEntity(contractAccount.getVehicleCategory(),true));
			tmsContractAccount.setAdrSenderAddress(AddressMapper.toEntity(contractAccount.getSenderAddress(),true));
			tmsContractAccount.setAdrReceiverAdresse(AddressMapper.toEntity(contractAccount.getReceiverAdresse(),true));


			tmsContractAccount.setCmdAccount(AccountMapper.toEntity(contractAccount.getAccount(),true));


		}
		return tmsContractAccount;
	}

	public static ContractAccount toDto(TmsContractAccount tmsContractAccount, boolean lazy) {
		if (null == tmsContractAccount) {
			return null;
		}
		ContractAccount contractAccount = new ContractAccount();
		contractAccount.setId(tmsContractAccount.getTmsContractAccountId());
		contractAccount.setCode(tmsContractAccount.getTmsContractAccountCode() != null ? tmsContractAccount.getTmsContractAccountCode().toUpperCase() : null);
		contractAccount.setDate(tmsContractAccount.getTmsContractAccountDate());
		contractAccount.setContractType(tmsContractAccount.getTmsContractAccountContractType());
		contractAccount.setStartDate(tmsContractAccount.getTmsContractAccountStartDate());
		contractAccount.setEndDate(tmsContractAccount.getTmsContractAccountEndDate());
		contractAccount.setPrice(tmsContractAccount.getTmsContractAccountPrice());
		contractAccount.setQuantity(tmsContractAccount.getTmsContractAccountQuantity());
		contractAccount.setPackageType(tmsContractAccount.getTmsContractAccountPackageType());

		if(!lazy){
			contractAccount.setVehicleCategory(VehicleCategoryMapper.toDto(tmsContractAccount.getGmoVehicleCategory(),false));
			contractAccount.setSenderAddress(AddressMapper.toDto(tmsContractAccount.getAdrSenderAddress(),false));
			contractAccount.setReceiverAdresse(AddressMapper.toDto(tmsContractAccount.getAdrReceiverAdresse(),false));
			contractAccount.setAccount(AccountMapper.toDto(tmsContractAccount.getCmdAccount(),false));


		}
		return contractAccount;

	}



	public static List<ContractAccount> toDtos(Iterable<? extends TmsContractAccount> tmsContractAccounts, boolean lazy) {
		if (null == tmsContractAccounts) {
			return null;
		}
		List<ContractAccount> contractAccounts = new ArrayList<>();

		for (TmsContractAccount tmsContractAccount : tmsContractAccounts) {
			contractAccounts.add(toDto(tmsContractAccount, lazy));
		}
		return contractAccounts;
	}

	public static Set<TmsContractAccount> toEntities(List<ContractAccount> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsContractAccount> tmsContractAccounts = new HashSet<>();
		for (ContractAccount contractAccount : list) {
			tmsContractAccounts.add(toEntity(contractAccount, lazy));
		}
		return tmsContractAccounts;
	}

	public static List<ContractAccount> toDtos(List<TmsContractAccount> tmsContractAccounts, boolean lazy) {
		if (null == tmsContractAccounts) {
			return null;
		}
		List<ContractAccount> contractAccounts = new ArrayList<>();
		for (TmsContractAccount tmsContractAccount : tmsContractAccounts) {
			contractAccounts.add(toDto(tmsContractAccount, lazy));
		}
		return contractAccounts;
	}
}
