package com.bagile.gmo.dto;

import java.math.BigDecimal;

public class PricingTransport {

	private long id;
	private String code;
	private Transport transport;




	private String TypeTarif; // variable - forfitaire

	private String weight;
	private long weightRangeMin;
	private long weightRangeMax;

	private String typeOfPackaging;


	private BigDecimal amountHt;
	private BigDecimal amountTtc;
	private BigDecimal amountTva;
	private PricingTransport pricing;
	private Vat vat;




}
