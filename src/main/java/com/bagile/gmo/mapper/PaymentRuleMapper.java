package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.PaymentRule;
import com.bagile.gmo.entities.TmsPaymentRule;

import java.util.*;

public class PaymentRuleMapper {
	public PaymentRuleMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsPaymentRuleId");
		map.put("code", "tmsPaymentRuleCode");
		map.put("description", "tmsPaymentRuleDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsPaymentRule toEntity(PaymentRule paymentRule, boolean lazy) {
		if (null == paymentRule) {
			return null;
		}
		TmsPaymentRule tmsPaymentRule = new TmsPaymentRule();
		tmsPaymentRule.setTmsPaymentRuleId(paymentRule.getId());
		tmsPaymentRule.setTmsPaymentRulcontreBL(paymentRule.getContreBL());
		tmsPaymentRule.setTmsPaymentRuleContreFacture(paymentRule.getContreFacture());
		tmsPaymentRule.setTmsPaymentRuleFile(paymentRule.getFile());

		if(!lazy){
			tmsPaymentRule.setOwnOwner(OwnerMapper.toEntity(paymentRule.getOwner(),true));
			tmsPaymentRule.setPrmPaymentType(PaymentTypeMapper.toEntity(paymentRule.getPaymentType(),false));


		}
		return tmsPaymentRule;
	}

	public static PaymentRule toDto(TmsPaymentRule tmsPaymentRule, boolean lazy) {
		if (null == tmsPaymentRule) {
			return null;
		}
		PaymentRule paymentRule = new PaymentRule();
		paymentRule.setId(tmsPaymentRule.getTmsPaymentRuleId());
		paymentRule.setContreBL(tmsPaymentRule.getTmsPaymentRulcontreBL());
		paymentRule.setContreFacture(tmsPaymentRule.getTmsPaymentRuleContreFacture());
		paymentRule.setFile(tmsPaymentRule.getTmsPaymentRuleFile());

		if(!lazy){
			paymentRule.setPaymentType(PaymentTypeMapper.toDto(tmsPaymentRule.getPrmPaymentType(),false));

			paymentRule.setOwner(OwnerMapper.toDto(tmsPaymentRule.getOwnOwner(),true));

		}
		return paymentRule;

	}




	public static List<PaymentRule> toDtos(Iterable<? extends TmsPaymentRule> tmsPaymentRules, boolean lazy) {
		if (null == tmsPaymentRules) {
			return null;
		}
		List<PaymentRule> paymentRules = new ArrayList<>();

		for (TmsPaymentRule tmsPaymentRule : tmsPaymentRules) {
			paymentRules.add(toDto(tmsPaymentRule, lazy));
		}
		return paymentRules;
	}

	public static Set<TmsPaymentRule> toEntities(List<PaymentRule> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsPaymentRule> tmsPaymentRules = new HashSet<>();
		for (PaymentRule paymentRule : list) {
			tmsPaymentRules.add(toEntity(paymentRule, lazy));
		}
		return tmsPaymentRules;
	}

	public static List<PaymentRule> toDtos(List<TmsPaymentRule> tmsPaymentRules, boolean lazy) {
		if (null == tmsPaymentRules) {
			return null;
		}
		List<PaymentRule> paymentRules = new ArrayList<>();
		for (TmsPaymentRule tmsPaymentRule : tmsPaymentRules) {
			paymentRules.add(toDto(tmsPaymentRule, lazy));
		}
		return paymentRules;
	}
}
