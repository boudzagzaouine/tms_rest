
package com.bagile.gmo.dto;

import java.util.ArrayList;
import java.util.List;

public class PaymentRule {

	private long id;
	private PaymentType paymentType;
	private Boolean contreBL;
	private Boolean contreFacture;
	private byte[] file;
  private Owner owner;



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Boolean getContreBL() {
		return contreBL;
	}

	public void setContreBL(Boolean contreBL) {
		this.contreBL = contreBL;
	}

	public Boolean getContreFacture() {
		return contreFacture;
	}

	public void setContreFacture(Boolean contreFacture) {
		this.contreFacture = contreFacture;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
}
