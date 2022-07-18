package com.bagile.gmo.dto;

import java.math.BigDecimal;

public class PricingCIty {

	private long id;
	private String code;
	private Pays paysSource;
	private Ville villeSource ;
	private Pays paysDistination;
	private Ville villeDestination;
	private BigDecimal amountHt;
	private BigDecimal amountTtc;
	private BigDecimal amountTva;
	private Pricing pricing;
	private Vat vat;
	private Owner owner;




}
